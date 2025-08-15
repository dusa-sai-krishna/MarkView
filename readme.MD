# Spring Boot Auth Template

This Spring Boot template provides a ready-to-use authentication system with various configurations. Below are the key features:

## Features

### 1. JWT-based Authentication
- Secure authentication using JSON Web Tokens (JWT)
- Custom JWT filter implementation
- Spring Security configuration for protected endpoints

### 2. Request Validation
- Integrated Hibernate Validator for request validation
- Automatic validation of request bodies
- Built-in validation annotations support

### 3. Development Tools
- Lombok integration for reduced boilerplate code
- Spring Boot DevTools for automatic restarts and enhanced development experience

### 4. Database Configuration
- Configured to connect to PostgreSQL database
- Change the database connection properties in `application.properties` according to your setup

### 5. Logging Configuration
- Logback configuration for systematic logging
- Log files are saved after each application initialization
- Log file configuration can be found in `logback.xml`

## Getting Started
1. Clone this repository
2. Configure your PostgreSQL database connection in `application.properties`
3. Build the project using Maven: `mvn clean install`
4. Run the application: `mvn spring-boot:run`

## Note
Make sure to update the database configuration in `application.properties` according to your PostgreSQL setup before running the application.