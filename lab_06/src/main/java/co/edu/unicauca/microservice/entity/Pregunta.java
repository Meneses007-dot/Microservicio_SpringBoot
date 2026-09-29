package co.edu.unicauca.microservice.entity;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

/**
 * Entidad que representa un ítem de evaluación de opción múltiple del modelo Saber PRO.
 *
 * <p>Cada ítem archivado en el banco de preguntas debe estar completo: lleva un título, un
 * enunciado, la competencia o categoría que evalúa, el tipo de pregunta, el conjunto de opciones
 * y la respuesta correcta, que debe ser una de esas opciones.
 */
@Entity
@Table(name = "preguntas")
public class Pregunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String titulo;

    @Column(nullable = false, length = 2000)
    private String enunciado;

    @Column(nullable = false, length = 100)
    private String competencia;

    @Column(nullable = false, length = 50)
    private String tipo;

    @ElementCollection
    @CollectionTable(name = "opciones_pregunta", joinColumns = @JoinColumn(name = "pregunta_id"))
    @Column(name = "opcion", nullable = false, length = 500)
    private List<String> opciones = new ArrayList<>();

    @Column(name = "respuesta_correcta", length = 500)
    private String respuestaCorrecta;

    public Pregunta() {
    }

    public Pregunta(String titulo, String enunciado, String competencia, String tipo,
            List<String> opciones, String respuestaCorrecta) {
        this.titulo = titulo;
        this.enunciado = enunciado;
        this.competencia = competencia;
        this.tipo = tipo;
        this.opciones = new ArrayList<>(opciones);
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public String getCompetencia() {
        return competencia;
    }

    public void setCompetencia(String competencia) {
        this.competencia = competencia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<String> getOpciones() {
        return opciones;
    }

    public void setOpciones(List<String> opciones) {
        this.opciones = opciones;
    }

    public String getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public void setRespuestaCorrecta(String respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }
}
