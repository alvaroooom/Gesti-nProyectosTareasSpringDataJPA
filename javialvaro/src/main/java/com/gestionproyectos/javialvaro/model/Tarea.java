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

    // Lado propietario de la relación con Proyecto
    @ManyToOne
    private Proyecto proyecto;

    // Unidireccional: Tarea es la propietaria y crea la tabla intermedia
    @ManyToMany
    private List<Etiqueta> etiquetas = new ArrayList<>();

    // Bidireccional con Comentario. Con cascade, al guardar la tarea se guardan sus comentarios
    @OneToMany(mappedBy = "tarea", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comentario> comentarios = new ArrayList<>();

    // Métodos helper para mantener sincronizados los dos lados

    public void addComentario(Comentario comentario) {
        comentarios.add(comentario);
        comentario.setTarea(this);
    }

    public void removeComentario(Comentario comentario) {
        comentarios.remove(comentario);
        comentario.setTarea(null);
    }
}
