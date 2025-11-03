# EventClean API 🎉

API REST para cadastro e gerenciamento de eventos, desenvolvida com Java e Spring Boot aplicando os conceitos de **Clean Architecture** (Arquitetura Limpa).

## 📋 Sobre o Projeto

O EventClean é uma aplicação backend robusta para gerenciamento de eventos, implementada seguindo os princípios da Arquitetura Limpa proposta por Robert C. Martin (Uncle Bob). O projeto visa demonstrar boas práticas de desenvolvimento, separação de responsabilidades e independência de frameworks.

## 🏗️ Arquitetura

A aplicação está estruturada em camadas bem definidas seguindo os princípios da Clean Architecture:

### Camadas da Aplicação

```
┌─────────────────────────────────────┐
│      Controllers (Interface)        │  ← Camada de Apresentação
├─────────────────────────────────────┤
│         Use Cases (Regras)          │  ← Camada de Aplicação
├─────────────────────────────────────┤
│      Entities (Regras de Negócio)   │  ← Camada de Domínio
├─────────────────────────────────────┤
│  Gateways & Infrastructure (Dados)  │  ← Camada de Infraestrutura
└─────────────────────────────────────┘
```

- **Controllers**: Responsáveis por receber requisições HTTP e delegar para os Use Cases
- **Use Cases**: Contém a lógica de aplicação e orquestra as regras de negócio
- **Entities**: Representa as regras de negócio fundamentais do domínio
- **Gateways**: Abstrações que isolam a lógica de negócio dos detalhes de implementação
- **Infrastructure**: Implementações concretas de repositórios, configurações e integrações

## 🚀 Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.x**
- **Spring Data JPA**
- **PostgreSQL**
- **Maven**
- **Lombok**
- **JUnit 5 & Testcontainers** (testes de integração)
- **AWS EC2** (deploy)

## 📦 Pré-requisitos

- JDK 17+
- Maven 3.8+
- PostgreSQL 14+
- Docker (opcional, para rodar o banco localmente)

## ⚙️ Configuração Local

### 1. Clone o repositório

git clone https://github.com/Lucasstq/EventClean.git
cd EventClean

### 2. Configure as variáveis de ambiente

Crie um arquivo .env na raiz do projeto:


POSTGRES_DB=eventclean
POSTGRES_USER=seu_usuario
POSTGRES_PASSWORD=sua_senha

**Adicione o .env no .gitignore para não versionar credenciais!**

### 3. Configure o banco de dados

#### Opção A: Usando Docker

docker run --name postgres-eventclean \
  -e POSTGRES_DB=eventclean \
  -e POSTGRES_USER=postgres \
  -e POSTGRES_PASSWORD=postgres \
  -p 5432:5432 \
  -d postgres:14-alpine

#### Opção B: PostgreSQL local

Crie o banco de dados manualmente:

CREATE DATABASE eventclean;

### 4. Execute a aplicação

#### Via Maven:

# Carregar variáveis de ambiente
source .env

# Compilar e rodar
mvn spring-boot:run

#### Via JAR:

# Compilar
mvn clean package

# Executar
POSTGRES_DB=eventclean POSTGRES_USER=postgres POSTGRES_PASSWORD=postgres \
java -jar target/EventClean-0.0.1-SNAPSHOT.jar

A aplicação estará disponível em: `http://localhost:8080`

## 🧪 Testes

O projeto utiliza **JUnit 5** e **Testcontainers** para testes de integração com PostgreSQL real.

# Rodar todos os testes
mvn test

# Rodar com coverage
mvn clean test jacoco:report

Os testes utilizam containers Docker automaticamente, garantindo isolamento e reprodutibilidade.

## 🌐 Deploy na AWS

A aplicação está hospedada na AWS EC2 com a seguinte infraestrutura:

### Arquitetura AWS
```
┌──────────────────────────────────────┐
│           VPC (10.0.0.0/16)          │
│  ┌────────────────────────────────┐  │
│  │  Subnet Pública (10.0.1.0/24)  │  │
│  │  ┌──────────────────────────┐  │  │
│  │  │   EC2 Instance           │  │  │
│  │  │   - Amazon Linux 2023    │  │  │
│  │  │   - Java 17              │  │  │
│  │  │   - EventClean API       │  │  │
│  │  └──────────────────────────┘  │  │
│  └────────────────────────────────┘  │
│                                      │
│  Security Group:                     │
│  - SSH (22): Acesso restrito         │
│  - HTTP (80): Público                │
│  - HTTPS (443): Público              │
└──────────────────────────────────────┘
```
### Especificações da Instância

- **Tipo**: t2.micro
- **AMI**: Amazon Linux 2023
- **Região**: sa-east-1 (São Paulo)
- **IP Público**: `54.233.229.160`
- **DNS Público**: `ec2-54-233-229-160.sa-east-1.compute.amazonaws.com`

### Deploy Manual

# 1. Compilar o projeto localmente
mvn clean package

# 2. Copiar JAR para o servidor
scp -i ~/.ssh/id_seuId \
  ./target/EventClean-0.0.1-SNAPSHOT.jar \
  ec2-user@54.233.229.160:/home/ec2-user/

# 3. Conectar via SSH
ssh -i ~/.ssh/id_seuID ec2-user@54.233.229.160

# 4. Rodar a aplicação
POSTGRES_DB=eventclean
POSTGRES_USER=postgres
POSTGRES_PASSWORD=sua_senha
java -jar EventClean-0.0.1-SNAPSHOT.jar

## 📚 API Endpoints

### Eventos

# Listar todos os eventos
GET /api/eventos

# Buscar evento por ID
GET /api/eventos/{id}

# Criar novo evento
POST /api/eventos
Content-Type: application/json

{
  "titulo": "Conferência de Tecnologia",
  "descricao": "Evento anual sobre inovações tecnológicas",
  "data": "2025-12-15",
  "local": "São Paulo - SP"
}

# Deletar evento
DELETE /api/eventos/{id}

# Procurar pro identificador
GET localhost:8080/api/v1/buscar-identificador?identificador=identificador

## 🔒 Segurança

- Variáveis de ambiente para credenciais sensíveis
- Security Groups configurados na AWS
- Acesso SSH restrito por chave privada
- HTTPS recomendado para produção

## 📄 Licença

Este projeto foi desenvolvido para fins educacionais e demonstração de conceitos de Clean Architecture.

## 👨‍💻 Autor

**Lucas Emanuel**
- GitHub: [@Lucasstq](https://github.com/Lucasstq)

## 🎯 Objetivos de Aprendizado

Este projeto foi desenvolvido com os seguintes objetivos:

✅ Aplicar princípios SOLID  
✅ Implementar Clean Architecture  
✅ Separação de responsabilidades  
✅ Testes automatizados com Testcontainers  
✅ Deploy em ambiente de produção (AWS)  
✅ Boas práticas de versionamento  
✅ Configuração de infraestrutura em nuvem  

## 📝 Notas Adicionais

### Estrutura de Pastas
```
src/
├── main/
│   ├── java/com/br/EventClean/
│   │   ├── controller/        # Controllers REST
│   │   ├── core/
│   │   │   ├── domain/        # Entidades de domínio
│   │   │   └── usecase/       # Casos de uso
│   │   ├── infrastruct/
│   │   │   ├── config/        # Configurações Spring
│   │   │   ├── gateway/       # Implementação dos gateways
│   │   │   └── persistence/   # Repositórios JPA
│   │   └── EventCleanApplication.java
│   └── resources/
│       └── application.properties
└── test/
    ├── java/                  # Testes unitários e integração
    └── resources/
        └── application.properties
```
### Dicas de Desenvolvimento

- Use o IntelliJ IDEA para melhor experiência com Spring Boot
- Configure variáveis de ambiente nas configurações de Run do IDE
- Utilize o Postman ou Insomnia para testar os endpoints
- Mantenha o arquivo `.env.example` atualizado com todas as variáveis necessárias
