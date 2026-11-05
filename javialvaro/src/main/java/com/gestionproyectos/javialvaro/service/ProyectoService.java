package com.gestionproyectos.javialvaro.service;

import com.gestionproyectos.javialvaro.model.Proyecto;
import com.gestionproyectos.javialvaro.repository.ProyectoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProyectoService {

    private final ProyectoRepository proyectoRepository;

    public Proyecto guardar(Proyecto proyecto) {
        return proyectoRepository.save(proyecto);
    }

    public List<Proyecto> listarTodos() {
        return proyectoRepository.findAll();
    }
}
