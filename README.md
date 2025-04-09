
# API Servidores

API REST desenvolvida com Java 17 e Spring Boot para gerenciamento de servidores efetivos. O projeto utiliza PostgreSQL como banco de dados e MinIO para armazenamento de fotos. Toda a aplicação é orquestrada com Docker Compose.

---

## 📦 Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- PostgreSQL
- MinIO
- Docker & Docker Compose
- Maven

---

## 📁 Estrutura do Projeto

```
servidores/
├── src/
├── target/
├── Dockerfile
├── docker-compose.yml
├── .env
└── pom.xml
```

---

## ⚙️ Configuração

Crie um arquivo `.env` na raiz do projeto com o seguinte conteúdo:

```env
SPRING_DATASOURCE_URL=jdbc:postgresql://postgres:5432/db
SPRING_DATASOURCE_USERNAME=user
SPRING_DATASOURCE_PASSWORD=password

MINIO_URL=http://minio:9000
MINIO_ACCESS_KEY=minio
MINIO_SECRET_KEY=minio123
```

---

## 🚀 Como Rodar com Docker

### 1. Gerar o `.jar` da aplicação:

```bash
mvn clean package -DskipTests
```

### 2. Subir os containers:

```bash
docker-compose up --build
```

A aplicação estará disponível em:  
📍 `http://localhost:8081`

---

## ✅ Requisitos

- Docker e Docker Compose instalados
- Java 17 (caso rode localmente)
- Maven (caso rode localmente)
