# Company Microservices

Este proyecto es una simulación de una serie de microservicios diseñados para replicar la estructura de una compañía. Está enfocado en el uso de componentes de Spring Cloud para demostrar patrones y buenas prácticas en el desarrollo de microservicios.

## Tabla de Contenidos

- [Descripción](#descripción)
- [Arquitectura](#arquitectura)
- [Componentes Principales](#componentes-principales)
- [Requisitos Previos](#requisitos-previos)
- [Instalación](#instalación)
- [Logs con ELK Stack](#logs-con-elk-stack)
- [Contribuciones](#contribuciones)

---

## Descripción

El objetivo de este proyecto es proporcionar un entorno práctico para trabajar con microservicios y explorar conceptos avanzados de Spring Cloud. Los microservicios están diseñados para interactuar entre sí utilizando herramientas modernas de balanceo de carga, descubrimiento de servicios y resiliencia.

## Arquitectura

La arquitectura incluye los siguientes componentes:

1. **API Gateway**: Gestiona las solicitudes entrantes y realiza el balanceo de carga entre los microservicios.
2. **Config Server**: Centraliza las configuraciones de todos los microservicios, permitiendo actualizaciones dinámicas.
3. **Service Registry**: Registra y descubre los microservicios dinámicamente.
4. **Microservicio de Course**: Proporciona APIs para gestionar departamentos y se comunica con:
5. **Microservicio de Student**: API para gestionar los datos de los empleados, consumida por el microservicio de departamentos.

## Componentes Principales

### API Gateway
- Implementa balanceo de carga.
- Maneja rutas y filtros personalizados.

### Config Server
- Almacena configuraciones centralizadas.
- Compatible con Git para versionado.

### Service Registry
- Basado en **Spring Cloud Netflix Eureka**.
- Registra todos los microservicios para facilitar su descubrimiento.

### Microservicio de Course
- Comunicación vía **HttpExchange** con el microservicio de student.


### Microservicio de Student
- Proporciona operaciones CRUD básicas.

## Requisitos Previos

- **Java**: JDK 21 o superior.
- **Maven**: Para construir los proyectos.
- **Docker**: Para ejecutar el ELK stack y otros servicios.

## Instalación

1. Clona este repositorio:

2. Construye los microservicios con Maven:

3. Levanta el entorno Docker para ELK:

