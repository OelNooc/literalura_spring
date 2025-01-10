# Literalura Spring
Literalura Spring es un proyecto backend desarrollado con Spring Boot que proporciona servicios para una aplicación de gestión de literatura.
## Requisitos Previos

Java 17
Maven 3.6.3 o superior
PostgreSQL 12 o superior

## Tecnologías Utilizadas

Spring Boot 3.3.0
Spring Data JPA
PostgreSQL
Jackson (para manejo de JSON)
Maven (gestión de dependencias)

## Configuración del Proyecto

1. Clonar el repositorio:
   ```bash
   git clone https://github.com/OelNooc/literalura_spring.git
   cd literalura_spring
2. Configura la base de datos PostgreSQL:
  Crea una base de datos para el proyecto
  Actualiza las credenciales en src/main/resources/application.properties
3. Instalar las dependencias:
   ```bash
   mvn clean install
4. Ejecutar la aplicación:
    ```bash
   mvn spring-boot:run

## Configuración de Desarrollo
El proyecto incluye Spring Boot DevTools para mejorar la experiencia de desarrollo con:

  Reinicio automático cuando se detectan cambios
  Configuración de desarrollo por defecto
  Capacidades de depuración mejoradas
