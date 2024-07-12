package com.alura.foroHub.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name="respuesta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id_respuesta")
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_respuesta")
    private Long idRespuesta;

    private String mensaje;
    @Column(name="fecha_respuesta")
    private Date fechaRespuesta;

    private String solucion;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_autor_fk")
    private Autor autor;

   @ManyToOne
    @JoinColumn(name="id_topico_fk")
    private Topico topico;


    public void setTopico(Topico topico) {
        this.topico = topico;
    }

}
