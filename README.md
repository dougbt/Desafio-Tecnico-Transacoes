# Sistema de Gestão Bancária - API REST

## 📋 Descrição

Sistema de gestão bancária desenvolvido em Java com Spring Boot, oferecendo uma API REST para criação de contas e processamento de transações financeiras com diferentes formas de pagamento e taxas aplicáveis.

## 🚀 Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.x**
- **Spring Data JPA**
- **H2 Database** (em memória)
- **Liquibase** (controle de schema)
- **Maven** (gerenciamento de dependências)
- **JUnit 5** (testes)

## 🏗️ Arquitetura

O projeto segue os princípios de **Clean Architecture** e **Domain-Driven Design**, organizado em camadas:

- **API Layer**: Controllers e DTOs
- **Application Layer**: Services de aplicação
- **Domain Layer**: Entidades, enums e interfaces
- **Infrastructure Layer**: Repositórios e configurações

## 📊 Design Patterns Implementados

- **Strategy Pattern**: Para diferentes formas de pagamento
- **Repository Pattern**: Para acesso aos dados
- **Factory Pattern**: Para criação das estratégias de transação
- **DTO Pattern**: Para transferência de dados

## 🔧 Como Executar

### Pré-requisitos
- Java 17+
- Maven 3.6+

### Executando a aplicação

1. **Clone o repositório:**
```bash
git clone https://github.com/dougbt/Desafio-Tecnico-Transacoes.git
cd Desafio-Tecnico-Ng-Billing
```

2. **Execute a aplicação:**
```bash
./mvnw spring-boot:run
```

3. **Execute os testes:**
```bash
./mvnw test
```

4. **Acesse a aplicação:**
- API: `http://localhost:8080`
- Console H2: `http://localhost:8080/h2-console`
  - JDBC URL: `jdbc:h2:mem:ngbillingdb`
  - Username: `root`
  - Password: (vazio)

## 📖 Endpoints da API

### 1. Criar Conta
```http
POST /conta
Content-Type: application/json

{
  "numero_conta": 234,
  "saldo": 180.37
}
```

**Resposta (201 Created):**
```json
{
  "numero_conta": 234,
  "saldo": 180.37
}
```

### 2. Buscar Conta
```http
GET /conta?numero_conta=234
```

**Resposta (200 OK):**
```json
{
  "numero_conta": 234,
  "saldo": 170.07
}
```

### 3. Realizar Transação
```http
POST /transacao
Content-Type: application/json

{
  "forma_pagamento": "D",
  "numero_conta": 234,
  "valor": 10
}
```

**Resposta (201 Created):**
```json
{
  "numero_conta": 234,
  "saldo": 170.07
}
```

## 💳 Formas de Pagamento e Taxas

| Forma | Código | Taxa |
|-------|--------|------|
| Pix | P | 0% |
| Cartão de Débito | D | 3% |
| Cartão de Crédito | C | 5% |

## 🔒 Regras de Negócio

- ✅ Não é permitido criar contas duplicadas
- ✅ Não é permitido saldo negativo (sem cheque especial)
- ✅ Taxas são aplicadas sobre o valor da transação
- ✅ Transações alteram o saldo da conta permanentemente

## 🧪 Dados de Teste

A aplicação inicia com contas pré-cadastradas para facilitar os testes:

- **Conta 123**: Saldo R$ 1.000,00
- **Conta 456**: Saldo R$ 500,00

## 📁 Estrutura do Projeto

```
src/
├── main/
│   ├── java/br/com/ngbilling/DesafioTecnico/
│   │   ├── api/                    # Controllers e DTOs
│   │   ├── application/            # Services de aplicação
│   │   ├── domain/                 # Entidades e regras de negócio
│   │   ├── infrastructure/         # Repositórios e configurações
│   │   └── config/                 # Configurações gerais
│   └── resources/
│       ├── application.yaml        # Configurações da aplicação
│       └── db/changelog/           # Scripts Liquibase
└── test/
    └── java/                       # Testes de integração
```

## 🎯 Status dos Testes

Todos os testes de integração estão passando, cobrindo:

- ✅ Criação de contas
- ✅ Busca de contas existentes e inexistentes
- ✅ Transações com diferentes formas de pagamento
- ✅ Validação de saldo insuficiente
- ✅ Aplicação correta das taxas

---

**Desenvolvido por: Douglas Barcellos  
**Data:** agosto de 2025
