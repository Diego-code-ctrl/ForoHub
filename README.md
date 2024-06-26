# Foro de Cursos y Tópicos API

Este proyecto es una API para un foro de cursos y tópicos, desarrollada utilizando Java, Spring Boot, JPA, Hibernate y PostgreSQL. La API permite a los usuarios crear, leer, 
actualizar y eliminar cursos y tópicos, y está protegida por Spring Security.

## Tecnologías Utilizadas

- **Java**: Lenguaje de programación principal utilizado para el desarrollo del proyecto.
- **Spring Boot**: Framework utilizado para simplificar la configuración y el desarrollo de aplicaciones Java.
- **Spring Data JPA**: Utilizado para interactuar con la base de datos de una manera sencilla y eficiente.
- **Hibernate**: Implementación de JPA utilizada para el mapeo objeto-relacional.
- **PostgreSQL**: Sistema de gestión de bases de datos utilizado.
- **Spring Security**: Framework de seguridad utilizado para proteger la API.

## Funcionalidades

- **Gestión de Cursos**: Crear, leer, actualizar y eliminar cursos.
- **Gestión de Tópicos**: Crear, leer, actualizar y eliminar tópicos asociados a los cursos.
- **Autenticación y Autorización**: Implementada utilizando Spring Security para proteger los endpoints de la API.

## Requisitos

- Java 21 o superior
- Maven 3.6.0 o superior
- PostgreSQL 10 o superior


## Seguridad

La API está protegida por Spring Security. Se requiere autenticación para acceder a los endpoints de creación, actualización y eliminación. La configuración de seguridad se puede encontrar en la clase `SecurityConfig`.


