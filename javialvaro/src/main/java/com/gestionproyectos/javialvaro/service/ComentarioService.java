package com.gestionproyectos.javialvaro.service;

import com.gestionproyectos.javialvaro.repository.ComentarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ComentarioService {

    private final ComentarioRepository comentarioRepository;

    public long contar() {
        return comentarioRepository.count();
    }
}
