package co.edu.unicauca.microservice.repository;

import co.edu.unicauca.microservice.entity.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PreguntaRepository extends JpaRepository<Pregunta, Long> {
}
