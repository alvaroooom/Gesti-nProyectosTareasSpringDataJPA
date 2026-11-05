package com.gestionproyectos.javialvaro.repository;

import com.gestionproyectos.javialvaro.model.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {
}
