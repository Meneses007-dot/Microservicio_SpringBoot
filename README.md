# Taller 06 — API REST Banco de Preguntas Saber PRO

Microservicio **Spring Boot** que administra un banco de preguntas de opción múltiple (modelo Saber PRO).

## Requisitos

- JDK 26
- Maven 3.9+ (o usar el wrapper `./mvnw`)

## Cómo ejecutarlo

```bash
cd lab_06
./mvnw spring-boot:run
```

La API queda en `http://localhost:8080` y la consola H2 en `http://localhost:8080/h2-console`
(URL JDBC `jdbc:h2:mem:banco_preguntas`, usuario `sa`, sin contraseña). La base de datos es **en memoria**: se borra al apagar la aplicación.

## Endpoints

Base: `/api/preguntas`

| Método | Ruta         | Descripción                    | Respuesta |
|--------|--------------|--------------------------------|-----------|
| GET    | `/`           | Listar todas las preguntas      | 200       |
| GET    | `/{id}`       | Consultar una pregunta por ID   | 200 / 404 |
| POST   | `/`           | Crear una pregunta              | 201       |
| PUT    | `/{id}`       | Actualizar una pregunta         | 200 / 404 |
| DELETE | `/{id}`       | Eliminar una pregunta           | 204 / 404 |

### Ejemplo de JSON

```json
{
  "titulo": "Proporción directa",
  "enunciado": "Si 3 cuadernos cuestan 15000 pesos, ¿cuánto cuestan 7 cuadernos?",
  "competencia": "Razonamiento Cuantitativo",
  "tipo": "SELECCION_MULTIPLE",
  "opciones": ["30000", "35000", "40000", "45000"],
  "respuestaCorrecta": "35000"
}
```

## Pruebas

```bash
cd lab_06
./mvnw test
```

## Colección Postman

En `postman/collections/` está la colección **"Banco de Preguntas Saber PRO"** (formato Postman para IA, archivos `.yaml`) con el CRUD completo y pruebas automáticas. La variable `baseUrl` ya apunta a `http://localhost:8080`.

Ejecuta las carpetas en este orden:

1. `1. Datos de prueba (POST)` — crea los registros
2. `2. Crear y editar (POST - PUT)` — el POST guarda el `id` devuelto en `{{id}}`
3. `3. Consultas (GET)`
4. `4. Eliminar (DELETE)`

También está la colección clásica en `lab_06/postman/BancoPreguntasSaberPro.postman_collection.json` para importar en la app de escritorio.

## Estructura

```
lab_06/                          # proyecto Maven
├── src/main/java/co/edu/unicauca/microservice/
│   ├── controller/              # PreguntaController - endpoints REST
│   ├── service/                 # IPreguntaService + PreguntaServiceImpl - lógica de negocio
│   ├── repository/              # PreguntaRepository - acceso a datos (JPA)
│   ├── entity/                  # Pregunta - entidad JPA
│   └── MicroservicioLab06Application.java
└── src/main/resources/application.properties
postman/                         # colección Postman (formato IA)
```
