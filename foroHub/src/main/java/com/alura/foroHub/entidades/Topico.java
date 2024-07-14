package com.alura.foroHub.entidades;

import com.alura.foroHub.DTO.DatosActualizarTopico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table (name="topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id_topico")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_topico")
    private Long idTopico;

    @Column(unique = true)
    private String titulo;

    @Column(unique = true)
    private String mensaje;
    @Column(name="fecha_creacion")
    private String fechaCreacion;

    private boolean status;
    @ManyToOne
    @JoinColumn(name="id_curso_fk")
    private Curso curso;

    @ManyToOne
    @JoinColumn(name="id_autor_fk")
    private Autor autor;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "topico", cascade = CascadeType.ALL)
    private List<Respuesta> respuesta;


    public Topico(Topico vaciarDatos) {
        this.titulo=vaciarDatos.titulo;
        this.mensaje= vaciarDatos.mensaje;
        this.fechaCreacion=vaciarDatos.fechaCreacion;
        this.status= vaciarDatos.status;
        this.curso= vaciarDatos.curso;
        this.autor=vaciarDatos.autor;
    }

    public Topico(Topico vaciarDatos,List<Respuesta> respuesta) {
        this.titulo=vaciarDatos.titulo;
        this.mensaje= vaciarDatos.mensaje;
        this.fechaCreacion=vaciarDatos.fechaCreacion;
        this.status= vaciarDatos.status;
        this.curso= vaciarDatos.curso;
        this.autor=vaciarDatos.autor;
        this.respuesta=respuesta;
    }

    public List<Respuesta> getRespuesta() {
        return respuesta;
    }

    public void desactivarTopico() {
        this.status=false;
    }

    public void setRespuesta(List<Respuesta> respuesta) {
        this.respuesta = respuesta;
    }



    public void actualizarDatos(DatosActualizarTopico datosActualizarTopico) {


            this.status = datosActualizarTopico.status();



        if(datosActualizarTopico.titulo() != null){
            this.titulo = datosActualizarTopico.titulo();
        }

        if(datosActualizarTopico.mensaje() != null){

            this.mensaje = datosActualizarTopico.mensaje();
        }

    }





}
