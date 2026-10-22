# 🏦 Bank Transfer API

API REST desenvolvida com Java e Spring Boot para simular operações bancárias reais, incluindo cadastro de clientes, criação de contas, depósitos, saques e transferências entre contas.

Este projeto foi criado como parte da minha transição de carreira de QA para Desenvolvedor Java Backend.

---

## 🚀 Tecnologias Utilizadas

- Java 21
- Spring Boot
- Spring Data JPA
- Hibernate
- PostgreSQL
- Maven
- Lombok
- Spring Security
- REST API

---

## 🏗️ Arquitetura

O projeto segue uma arquitetura em camadas:

```text
src/main/java/br/com/nilton/banktransfer

├── controller
├── dto
├── entity
├── exception
├── repository
├── service
└── config
```

### Responsabilidades

#### Controller

Responsável por receber requisições HTTP e retornar respostas.

#### Service

Responsável pelas regras de negócio da aplicação.

#### Repository

Responsável pela comunicação com o banco de dados.

#### DTO

Responsável pela troca de dados entre cliente e API.

#### Exception

Responsável pelo tratamento global de erros da aplicação.

---

## 📋 Funcionalidades

### 👤 Customer

#### Criar Cliente

```http
POST /customers
```

#### Listar Clientes

```http
GET /customers
```

#### Buscar Cliente por ID

```http
GET /customers/{id}
```

#### Atualizar Cliente

```http
PUT /customers/{id}
```

#### Remover Cliente

```http
DELETE /customers/{id}
```

---

### 💳 Account

#### Criar Conta

```http
POST /accounts
```

#### Consultar Saldo

```http
GET /accounts/{id}/balance
```

#### Depositar

```http
POST /accounts/{id}/deposit
```

#### Sacar

```http
POST /accounts/{id}/withdraw
```

#### Transferir entre Contas

```http
POST /accounts/transfer
```

---

## 🔄 Exemplo de Transferência

### Request

```json
{
  "sourceAccountId": "11111111-1111-1111-1111-111111111111",
  "destinationAccountId": "22222222-2222-2222-2222-222222222222",
  "amount": 300.00
}
```

### Regras

- Conta origem deve existir
- Conta destino deve existir
- Saldo deve ser suficiente
- Operação é transacional utilizando `@Transactional`

---

## 💰 Exemplo de Depósito

### Request

```json
{
  "amount": 1000.00
}
```

### Endpoint

```http
POST /accounts/{id}/deposit
```

---

## 💸 Exemplo de Saque

### Request

```json
{
  "amount": 300.00
}
```

### Endpoint

```http
POST /accounts/{id}/withdraw
```

---

## ⚠️ Tratamento Global de Exceções

A aplicação utiliza:

```java
@RestControllerAdvice
```

para tratamento centralizado de erros.

### Exceções Implementadas

- CustomerNotFoundException
- AccountNotFoundException
- InsufficientBalanceException

### Exemplo de Resposta

```json
{
  "timestamp": "2026-10-22T10:00:00",
  "status": 404,
  "error": "NOT_FOUND",
  "message": "Account not found"
}
```

---

## 🗄️ Banco de Dados

### Criar Banco

```sql
CREATE DATABASE bank_transfer;
```

### Configuração

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/bank_transfer
spring.datasource.username=postgres
spring.datasource.password=postgres

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## ▶️ Executando o Projeto

### Clonar Repositório

```bash
git clone https://github.com/seu-usuario/bank-transfer-api.git
```

### Entrar na Pasta

```bash
cd bank-transfer-api
```

### Executar a Aplicação

```bash
mvn spring-boot:run
```

A aplicação ficará disponível em:

```text
http://localhost:8081
```

---

## 🧠 Conceitos Aplicados

- Programação Orientada a Objetos (POO)
- APIs REST
- Spring Boot
- Spring Data JPA
- Hibernate
- PostgreSQL
- DTO Pattern
- Repository Pattern
- Service Layer Pattern
- Tratamento Global de Exceções
- Relacionamentos JPA
- Transaction Management
- @Transactional

---

## 🎯 Objetivo

O objetivo deste projeto é consolidar conhecimentos de desenvolvimento backend com Java e Spring Boot através de um domínio próximo ao mercado financeiro, simulando operações utilizadas por bancos e fintechs.

---

## 🔜 Próximas Melhorias

- [ ] Swagger / OpenAPI
- [ ] JUnit 5
- [ ] Mockito
- [ ] Extrato Bancário
- [ ] Histórico de Transações
- [ ] JWT Authentication
- [ ] Docker
- [ ] Flyway
- [ ] TestContainers
- [ ] GitHub Actions

---

## 👨‍💻 Autor

**Nilton**

Projeto desenvolvido durante minha jornada de transição de carreira de QA para Desenvolvedor Java Backend.