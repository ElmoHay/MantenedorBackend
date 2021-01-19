## MantenedorBackend
Desafío técnico Mantenedor N°1

Candidato: José Mura

Se implementa el backend del desafío tecnico en Spring Boot, principalmente basado en los "Starters"

Motor Relacional:     **H2 portable DB**

Persistencia (ORM):   spring-boot-starter-data-jpa (**Spring JPA**)

El código se estructura aplicando patrón "repositorio". Se separan: **controlador/servcio/repositorio/modelo**

No se requiere levantar ninguna base de datos aparte. El aplicativo levanta automáticamente una instancia de la base de datos portátil H2. Se indican los scripts en el presente README


# Instrucciones de despliege:

1. clonar este repositorio en la máquina personal

2. en la línea de comandos, ejecutar con Maven:

`mvn spring-boot:run`

3. comprobar visualizando que la instancia de tomcat está corriendo, visitar en tu navegador preferido:

`http://localhost:8082/tareas/listar`


## Funcionalidades implementadas: Se exponen los siguientes endpoints

[GET] Listar tareas (todas)

`http://localhost:8082/tareas/listar`

[GET] Listar tarea específica (ej. tarea id=1)

`http://localhost:8082/tareas/listar/1`

[POST] Agregar una tarea [campos obligatorios: descripcion, fechaCreacion, vigente (true|false)] (se auto genera el identificador)

`http://localhost:8082/tareas`

[DELETE] Remover una tarea  (ej. tarea id=5)

`http://localhost:8082/tareas/5`

[PUT] Editar una tarea (ej. tarea id=4)

`http://localhost:8082/tareas/4`


## Scripts sql

`src/main/resources/data.sql` 

`src/main/resources/schema.sql`


## Pruebas unitarias

en terminal, posicionarse en el directorio raíz del proyecto y ejecutar: 

`mvn test`


## Swagger

desplegar proyecto y visitar url 

`http://localhost:8082/swagger-ui/`

_nota : para utilizar Swagger en este proyecto se utilizó dependencia maven_ `springfox-boot-starter`


## Validaciones Agregar/Editar

los siguientes campos no pueden ser vacíos:
- descripcion
- fechaCreacion
- vigente

De lo contrario arrojará error 500. debido a javax.validation.ConstraintViolationException 

se aplicó la implementación de JSR-380 sobre dichos campos en el modelo `Tarea.class`