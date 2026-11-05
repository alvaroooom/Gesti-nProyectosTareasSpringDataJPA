package com.gestionproyectos.javialvaro.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tarea {

    @Id
    @GeneratedValue
    private Long id;

    private String titulo;

    @Enumerated(EnumType.STRING)
    private EstadoTarea estado;

    @ManyToOne
    private Proyecto proyecto;

    @OneToMany(mappedBy = "tarea", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comentario> comentarios = new ArrayList<>();

    @ManyToMany
    private List<Etiqueta> etiquetas = new ArrayList<>();
}
