package com.gestionproyectos.javialvaro.repository;

import com.gestionproyectos.javialvaro.model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {

    List<Comentario> findByTareaId(Long tareaId);
}
