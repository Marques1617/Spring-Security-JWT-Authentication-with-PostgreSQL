# Spring-Security-JWT-Authentication-with-PostgreSQL
This is a Spring Boot project that implements authentication and authorization using JWT (JSON Web Tokens).
The application connects to a PostgreSQL database to store user data and exposes REST APIs that can be tested using Postman.

Features

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
| PostgreSQL	    | Database                          |
| Maven		    | Dependency management             |
|Postman	    | API testing                       |


🗄️ Database Configuration (application.properties
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/YOUR_DB
spring.datasource.username=YOUR_USER
spring.datasource.password=YOUR_PASSWORD
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

📬 Example Postman Usage
1. Login Request
```
POST /login
Content-Type: application/json

{
  "username": "john",
  "password": "1234"
}
```

Response:
```
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6..."
}
```

2 .Register

```
POST /register
Content-Type: application/json

{
  "username": "manuel",
  "password": "m123"
}
```

Response:
```
{
    "id": 8,
    "username": "manuel",
    "password": "$2a$12$1RExLgAzo.GlBo/Z5i84Eu5kU5WSly4kV0MbbvCLl5JmUp2ZpY/6i"
}
```

3. Access Protected Route
```
GET /users
Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6...
```
▶️ Running the Project
```
mvn spring-boot:run
```


teste:
flowchart TD
    A[Cliente / Postman] --> B[Controller]
    B --> C[Service]
    C --> D[Repository]
    D --> E[PostgreSQL Database]
