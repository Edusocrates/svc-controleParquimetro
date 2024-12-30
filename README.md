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
- **Ferramentas de Migração**: Flyway
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


