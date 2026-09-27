# 🎮 API de Jogos

API REST desenvolvida em **Java com Spring Boot** para praticar a criação de serviços web, operações CRUD, parâmetros de busca e manipulação de dados em memória.

O projeto simula um catálogo de jogos, permitindo cadastrar, listar, pesquisar, filtrar, atualizar e excluir registros.

## 🚀 Tecnologias utilizadas

- ☕ **Java 17**
- 🌱 **Spring Boot 4.1.1**
- 🌐 **Spring Web MVC**
- 📦 **Maven**
- 🛠️ **Lombok**
- 🔎 **Postman** para testes das requisições HTTP

## 📌 Funcionalidades

A API permite:

- Cadastrar jogos
- Listar todos os jogos
- Buscar um jogo pelo ID
- Filtrar jogos por nome, gênero e dificuldade
- Atualizar um jogo existente
- Excluir um jogo

Os dados são armazenados atualmente em uma **lista em memória**, funcionando como um banco de dados temporário. Dessa forma, os registros são perdidos quando a aplicação é encerrada.

## 🧩 Modelo de dados

Cada jogo possui os seguintes atributos:

| Campo | Tipo | Descrição |
|---|---|---|
| `id` | Long | Identificador do jogo |
| `nome` | String | Nome do jogo |
| `genero` | String | Gênero do jogo |
| `dificuldade` | String | Nível de dificuldade |
| `ano_jogado` | Integer | Ano em que o jogo foi jogado |

## 🔗 Endpoints

### 📋 Listar jogos

**GET**
```
http://localhost:8080/jogos/Listar_jogos
```

Retorna todos os jogos cadastrados.

### 🔎 Buscar por ID

**GET**
```
http://localhost:8080/jogos/Buscar_ID/{id}
```

Exemplo:

```
GET http://localhost:8080/jogos/Buscar_ID/1
```

### 🔍 Filtrar jogos

**GET**
```
http://localhost:8080/jogos/filtro
```

É possível utilizar os filtros individualmente ou combiná-los.

Por nome:

```
GET http://localhost:8080/jogos/filtro?nome=skul
```

Por gênero:

```
GET http://localhost:8080/jogos/filtro?genero=RPG
```

Por dificuldade:

```
GET http://localhost:8080/jogos/filtro?dificuldade=Difícil
```

Combinando filtros:

```
GET http://localhost:8080/jogos/filtro?genero=RPG&dificuldade=Difícil
```

A busca pelo nome não diferencia letras maiúsculas e minúsculas e permite encontrar o termo mesmo quando ele aparece apenas em parte do nome.

### ➕ Cadastrar jogo

**POST**
```
http://localhost:8080/jogos/gravar
```

Exemplo de JSON:

```json
{
  "id": 1,
  "nome": "Skul: The Hero Slayer",
  "genero": "RPG",
  "dificuldade": "Difícil",
  "ano_jogado": 2026
}
```

### ✏️ Atualizar jogo

**PUT**
```
http://localhost:8080/jogos/{id}
```

Exemplo:

```
PUT http://localhost:8080/jogos/1
```

Corpo da requisição:

```json
{
  "nome": "Skul: The Hero Slayer",
  "genero": "Roguelite",
  "dificuldade": "Difícil",
  "ano_jogado": 2026
}
```

### 🗑️ Excluir jogo

**DELETE**
```
http://localhost:8080/jogos/{id}
```

Exemplo:

```
DELETE http://localhost:8080/jogos/1
```

## 🧪 Testes com Postman

As requisições da API foram testadas utilizando o **Postman**, verificando o funcionamento dos principais endpoints e das operações de manipulação dos jogos.

Exemplos de testes realizados:

- `POST` para cadastrar jogos
- `GET` para listar e buscar jogos
- `GET` com parâmetros para testar os filtros
- `PUT` para atualizar registros
- `DELETE` para excluir registros

### Exemplo de requisição POST no Postman

**URL:**

```
http://localhost:8080/jogos/gravar
```

**Método:** `POST`

**Body → raw → JSON:**

```json
{
  "id": 1,
  "nome": "Skul: The Hero Slayer",
  "genero": "RPG",
  "dificuldade": "Difícil",
  "ano_jogado": 2026
}
```

## ▶️ Como executar

### 1. Clone o repositório

```bash
git clone https://github.com/budack/API_Jogos.git
```

### 2. Abra o projeto em uma IDE

Recomenda-se utilizar uma IDE com suporte a **Java e Maven**, como IntelliJ IDEA, Eclipse ou Spring Tool Suite.

### 3. Execute a aplicação

Execute a classe principal da aplicação Spring Boot.

Por padrão, a API ficará disponível em:

```
http://localhost:8080
```

### 4. Teste os endpoints

Utilize o Postman para enviar as requisições e verificar as respostas da API.

## 📂 Estrutura principal

```
src/
└── main/
    └── java/
        └── apiJogos/
            ├── controller/
            │   └── jogosController.java
            └── model/
                └── Jogos.java
```

### Controller

A classe `jogosController` é responsável por receber as requisições HTTP e executar as operações da API.

### Model

A classe `Jogos` representa os dados de cada jogo e utiliza **Lombok** para gerar automaticamente os métodos `get` e `set`.

## 🎯 Objetivo do projeto

Este projeto foi desenvolvido como prática de:

- Desenvolvimento de APIs REST
- Spring Boot
- Métodos HTTP
- CRUD
- `@RequestMapping`, `@GetMapping`, `@PostMapping`, `@PutMapping` e `@DeleteMapping`
- `@PathVariable` e `@RequestParam`
- Uso de `ResponseEntity`
- Manipulação de listas e objetos em Java
- Testes de APIs com Postman

## 📌 Próximos passos

Possíveis evoluções para o projeto:

- Persistência dos dados utilizando PostgreSQL ou outro banco de dados
- Implementação de Spring Data JPA
- Validação dos dados recebidos
- Tratamento global de exceções
- Documentação da API com Swagger/OpenAPI
- Separação em camadas de Controller, Service e Repository

---

👨‍💻 Desenvolvido por **Vinicius Cristiano Budack dos Santos**

Projeto desenvolvido para estudos e prática de desenvolvimento backend com Java e Spring Boot.
