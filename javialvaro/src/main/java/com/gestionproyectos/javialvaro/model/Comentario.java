package com.gestionproyectos.javialvaro.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Comentario {

    @Id
    @GeneratedValue
    private Long id;

    private String texto;

    private String autor;

    // Lado propietario de la relación con Tarea
    @ManyToOne
    private Tarea tarea;
}
