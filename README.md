# Spring-Security-JWT-Authentication-with-PostgreSQL
This is a Spring Boot project that implements authentication and authorization using JWT (JSON Web Tokens).
The application connects to a PostgreSQL database running inside a Docker container to store user data and exposes REST APIs that can be tested using Postman.

## Features

✅  User registration & authentication

✅  JWT Token generation on login

✅  Stateless authentication (no session needed)

✅  Custom Security Filter Chain

✅  PostgreSQL database integration via Spring Data JPA

✅  Role-based access control


🛠️ Technologies Used
| Technology        | Description                       |
|------------------|-----------------------------------|
| Java 21           | Programming language              |
| Spring Boot 3.5.6 | Application framework             |
| Spring Security   | Authentication & Authorization    |
| JWT               | Token-based authentication        |
| Docker	    | Database                          |
| Maven		    | Dependency management             |
|Postman	    | API testing                       |


## 🗄  ️ Database Configuraionn

### Application.properties
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/YOUR_DB
spring.datasource.username=YOUR_USER
spring.datasource.password=YOUR_PASSWORD
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```
## Docker-compose-yml
```
services:
  db:
    container_name: <YOUR_CONTAINER_NAME>
    image: postgres:latest
    environment:
      POSTGRES_USER: <YOUR_USER>
      POSTGRES_PASSWORD: <YOUR_PASSWORD>
      PGDATA: /data/postgres
    volumes:
      - db:/data/postgres
    ports:
      - "5332:5432"
    networks:
      - db
    restart: unless-stopped
  
networks:
  db:
    driver: bridge

volumes:
  db:

```

## Running the docker file

```docker compose up -d```

## ️ Access the Container

```docker exec -it <name_container> bash```

## 📬 Example Postman Usage

1. ### Login Request
```
POST /login
Content-Type: application/json

{
  "username": "john",
  "password": "1234"
}
```

### Response:
```
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6..."
}
```

### 2. Register

```
POST /register
Content-Type: application/json

{
  "username": "manuel",
  "password": "m123"
}
```

### Response:
```
{
    "id": 8,
    "username": "manuel",
    "password": "$2a$12$1RExLgAzo.GlBo/Z5i84Eu5kU5WSly4kV0MbbvCLl5JmUp2ZpY/6i"
}
```

### 3. Access Protected Route
```
GET /users
Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6...
```
▶**️ Running the Projec**t
```
mvn spring-boot:run
```

### 🔗 Connection between Controller, Service and Repository

## 1. Controller

   . Outermost layer, exposes the API endpoints (/login, /register, /students, etc.)

   . Receives HTTP requests from the client (Postman, browser, etc.)

   . Calls the Service layer to process business logic

## 2. Service

   . Intermediate layer that contains the business logic

   . Validates data, applies rules, and calls the Repository to access the database
 
   . Pode também gerar tokens JWT ou executar outras operações complexas

## 3. Repository

   . Innermost layer, responsible for accessing the database

   . Uses Spring Data JPA (JpaRepository) to perform CRUD operations

   . Does not contain business logic — only database read/write operations
