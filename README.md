# Práctica 7: Persistencia con Queries
Isabela Goetsch Abella & Pedro Cuevas Olarte

---

## Introducción

Nuestra práctica final consistirá en un portal de ofertas de empleo. Para esta práctica, hemos utilizado una base de datos basada en dos tablas relacionadas con la práctica final:

- OFFERS: que recoge las distintas ofertas de empleo
- APPLICATIONS: que recoge cada aplicación a una oferta


## Contenido de la práctica

- Desarrollo de una App de Spring Boot que incluya una funcionalidad que permita persistir información utilizando la librería Spring Data JDBC con una base de datos H2.
- Creación de una API que permita realizar operaciones INSERT, UPDATE, SELECT y DELETE con las dos tablas
- Uso de anotaciones @Query para usar sentencias SQL. 3 de ellas son operaciones JOIN
- De manera adicional, hemos creado parte del frontEnd relacionado con la práctica final, que permite una interacción con la API de manera más user-friendly