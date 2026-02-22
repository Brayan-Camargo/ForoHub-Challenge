# ForoHub - Challenge Alura 🚀

![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.3.0-brightgreen?style=for-the-badge&logo=springboot)
![MySQL](https://img.shields.io/badge/MySQL-8.0-blue?style=for-the-badge&logo=mysql)
![JWT](https://img.shields.io/badge/JWT-Tokens-black?style=for-the-badge&logo=jsonwebtokens)

**ForoHub** es una API REST desarrollada para el Challenge de Alura Latam, diseñada para simular el funcionamiento de un foro de discusión. El proyecto se centra en la gestión de tópicos (hilos de discusión), implementando seguridad robusta, validaciones y documentación automática.

---

## 🛠️ Funcionalidades

* **Autenticación de Usuarios**: Sistema de login seguro con generación de Tokens JWT.
* **Gestión de Tópicos (CRUD)**:
    * Registrar un nuevo tópico con validaciones (Bean Validation).
    * Listar todos los tópicos con paginación.
    * Actualizar datos de un tópico específico.
    * Eliminar tópicos de forma persistente.
* **Seguridad**: Control de acceso Stateless mediante filtros personalizados y encriptación de contraseñas con BCrypt.
* **Manejo de Errores**: Respuestas JSON estandarizadas para errores 404 (Not Found) y 400 (Bad Request).
* **Documentación**: Interfaz interactiva de Swagger UI para probar la API desde el navegador.

---

## 💻 Tecnologías Utilizadas

* **Java 21**: Lenguaje de programación principal.
* **Spring Boot 4.0.3**: Framework para el desarrollo ágil de la API.
* **Spring Data JPA / Hibernate**: Para el mapeo objeto-relacional y persistencia.
* **MySQL**: Base de datos relacional.
* **Flyway**: Gestión de migraciones de la base de datos.
* **Lombok**: Para reducir el código repetitivo (Boilerplate).
* **Auth0 JWT**: Implementación de JSON Web Tokens.
* **SpringDoc OpenAPI**: Generación automática de documentación Swagger.

---

## 🚀 Instalación y Ejecución

1.  **Clonar el repositorio**:
    ```bash
    git clone [https://github.com/Brayan-Camargo/forohub.git](https://github.com/Brayan-Camargo/forohub.git)
    ```
2.  **Configurar la Base de Datos**:
    * Crea una base de datos en MySQL llamada `forohub_api`.
    * Actualiza tus credenciales en el archivo `src/main/resources/application.properties`.
3.  **Ejecutar la aplicación**:
    Puedes usar tu IDE preferido (como IntelliJ IDEA) o la terminal:
    ```bash
    ./mvnw spring-boot:run
    ```

---

## 📖 Documentación de la API

Una vez iniciada la aplicación, puedes acceder a la documentación interactiva en:
👉 `http://localhost:8080/swagger-ui.html`

> **Nota**: Para probar los endpoints protegidos, primero debes generar un token en `/login` y usarlo en el botón **"Authorize"** de Swagger.

---

## 👤 Autor

**Brayan Camargo**
* GitHub: [@Brayan-Camargo](https://github.com/Brayan-Camargo)

---
Desarrollado como parte del programa Alura Latam - 2026.