package com.gestionproyectos.javialvaro.service;

import com.gestionproyectos.javialvaro.model.Etiqueta;
import com.gestionproyectos.javialvaro.model.Tarea;
import com.gestionproyectos.javialvaro.repository.TareaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TareaService {

    private final TareaRepository tareaRepository;

    public Tarea guardar(Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    public List<Tarea> listarTodos() {
        return tareaRepository.findAll();
    }

    public Optional<Tarea> buscarPorId(Long id) {
        return tareaRepository.findById(id);
    }

    public void eliminar(Long id) {
        // Sus comentarios se borran solos por el cascade de Tarea.comentarios
        tareaRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public void mostrarDetalle(Long id) {
        Tarea tarea = tareaRepository.findById(id).orElse(null);

        if (tarea == null) {
            System.out.println("No existe la tarea con id " + id);
            return;
        }

        System.out.println("Tarea: " + tarea.getTitulo());

        System.out.println("Número de comentarios: " + tarea.getComentarios().size());

        System.out.println("Etiquetas:");
        for (Etiqueta etiqueta : tarea.getEtiquetas()) {
            System.out.println(" - " + etiqueta.getNombre());
        }
    }
}
