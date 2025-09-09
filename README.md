# 📝 MarkView - Markdown to HTML Converter

![Angular](https://img.shields.io/badge/Angular-20.0.0-red?style=flat-square&logo=angular)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.2-brightgreen?style=flat-square&logo=spring)
![Java](https://img.shields.io/badge/Java-17-orange?style=flat-square&logo=java)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Database-blue?style=flat-square&logo=postgresql)
![PrimeNG](https://img.shields.io/badge/PrimeNG-20.0.0-blue?style=flat-square)
![TailwindCSS](https://img.shields.io/badge/TailwindCSS-4.1.11-38B2AC?style=flat-square&logo=tailwind-css)

## 🚀 Overview

**MarkView** is a modern full-stack web application that allows users to upload Markdown files and convert them into beautifully formatted HTML. Built with Angular 20 frontend and Spring Boot 3.4.2 backend, it provides a seamless experience for markdown processing and conversion.

## ✨ Features

- 📤 **File Upload**: Upload `.md` and `.txt` files with drag-and-drop support
- 🔄 **Real-time Conversion**: Convert Markdown to HTML using FlexMark library
- 💾 **Persistent Storage**: Store uploaded files in PostgreSQL database
- 👀 **HTML Preview**: View converted HTML in a modal dialog
- 📋 **Copy to Clipboard**: Easy copying of generated HTML code
- 🎨 **Modern UI**: Beautiful interface with PrimeNG components and TailwindCSS
- 🌙 **Theme Support**: Light/Dark theme toggle functionality
- 📱 **Responsive Design**: Works seamlessly across all devices

## 🏗️ Architecture

```
┌─────────────────┐    HTTP/REST API    ┌─────────────────┐
│   Angular 20    │ ◄─────────────────► │  Spring Boot    │
│   Frontend      │                     │   Backend       │
│                 │                     │                 │
│ • PrimeNG       │                     │ • REST API      │
│ • TailwindCSS   │                     │ • FlexMark      │
│ • TypeScript    │                     │ • JPA/Hibernate │
└─────────────────┘                     └─────────────────┘
                                                 │
                                                 ▼
                                        ┌─────────────────┐
                                        │   PostgreSQL    │
                                        │    Database     │
                                        └─────────────────┘
```

## 🛠️ Tech Stack

### Frontend 🎨
- **Framework**: Angular 20.0.0
- **UI Library**: PrimeNG 20.0.0-rc.1 with PrimeIcons
- **Styling**: TailwindCSS 4.1.11 with PrimeUI integration
- **Language**: TypeScript 5.8.2
- **HTTP Client**: Angular HttpClient with RxJS

### Backend ⚙️
- **Framework**: Spring Boot 3.4.2
- **Language**: Java 17
- **Database**: PostgreSQL with Spring Data JPA
- **Markdown Parser**: FlexMark 0.64.8
- **Security**: Spring Security (configured but not enforced)
- **Build Tool**: Maven
- **Additional**: Lombok, Spring Boot DevTools

## 📋 Prerequisites

Before running this application, make sure you have:

- ☕ **Java 17** or higher
- 🟢 **Node.js 18+** and npm
- 🐘 **PostgreSQL** database server
- 🔧 **Maven** (or use included wrapper)
- 🅰️ **Angular CLI** (`npm install -g @angular/cli`)

## 🚀 Getting Started

### 1️⃣ Clone the Repository
```bash
git clone <repository-url>
cd "MarkView - Angular+Springboot"
```

### 2️⃣ Database Setup 🗄️
1. Create a PostgreSQL database named `markView`
2. Update database credentials in `MarkView/src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/markView
spring.datasource.username=your_username
spring.datasource.password=your_password
```

### 3️⃣ Backend Setup (Spring Boot) 🔧
```bash
cd MarkView

# Using Maven wrapper (recommended)
./mvnw clean install
./mvnw spring-boot:run

# Or using system Maven
mvn clean install
mvn spring-boot:run
```
🌐 Backend will start on `http://localhost:8080`

### 4️⃣ Frontend Setup (Angular) 🎨
```bash
cd MarkView-Frontend

# Install dependencies
npm install

# Start development server
npm start
```
🌐 Frontend will start on `http://localhost:4200`

## 📡 API Endpoints

| Method | Endpoint | Description | Request | Response |
|--------|----------|-------------|---------|----------|
| 🟢 GET | `/api/` | Health check | - | `"helloWorld"` |
| 📤 POST | `/api/upload` | Upload markdown file | `MultipartFile` | `Markdown` object |
| 📋 GET | `/api/list` | Get all uploaded files | - | `List<Markdown>` |
| 🔄 GET | `/api/convert/{id}` | Convert markdown to HTML | `id` (path param) | `HtmlResponse` |

### 📝 Sample API Usage

#### Upload a file:
```bash
curl -X POST http://localhost:8080/api/upload \
  -F "file=@example.md"
```

#### Convert to HTML:
```bash
curl -X GET http://localhost:8080/api/convert/1
```

## 🗂️ Project Structure

```
MarkView - Angular+Springboot/
├── 📁 MarkView/                          # Spring Boot Backend
│   ├── 📁 src/main/java/com/saiDeveloper/Spring_Boot_Starter_Template/
│   │   ├── 📁 controller/                # REST Controllers
│   │   │   └── 📄 MarkController.java    # Main API endpoints
│   │   ├── 📁 service/                   # Business Logic
│   │   │   └── 📄 MarkdownService.java   # Markdown processing
│   │   ├── 📁 model/                     # JPA Entities
│   │   │   └── 📄 Markdown.java          # Markdown entity
│   │   ├── 📁 repo/                      # Data Repositories
│   │   │   └── 📄 MarkdownRepo.java      # JPA Repository
│   │   ├── 📁 response/                  # Response DTOs
│   │   │   └── 📄 HtmlResponse.java      # HTML response model
│   │   └── 📁 exception/                 # Exception Handling
│   │       └── 📄 GlobalExceptionHandler.java
│   ├── 📁 src/main/resources/
│   │   └── 📄 application.properties     # App configuration
│   └── 📄 pom.xml                        # Maven dependencies
│
└── 📁 MarkView-Frontend/                 # Angular Frontend
    ├── 📁 src/app/
    │   ├── 📄 app.ts                     # Main component
    │   ├── 📄 app.html                   # Main template
    │   ├── 📄 api-service.ts             # HTTP service
    │   ├── 📁 header.component/          # Header component
    │   │   └── 📁 theme-toggler.component/ # Theme switcher
    │   └── 📁 theme/                     # Theme configuration
    ├── 📄 package.json                   # npm dependencies
    ├── 📄 tailwind.config.js             # TailwindCSS config
    └── 📄 angular.json                   # Angular CLI config
```

## 🎯 How It Works

1. **📤 Upload**: User selects a markdown file using the file upload component
2. **💾 Store**: File content is sent to Spring Boot backend and stored in PostgreSQL
3. **🔄 Convert**: User clicks "to HTML" button to trigger conversion using FlexMark
4. **👀 View**: Converted HTML is displayed in a modal dialog with copy functionality

## 🔧 Key Dependencies

### Backend Dependencies 📦
- `spring-boot-starter-web` - REST API support
- `spring-boot-starter-data-jpa` - Database operations
- `postgresql` - PostgreSQL driver
- `flexmark-all` - Markdown to HTML conversion
- `lombok` - Boilerplate code reduction
- `spring-boot-starter-validation` - Input validation

### Frontend Dependencies 🎨
- `@angular/core` - Angular framework
- `primeng` - UI component library
- `tailwindcss` - Utility-first CSS framework
- `@primeuix/themes` - PrimeNG theming
- `rxjs` - Reactive programming

## 🚀 Build for Production

### Backend 🏗️
```bash
cd MarkView
./mvnw clean package
java -jar target/MarkView-0.0.1-SNAPSHOT.jar
```

### Frontend 🎨
```bash
cd MarkView-Frontend
npm run build
# Serve the dist/ folder using your preferred web server
```

## 🤝 Contributing

1. 🍴 Fork the repository
2. 🌿 Create a feature branch (`git checkout -b feature/amazing-feature`)
3. 💾 Commit your changes (`git commit -m 'Add amazing feature'`)
4. 📤 Push to the branch (`git push origin feature/amazing-feature`)
5. 🔄 Open a Pull Request

## 📄 License

This project is open source and available under the [MIT License](LICENSE).

## 👨‍💻 Author

**Sai Developer** - Full Stack Developer

## 🙏 Acknowledgments

- 🅰️ **Angular Team** - For the amazing framework
- 🍃 **Spring Team** - For Spring Boot
- 🎨 **PrimeNG Team** - For beautiful UI components
- 📝 **FlexMark** - For excellent markdown parsing
- 🎨 **TailwindCSS** - For utility-first styling

---

⭐ **Star this repository if you found it helpful!** ⭐

🐛 **Found a bug?** [Open an issue](../../issues)

💡 **Have a suggestion?** [Start a discussion](../../discussions)