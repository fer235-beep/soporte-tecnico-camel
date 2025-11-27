#  Sistema de Tickets de Soporte Técnico
**Proyecto desarrollado con Spring Boot 4 + Apache Camel + Maven + Docker**

Este sistema permite gestionar tickets de soporte técnico, permitiendo:
- Crear tickets
- Listar tickets
- Cerrar tickets
- Procesar eventos mediante Apache Camel

Incluye persistencia con **H2 Database**, arquitectura por capas y despliegue con **Docker**.

---

##  Tecnologías utilizadas

- **Java 17**
- **Spring Boot 4**
- **Spring Web**
- **Spring Data JPA**
- **H2 Database**
- **Apache Camel 4.7**
- **Maven**
- **Docker**

---

##  Arquitectura del proyecto
```
/src
└── /main
├── /java/com.ferni.consultas_camel
│ ├── controller → Controladores REST
│ ├── service → Lógica de negocio
│ ├── repository → Acceso a datos con JPA
│ ├── model → Entidades
│ └── routes → Rutas de Apache Camel
└── /resources
└── application.properties
```

---

## Endpoints de la API

###  Listar tickets
`GET /tickets`

###  Crear ticket
`POST /tickets`

Body JSON:
```json
{
  "usuario": "Ferni",
  "motivo": "Mi computadora no prende"
}
```
### Cerrar ticket

`PUT /tickets/{id}/cerrar`

---

## Acceder a la base de datos H2

Abrir en el navegador:

`http://localhost:8080/h2-console`

Configurar:

- **JDBC URL: jdbc:h2:mem:ticketsdb**

- **User: sa**

- **Password: (vacío)**

---

## Apache Camel

El proyecto incluye dos rutas Camel:

- **`direct:nuevo-ticket` → registra logs de creación**

- **`direct:cierre-ticket` → registra logs de cierre**

Se muestran en la consola al iniciar la aplicación.

---

## Ejecutar con Docker

- 1.Generar el .jar:

```mvn clean package -DskipTests```


- 2.Construir la imagen:

```docker build -t soporte-tecnico-camel .```

- 3.Correr el contenedor:

```docker run -p 8080:8080 soporte-tecnico-camel```

---

## Estado del proyecto

- Funcional

- Endpoints probados con Postman

- Camel operativo

- BD H2 funcionando

- Versionado en GitHub