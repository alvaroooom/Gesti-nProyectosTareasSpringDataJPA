package com.gestionproyectos.javialvaro;

import com.gestionproyectos.javialvaro.model.*;
import com.gestionproyectos.javialvaro.service.EtiquetaService;
import com.gestionproyectos.javialvaro.service.ProyectoService;
import com.gestionproyectos.javialvaro.service.TareaService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataSeed implements CommandLineRunner {

    private final ProyectoService proyectoService;
    private final TareaService tareaService;
    private final EtiquetaService etiquetaService;

    @Override
    public void run(String... args) {

        Proyecto web = new Proyecto();
        web.setNombre("Web corporativa");
        web.setDescripcion("Nueva web de la empresa");
        proyectoService.guardar(web);

        Proyecto app = new Proyecto();
        app.setNombre("App móvil");
        app.setDescripcion("Aplicación Android para clientes");
        proyectoService.guardar(app);

        Etiqueta urgente = new Etiqueta();
        urgente.setNombre("Urgente");
        etiquetaService.guardar(urgente);

        Etiqueta backend = new Etiqueta();
        backend.setNombre("Backend");
        etiquetaService.guardar(backend);

        Tarea t1 = new Tarea();
        t1.setTitulo("Diseñar la página de inicio");
        t1.setEstado(EstadoTarea.EN_PROGRESO);
        web.addTarea(t1);
        t1.getEtiquetas().add(urgente);

        Tarea t2 = new Tarea();
        t2.setTitulo("Crear la API de usuarios");
        t2.setEstado(EstadoTarea.PENDIENTE);
        web.addTarea(t2);
        t2.getEtiquetas().add(urgente);
        t2.getEtiquetas().add(backend);

        Tarea t3 = new Tarea();
        t3.setTitulo("Pantalla de login");
        t3.setEstado(EstadoTarea.FINALIZADA);
        app.addTarea(t3);

        Comentario c1 = new Comentario();
        c1.setTexto("Ya tengo el boceto hecho");
        c1.setAutor("Javi");
        t1.addComentario(c1);

        Comentario c2 = new Comentario();
        c2.setTexto("Falta revisar los colores");
        c2.setAutor("Álvaro");
        t1.addComentario(c2);

        Comentario c3 = new Comentario();
        c3.setTexto("Login terminado y probado");
        c3.setAutor("Javi");
        t3.addComentario(c3);

        tareaService.guardar(t1);
        tareaService.guardar(t2);
        tareaService.guardar(t3);
    }
}
