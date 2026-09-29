package co.edu.unicauca.microservice.service;

import co.edu.unicauca.microservice.entity.Pregunta;
import co.edu.unicauca.microservice.repository.PreguntaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PreguntaServiceImpl implements IPreguntaService {

    private final PreguntaRepository repositorio;

    public PreguntaServiceImpl(PreguntaRepository repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public List<Pregunta> listarTodos() {
        return repositorio.findAll();
    }

    @Override
    public Pregunta buscarPorId(Long id) {
        return repositorio.findById(id).orElseThrow(() -> new RuntimeException("Pregunta no encontrada con id: " + id));
    }

    @Override
    public Pregunta crear(Pregunta pregunta) {
        return repositorio.save(pregunta);
    }

    @Override
    public Pregunta actualizar(Long id, Pregunta pregunta) {
        Pregunta existente = buscarPorId(id);
        existente.setTitulo(pregunta.getTitulo());
        existente.setEnunciado(pregunta.getEnunciado());
        existente.setCompetencia(pregunta.getCompetencia());
        existente.setTipo(pregunta.getTipo());
        existente.setOpciones(new ArrayList<>(pregunta.getOpciones()));
        existente.setRespuestaCorrecta(pregunta.getRespuestaCorrecta());
        return repositorio.save(existente);
    }

    @Override
    public void eliminar(Long id) {
        Pregunta existente = buscarPorId(id);
        repositorio.delete(existente);
    }
}
