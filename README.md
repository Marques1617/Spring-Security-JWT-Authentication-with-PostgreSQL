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

### 🔗 Ligação entre Controller, Service e Repository

## 1. Controller

   . Camada mais externa, expõe os endpoints da API (/login, /register, /students, etc.)

   . Recebe requisições HTTP do cliente (Postman, browser, etc.)

   . Chama o Service para processar a lógica de negócio

## 2. Service

   . Camada intermediária, contém a lógica de negócio

   . Valida dados, aplica regras, chama Repository para acessar o banco de dados
 
   . Pode também gerar tokens JWT ou executar outras operações complexas

## 3. Repository

   . Camada mais interna, responsável por acessar o banco de dados

   . Usa Spring Data JPA (JpaRepository) para CRUD

   . Não contém lógica de negócio — só operações de leitura/escrita no banco
