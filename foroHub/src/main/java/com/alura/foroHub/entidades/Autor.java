package com.alura.foroHub.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="autor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id_autor")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_autor")
    private Long idAutor;
    private String nombre;
    @Email
    private String email;
    private String contrasena;

    @ManyToOne
    @JoinColumn(name="id_perfiles_fk")
    private Perfiles perfiles;

}
