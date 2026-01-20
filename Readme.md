
# Desafio Técnico Sensedia

um mini sistema web simples para:
1. Cadastrar usuários
2. Cadastrar projetos vinculando um responsável (selecionado da lista de usuários)
3. Exibir uma tela principal com listagem de Projetos + Responsáveis



## Stack utilizada

**Front-end:**

[![My Skills](https://skillicons.dev/icons?i=bootstrap,css,html&theme=dark)](https://skillicons.dev)

**Back-end:** Java 21, Spring Boot, Thymeleaf, Spring Data JPA, Spring Web, SQLite Dialect, Spring Validation

[![My Skills](https://skillicons.dev/icons?i=java,spring,sqlite&theme=dark)](https://skillicons.dev)


## Dependências
- Java JDK 24
- Maven
- Git
- IDE da sua prederência (Intellij foi a usada)


## Como rodar

### 1° Clonar repositório
> Clone o repositório do projeto. Para isso abra seu terminal e dê um "git clone https://github.com/emilypamorim/desafio-tecnico-sensedia.git". Depois um "/cd" para a pasta do projeto

### 2° Banco de dados
> O projeto utiliza o SQLite, então não é necessário instalar nenhuma aplicação de servidor de banco de dados pesados. Na raiz do projeto, será criado automaticamente um arquivo .db, provalmente "desafio.db".

### 3° Executar a aplicação
> Na pasta raiz do projeto, execute "mvnw spring-boot:run"

### 4° Acessar o sistema
> Após o terminal exibir que o tom cat foi iniciado. Entre no seu navegador e acesse a URL **http://localhost:8080/**
![tabeladeprojetos.png](../../Pictures/Screenshots/tabeladeprojetos.png)
> Rota de Cadastro de Usuário: **http://localhost:8080/usuario/cadastro**

>Rota de Listagem de Usuários: **http://localhost:8080/usuario/listar**

> Rota de Cadastro de Projeto: **http://localhost:8080/projeto/cadastro**

> Rota de Listagem de Projetos: **http://localhost:8080/projeto/listar**


## Estrutura de Pastas
- controller: contém os controllers responsáveis por receber requisições HTTP, tratar entrada de dados e direcionar o fluxo da aplicação
- service: concentra as regras de negócio e validações
- repository: responsável pela comunicação com o banco de dados e persistência das entidades
- entity: define as entidades de domínio do sistema (Usuário e Projeto)
- static: armazena os arquivos estáticos como css
- templates: telas em html do projeto

## Decisões Técnincas

### Por que java e SpringBoot?
Apesar do desafio sugerir uma abordagem mais simples e persistência leve, optei por utilizar Java com Spring Boot por três motivos principais:

- java é uma das linguagens mencionadas nos requisitos da vaga.

- spring Boot é amplamente utilizado no desenvolvimento de APIs REST, que é um dos principais produtos e especialidades da Sensedia.

- me permitiu aplicar conceitos importantes para backend, como separação de camadas, validações no servidor, organização de domínio e exposição de endpoints REST de forma clara.
### Por que SQLite?
 
Além de ser o banco de dados recomendado na documentação do desafio, é leve e fácil de configurar em relação a outros bancos, pois gera automaticamene um arquivo db fácilmente transportável.

## Uso de Inteligência Artificial

Conforme solicitado nos requisitos, declaro que utilizei a ferramenta de IA Gemini para auxiliar no diagnósticos de erros de rotas

