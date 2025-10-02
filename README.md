# Spring-Security-JWT-Authentication-with-PostgreSQL
This is a Spring Boot project that implements authentication and authorization using JWT (JSON Web Tokens).
The application connects to a PostgreSQL database to store user data and exposes REST APIs that can be tested using Postman.

Features

.  User registration & authentication
.  JWT Token generation on login
.  Stateless authentication (no session needed)
.  Custom Security Filter Chain
.  PostgreSQL database integration via Spring Data JPA
.  Role-based access control

🛠️ Technologies Used

Technology	        Description

Java 21	                Programming language
Spring Boot 3.5.6       Application framework
Spring Security	        Authentication & Authorization
JWT 			Token-based authentication
PostgreSQL		Database
Maven			Dependency management
Postman			API testing


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

2. Access Protected Route
```
GET /users
Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6...
▶️ Running the Project
mvn spring-boot:run
```



