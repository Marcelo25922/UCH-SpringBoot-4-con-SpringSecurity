# Sistema de Gestión de Postulantes - pu4s16

Sistema web para gestionar postulantes a diferentes puestos de trabajo con autenticación y autorización basada en roles.

## Características

- Gestión completa de postulantes (CRUD)
- Autenticación con Spring Security desde base de datos
- Contraseñas encriptadas con BCrypt
- Control de acceso basado en roles (USER, MANAGER, ADMIN)
- Stored Procedures para operaciones de base de datos
- Interfaz estilo Twitter con diseño responsive

## Tecnologías

- Spring Boot 3.2.0
- Spring Security
- Spring Data JPA
- MySQL
- Thymeleaf
- Bootstrap 5
- Font Awesome

## Configuración

1. Crear la base de datos ejecutando los scripts en orden:
   - `01_create_database.sql`
   - `02_stored_procedures.sql`
   - `03_insert_data.sql`

2. Configurar conexión MySQL en `application.properties`

3. Ejecutar la aplicación: `mvn spring-boot:run`

4. Acceder a: `http://localhost:8080`

## Usuarios de Prueba

| Usuario | Contraseña | Rol | Permisos |
|---------|------------|-----|----------|
| estudiante | estudiante2025 | ROLE_USER | Solo visualizar |
| docente | docente2025 | ROLE_MANAGER | Ver, crear, editar, borrar |
| administrador | admin2025 | ROLE_ADMIN | Control total |

## Estructura del Proyecto

\`\`\`
pu4s16/
├── src/main/java/com/springboot/
│   ├── controllers/       # Controladores web y seguridad
│   ├── models/
│   │   ├── entitys/      # Entidades JPA
│   │   ├── repository/   # Repositorios con stored procedures
│   │   ├── services/     # Interfaces de servicios
│   │   └── servicesImpl/ # Implementaciones de servicios
│   └── util/             # Utilidades (encriptación)
├── src/main/resources/
│   ├── templates/        # Vistas Thymeleaf
│   ├── sql/             # Scripts de base de datos
│   └── application.properties
└── pom.xml
