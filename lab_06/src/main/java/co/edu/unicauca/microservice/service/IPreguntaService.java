package co.edu.unicauca.microservice.service;

import co.edu.unicauca.microservice.entity.Pregunta;

import java.util.List;

public interface IPreguntaService {

    List<Pregunta> listarTodos();

    Pregunta buscarPorId(Long id);

    Pregunta crear(Pregunta pregunta);

    Pregunta actualizar(Long id, Pregunta pregunta);

    void eliminar(Long id);
}
