# Appointment Scheduler

A microservice for managing client appointments with specialists.

## Description

RESTful API for appointment booking system. Clients can select convenient time slots from specialists across various domains.

**Use cases:** banking consultations, medical appointments, consulting services, tutoring.

## Features

- Specialist management (create, view, edit)
- Working schedule configuration for each specialist
- Available time slot viewing
- Client appointment booking
- Automatic time conflict detection
- Appointment status management (scheduled, completed, cancelled)

## Tech Stack

- **Java 17**
- **Spring Boot 3.3.0**
- **Spring Data JPA** — database interaction
- **PostgreSQL** — relational database
- **Liquibase** — database schema versioning
- **Lombok** — boilerplate code reduction
- **MapStruct** — Entity-DTO mapping
- **Swagger/OpenAPI** — automatic API documentation

## Requirements

- Java 17+
- PostgreSQL 12+
- Maven 3.6+ (or use included Maven Wrapper)

## Installation & Setup

### 1. Clone the repository
```bash
git clone https://github.com/linx7a/appointment-scheduler.git
cd appointment-scheduler
```

### 2. Create PostgreSQL database
```sql
CREATE DATABASE appointment_scheduler;
```

### 3. Configure database connection

Create file `src/main/resources/application-local.yml`:
```yaml
spring:
  datasource:
    password: your_postgres_password
```

### 4. Run the application

Using Maven Wrapper:
```bash
./mvnw spring-boot:run          # Linux/Mac
mvnw.cmd spring-boot:run        # Windows
```

Or with installed Maven:
```bash
mvn spring-boot:run
```

### 5. Access API documentation

Swagger UI: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## Project Structure
```
src/
├── main/
│   ├── java/com/example/scheduler/
│   │   ├── controller/      # REST controllers
│   │   ├── service/         # Business logic
│   │   ├── repository/      # Data access (Spring Data JPA)
│   │   ├── domain/          # Entities (database models)
│   │   ├── dto/             # Data Transfer Objects
│   │   ├── mapper/          # MapStruct mappers
│   │   └── exception/       # Error handling
│   └── resources/
│       ├── application.yml         # Application configuration
│       ├── application-local.yml   # Local settings (not in Git)
│       └── db/changelog/           # Liquibase migrations
└── test/                           # Tests
```

## Architecture

The project follows classic layered architecture:

- **Controller Layer** — REST endpoints, input validation
- **Service Layer** — business logic, transactions
- **Repository Layer** — data access via Spring Data JPA
- **Domain Layer** — Entity classes mapped to database tables

## About

Pet project demonstrating microservice development skills with Java/Spring Boot.

---

**License:** MIT