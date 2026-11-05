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
public class Proyecto {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    private String descripcion;

    // Bidireccional: el lado propietario es Tarea (tiene la clave ajena)
    @OneToMany(mappedBy = "proyecto")
    private List<Tarea> tareas = new ArrayList<>();

    // Métodos helper para mantener sincronizados los dos lados

    public void addTarea(Tarea tarea) {
        tareas.add(tarea);
        tarea.setProyecto(this);
    }

    public void removeTarea(Tarea tarea) {
        tareas.remove(tarea);
        tarea.setProyecto(null);
    }
}
