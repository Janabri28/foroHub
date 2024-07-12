package com.alura.foroHub.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="perfiles")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id_perfiles")
public class Perfiles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_perfiles")
    private Long idPerfiles;
    @Enumerated(EnumType.STRING)
    private Perfil perfil;

}
