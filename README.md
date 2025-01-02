# Descrição do Projeto

A aplicação **Controle de Parquímetro** é um sistema backend desenvolvido em **Java 17** utilizando o framework **Spring Boot 3.3.4** e banco de dados **PostgreSQL**. Este projeto tem como objetivo gerenciar o controle de estacionamento, incluindo funcionalidades de configuração, gestão de vagas, emissão de multas e relatórios financeiros.

A aplicação foi estruturada com a arquitetura **Clean Architecture**, separando responsabilidades nas camadas de `domain`, `aplicacao`, `infraestrutura` e `api`, garantindo alta manutenibilidade e escalabilidade.

## Principais Funcionalidades

### Configuração do Sistema:

- Configuração dos horários de funcionamento.
- Definição de limite de capacidade do estacionamento.
- Parâmetros para emissão de multas e tempo máximo de permanência.

### Gerenciamento de Vagas:

- Cadastro, atualização e exclusão de vagas.
- Alteração do estado de ocupação das vagas.
- Listagem de todas as vagas ou consulta específica por ID.

### Multas:

- Emissão de multas para veículos que ultrapassaram o tempo máximo de permanência.

### Relatórios:

- Relatórios financeiros baseados no uso do estacionamento.

### Segurança:

- Configurado com **Spring Security** para proteção dos endpoints e suporte a boas práticas.

## Tecnologias Utilizadas

- **Linguagem**: Java 17
- **Framework**: Spring Boot 3.3.4
- **Banco de Dados**: PostgreSQL
- **Gerenciamento de Dependências**: Maven
- **Virtualização**: Docker e Docker Compose

# Endpoints Disponíveis

## 1. Configuração
**Base URL**: /configuracao

- ### GET /configuracao**  
  Retorna a configuração atual do sistema.

- ### POST /configuracao
  Cria uma nova configuração.

- ### PUT /configuracao/{id}**  
  Atualiza uma configuração existente.

- ### DELETE /configuracao/{id}**  
  Remove uma configuração existente.

---

## 2. Vagas
**Base URL**: /vaga

- ### GET /vaga**  
  Lista todas as vagas disponíveis.

- ### GET /vaga/{id}**  
  Retorna os detalhes de uma vaga específica.

- ### POST /vaga**  
  Cria uma nova vaga.

- ### PUT /vaga/{id}**  
  Atualiza os detalhes de uma vaga existente.

- ### DELETE /vaga/{id}**  
  Remove uma vaga do sistema.

- ### PATCH /vaga/{id}/ocupacao**  
  Atualiza o estado de ocupação da vaga.

---

## 3. Multas
**Base URL**: /multa

- ### POST /multa**  
  Emite uma nova multa.

- ### GET /multa**  
  Lista todas as multas emitidas.

- ### GET /multa/{id}**  
  Retorna os detalhes de uma multa específica.

## Observação

Este projeto conta com a integração do **Springdoc OpenAPI** para a documentação das APIs implementadas. Com isso, é possível acessar uma interface interativa para explorar e testar os endpoints diretamente no navegador.

### Acesso à Documentação

Após iniciar a aplicação, a documentação pode ser acessada pelo seguinte endereço:
http://localhost:8080/swagger-ui/index.html

### Funcionalidades Disponíveis na Documentação

1. **Visualização dos Endpoints:** Todos os endpoints estão listados, organizados por categoria.
2. **Testes Diretos:** Permite enviar requisições diretamente pelo navegador.
3. **Especificação OpenAPI:** Uma especificação JSON ou YAML pode ser obtida para integração com outras ferramentas.

## Comandos para Rodar a Aplicação

### Docker
Para gerenciar os containers e serviços da aplicação, utilizamos os seguintes comandos Docker:

1. **Iniciar os serviços definidos no `docker-compose.yml`:**
   ```bash
   docker-compose up -d

2. **Parar e remover os containers `docker-compose.yml`:**
   ```bash
   docker-compose down


## Estrutura do Projeto
```bash
src/
├── main/
│   ├── java/
│   │   └── com/edusocrates/RM358568/svc_controleParquimetro
│   │       ├── api/   # Controllers
│   │       ├── dominio/model       # Entidades de domínio
│   │       ├── dominio/dto/          # Data Transfer Objects (DTOs)
│   │       ├── dominio/enum/          # Enums
│   │       ├── infratestrutura/repositorio/   # Interfaces de Repositórios
│   │       ├── infratestrutura/configuracao/   # Gerenciamento de Configurações
│   │       ├── aplicacao/service/      # Regras de negócio (Camada de Serviço)
│   └── resources/
│       ├── application.yaml   # Configurações da aplicação
│       ├── application-local.yaml   # Configurações da aplicação local
│       ├── application-dev.yaml   # Configurações da aplicação "dev"


