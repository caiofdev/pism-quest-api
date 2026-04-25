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

### 2) Variáveis de ambiente (opcional)

Por padrão, a API usa:

- `DB_URL=jdbc:postgresql://localhost:5432/pismquest`
- `DB_USERNAME=postgres`
- `DB_PASSWORD=postgres`

Se quiser sobrescrever:

```bash
export DB_URL=jdbc:postgresql://localhost:5432/pismquest
export DB_USERNAME=postgres
export DB_PASSWORD=postgres
```

### 3) Rodar a API

```bash
mvn spring-boot:run
```

A API sobe em `http://localhost:8080`.

## Endpoints iniciais

- Health custom: `GET /api/health`
- Actuator health: `GET /actuator/health`
- Swagger UI: `GET /swagger-ui/index.html`
- OpenAPI JSON: `GET /v3/api-docs`

Exemplo:

```bash
curl http://localhost:8080/api/health
```

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
