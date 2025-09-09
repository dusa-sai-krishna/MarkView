# MarkView: A Spring Boot Application for Markdown Processing and Grammar Checking

MarkView is a secure Spring Boot application that provides Markdown to HTML conversion capabilities with integrated grammar checking functionality. The application implements JWT-based authentication and offers a RESTful API interface for managing Markdown documents.

The application combines robust security features through Spring Security with flexible document processing capabilities. It uses FlexMark for Markdown processing and integrates with PostgreSQL for persistent storage. Key features include user authentication, secure API endpoints, Markdown file management, and HTML conversion with built-in grammar validation.

## Repository Structure
```
.
├── src/                              # Source code root directory
│   ├── main/java/com/saiDeveloper/Spring_Boot_Starter_Template/
│   │   ├── config/                   # Security and JWT configuration
│   │   ├── controller/               # REST API endpoints
│   │   ├── exception/               # Custom exception handlers
│   │   ├── model/                   # Data models and entities
│   │   ├── repo/                    # Database repositories
│   │   ├── service/                 # Business logic implementation
│   │   └── MarkView.java           # Application entry point
│   └── main/resources/              # Application configuration files
├── pom.xml                          # Maven project configuration
├── mvnw                            # Maven wrapper script for Unix
└── mvnw.cmd                        # Maven wrapper script for Windows
```

## Usage Instructions
### Prerequisites
- Java 17 or higher
- PostgreSQL 12 or higher
- Maven 3.6+ (or use included Maven wrapper)
- Available ports: 8080 (API server)

### Installation

1. Clone the repository:
```bash
git clone <repository-url>
cd markview
```

2. Configure PostgreSQL:
```bash
# Create database
createdb markview

# Update application.properties with your database credentials
src/main/resources/application.properties
```

3. Build and run the application:
```bash
# Using Maven wrapper
./mvnw clean install
./mvnw spring-boot:run

# Or using installed Maven
mvn clean install
mvn spring-boot:run
```

### Quick Start
1. Register a new user:
```bash
curl -X POST http://localhost:8080/api/auth/register \
  -H "Content-Type: application/json" \
  -d '{"email":"user@example.com","password":"password123"}'
```

2. Login to get JWT token:
```bash
curl -X POST http://localhost:8080/api/auth/login \
  -H "Content-Type: application/json" \
  -d '{"email":"user@example.com","password":"password123"}'
```

3. Upload a Markdown file:
```bash
curl -X POST http://localhost:8080/api/markdown/upload \
  -H "Authorization: Bearer <your-jwt-token>" \
  -F "file=@example.md"
```

### More Detailed Examples

1. Convert Markdown to HTML:
```bash
curl -X GET http://localhost:8080/api/markdown/convert/{id} \
  -H "Authorization: Bearer <your-jwt-token>"
```

2. Fetch all Markdown documents:
```bash
curl -X GET http://localhost:8080/api/markdown/all \
  -H "Authorization: Bearer <your-jwt-token>"
```

### Troubleshooting

1. Database Connection Issues
- Error: "Could not connect to database"
- Solution: 
  ```bash
  # Verify PostgreSQL is running
  pg_isready -h localhost -p 5432
  
  # Check database credentials in application.properties
  cat src/main/resources/application.properties
  ```

2. JWT Authentication Issues
- Error: "Invalid token"
- Solution:
  - Ensure token is not expired (default expiration: 1 hour)
  - Verify token format in Authorization header
  - Check logs at `logs/application.log`

3. File Upload Issues
- Error: "File size exceeded"
- Solution:
  - Check file size limits in application.properties
  - Verify content type is multipart/form-data
  - Ensure file has .md extension

## Data Flow
The application processes Markdown documents through a secure pipeline that handles authentication, storage, and conversion.

```ascii
Client -> JWT Auth -> Controller -> Service Layer -> Repository
   ^                                    |
   |                                    v
   +--------------------< HTML Response + Grammar Check
```

Component interactions:
1. Client requests are authenticated using JWT tokens
2. Authenticated requests are routed to appropriate controllers
3. Service layer handles business logic and document processing
4. Repository layer manages persistent storage in PostgreSQL
5. Markdown conversion is handled by FlexMark library
6. Grammar checking is performed before HTML conversion
7. Responses are wrapped in standardized response objects
8. Error handling is managed through global exception handlers