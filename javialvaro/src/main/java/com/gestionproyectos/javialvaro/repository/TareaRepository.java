package com.gestionproyectos.javialvaro.repository;

import com.gestionproyectos.javialvaro.model.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TareaRepository extends JpaRepository<Tarea, Long> {
}
