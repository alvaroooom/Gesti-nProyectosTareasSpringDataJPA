package com.gestionproyectos.javialvaro.service;

import com.gestionproyectos.javialvaro.model.Etiqueta;
import com.gestionproyectos.javialvaro.repository.EtiquetaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EtiquetaService {

    private final EtiquetaRepository etiquetaRepository;

    public Etiqueta guardar(Etiqueta etiqueta) {
        return etiquetaRepository.save(etiqueta);
    }

    public long contar() {
        return etiquetaRepository.count();
    }
}
