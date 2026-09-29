package co.edu.unicauca.microservice.controller;

import co.edu.unicauca.microservice.entity.Pregunta;
import co.edu.unicauca.microservice.service.IPreguntaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/preguntas")
public class PreguntaController {

    private final IPreguntaService servicio;

    public PreguntaController(IPreguntaService servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public ResponseEntity<List<Pregunta>> listarTodos() {
        return ResponseEntity.ok(servicio.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pregunta> buscarPorId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(servicio.buscarPorId(id));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<Pregunta> crear(@RequestBody Pregunta pregunta) {
        Pregunta creada = servicio.crear(pregunta);
        return ResponseEntity.status(HttpStatus.CREATED).body(creada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pregunta> actualizar(@PathVariable Long id, @RequestBody Pregunta pregunta) {
        try {
            return ResponseEntity.ok(servicio.actualizar(id, pregunta));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        try {
            servicio.eliminar(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
