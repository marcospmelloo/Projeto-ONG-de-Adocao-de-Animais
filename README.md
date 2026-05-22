# Projeto ONG de Adoção de Animais 🐶🐱

API REST desenvolvida para gerenciamento de uma ONG de adoção de animais, permitindo o controle de animais, pessoas, endereços, características e interesses de adoção.

---

# 📚 Sobre o Projeto

O sistema foi desenvolvido com foco em organização arquitetural, boas práticas no desenvolvimento de APIs REST utilizando Spring Boot.

A aplicação permite:

- Cadastro de animais
- Cadastro de pessoas
- Controle de características dos animais
- Controle de endereços
- Controle de interesses de adoção
- Relacionamentos entre entidades
- Tratamento global de exceções
- Validações de dados
- Documentação completa da API com Swagger

---

# 🚀 Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Maven
- Swagger / OpenAPI
- Bean Validation
- Hibernate

---

# 📂 Estrutura do Projeto

```text
src/main/java
│
├── controller
├── domain
├── dto
├── repository
├── service
├── exception
└── config
```

---

# 🏗️ Arquitetura

O projeto foi estruturado utilizando separação em camadas:

- **Controller** → responsável pelos endpoints da API
- **Service** → regras de negócio
- **Repository** → acesso ao banco de dados
- **DTO** → transferência de dados
- **Exception** → tratamento global de erros

---

# 🔥 Funcionalidades

## 🐾 Animal

- Cadastrar animal
- Listar animais
- Buscar animal por ID
- Atualizar animal
- Deletar animal

---

## 🎭 Características

- Cadastrar característica
- Listar características
- Buscar característica por ID
- Atualizar característica
- Deletar característica

---

## 👤 Pessoa

- Cadastrar pessoa
- Listar pessoas
- Buscar pessoa por ID
- Atualizar pessoa
- Deletar pessoa

---

## 🏠 Endereço

- Cadastrar endereço
- Listar endereços
- Buscar endereço por ID
- Atualizar endereço
- Deletar endereço

---

## ❤️ Interesse de Adoção

- Registrar interesse de adoção
- Listar interesses
- Buscar interesse por ID
- Atualizar interesse
- Remover interesse

---

# 📌 Relacionamentos

## Animal

- Possui várias características

## Pessoa

- Possui um endereço
- Pode demonstrar interesse em adoção

## Interesse de Adoção

- Relaciona uma pessoa a um animal

---

# ⚠️ Tratamento de Exceções

A API possui tratamento global de exceções utilizando:

- `ResourceNotFoundException`
- `DuplicateEntryException`
- `GlobalExceptionHandler`

Retornando respostas padronizadas com:

- status HTTP
- mensagem de erro

---

# ✅ Validações

O projeto utiliza Bean Validation com:

- `@NotBlank`
- `@NotNull`
- `@Email`
- `@Valid`

---

# 📖 Documentação Swagger

A documentação da API pode ser acessada em:

```text
http://localhost:8080/swagger-ui/index.html
```

---

# 🛠️ Como Executar o Projeto

## 1️⃣ Clonar o repositório

```bash
git clone https://github.com/marcospmelloo/Projeto-ONG-de-Adocao-de-Animais.git
```

---

## 2️⃣ Abrir o projeto

Abra o projeto em uma IDE como:

- IntelliJ IDEA
- VS Code
- Eclipse

---

## 3️⃣ Configurar o banco de dados

Criar um banco PostgreSQL e configurar o:

```properties
application.properties
```

---

## 4️⃣ Executar o projeto

Rodar a aplicação Spring Boot.

---

# 📬 Exemplos de Endpoints

## Animal

```http
GET /animais
POST /animais
PUT /animais/{id}
DELETE /animais/{id}
```

---

## Pessoa

```http
GET /pessoas
POST /pessoas
PUT /pessoas/{id}
DELETE /pessoas/{id}
```

---

# 🎯 Diferenciais do Projeto

✅ DTO Request/Response  
✅ Arquitetura em camadas  
✅ Tratamento global de exceções  
✅ Validação de dados  
✅ Swagger/OpenAPI  
✅ Relacionamentos entre entidades  
✅ Organização profissional de API REST  

---

# 👨‍💻 Autor

Desenvolvido por Marcos Paulo.
