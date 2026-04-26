# pismquest-api

Configuração inicial de uma API em Java + Spring Boot.

## Requisitos (WSL Ubuntu)

Como seu ambiente ainda está sem Java/Maven, execute:

```bash
sudo apt update
sudo apt install -y openjdk-17-jdk maven unzip
```

Valide a instalação:

```bash
java -version
mvn -v
```

## Rodando localmente

### 1) Subir PostgreSQL (Docker)

Crie o arquivo `.env` na raiz do projeto (use `.env.example` como base):

```bash
cp .env.example .env
```

```bash
docker compose up -d
```

Se você ainda não tem Docker no WSL:

```bash
sudo apt install -y docker.io docker-compose-v2
sudo usermod -aG docker $USER
```

Depois de adicionar o usuário ao grupo docker, reinicie o terminal.

### 2) Carregar variáveis de ambiente para a API (obrigatório)

As variáveis já ficam no arquivo `.env`. Antes de rodar a API, carregue no shell:

```bash
set -a
source .env
set +a
```

Variáveis usadas pelo Spring Boot:

- `DB_URL`
- `DB_USERNAME`
- `DB_PASSWORD`

### 3) Rodar a API

```bash
mvn spring-boot:run
```

A API sobe em `http://localhost:8080`.

## Endpoints iniciais

- Actuator health: `GET /actuator/health`
- Swagger UI: `GET /swagger-ui/index.html`
- OpenAPI JSON: `GET /v3/api-docs`


## Banco de dados

- Banco padrão: PostgreSQL
- Configuração principal: `src/main/resources/application.yml`
- Ambiente de desenvolvimento local: `docker-compose.yml`

## Testes

Os testes usam perfil `test` com H2 em memória para não depender de PostgreSQL ativo durante `mvn test`.

## Estrutura criada

- `pom.xml` com Spring Boot 3.4.5
- `spring-boot-starter-web`
- `spring-boot-starter-validation`
- `spring-boot-starter-actuator`
- `spring-boot-starter-jdbc`
- `spring-boot-starter-data-jpa` (Hibernate)
- `postgresql` (driver JDBC)
- `springdoc-openapi-starter-webmvc-ui` (Swagger)
- `jjwt-api`, `jjwt-impl`, `jjwt-jackson` (JWT)
- `h2` (apenas testes)
- `junit-jupiter` + `spring-boot-starter-test` (JUnit)
- teste base com `spring-boot-starter-test`
