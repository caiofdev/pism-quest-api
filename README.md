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

## pgAdmin4 (interface web para PostgreSQL)

Use o pgAdmin4 para visualizar o banco local. No WSL, prefira o modo web (o modo desktop costuma falhar por causa do AppArmor).

### Instalacao no WSL (modo web recomendado)

```bash
sudo apt update
sudo apt install -y curl ca-certificates gnupg

curl -fsS https://www.pgadmin.org/static/packages_pgadmin_org.pub |
	sudo gpg --dearmor -o /usr/share/keyrings/packages-pgadmin-org.gpg

sudo sh -c 'echo "deb [signed-by=/usr/share/keyrings/packages-pgadmin-org.gpg] https://ftp.postgresql.org/pub/pgadmin/pgadmin4/apt/$(lsb_release -cs) pgadmin4 main" > /etc/apt/sources.list.d/pgadmin4.list'

sudo apt update
sudo apt install -y pgadmin4-web
sudo /usr/pgadmin4/bin/setup-web.sh
```

Depois, acesse no navegador: `http://127.0.0.1/pgadmin4`.

Para ligar/desligar o pgAdmin4 web (Apache):

```bash
# WSL sem systemd
sudo service apache2 start
sudo service apache2 stop

# Com systemd
sudo systemctl start apache2
sudo systemctl stop apache2
```

### Instalacao no Linux com GUI (modo desktop)

```bash
sudo apt update
sudo apt install -y curl ca-certificates gnupg

curl -fsS https://www.pgadmin.org/static/packages_pgadmin_org.pub |
	sudo gpg --dearmor -o /usr/share/keyrings/packages-pgadmin-org.gpg

sudo sh -c 'echo "deb [signed-by=/usr/share/keyrings/packages-pgadmin-org.gpg] https://ftp.postgresql.org/pub/pgadmin/pgadmin4/apt/$(lsb_release -cs) pgadmin4 main" > /etc/apt/sources.list.d/pgadmin4.list'

sudo apt update
sudo apt install -y pgadmin4-desktop
```

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
