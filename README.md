TODO LIST

API para gerenciar tarefas (CRUD).

Tecnologias utilizadas:
* Spring Boot
* Spring MVC
* Spring Data JPA
* SpringDoc OpenAPI 3
* Mysql

Práticas adotadas:
* SOLID, DRY, YAGNI, KISS
* API REST
* Consultas com Spring Data JPA
* Injeção de dependências
* Tratamento de respostas de erro
* Geração automática do Swagger com a OpenAPI 3

COMO EXECUTAR

* Clonar repositório git
* Contruir o projeto:

$ ./mvnw clean package

*Executar a aplicação:

$ java -jar target/todolist-0.0.1-SNAPSHOT.jar

A API poderá ser acessada em localhost:8080. O swagger poderá ser visualizado em localhost:8080/swagger-ui.html

API Endpoints

Para fazer as requisições HTTP abaixo, foi utilizada a ferramenta POSTMAN:

*Criar tarefa

Postman -> POST -> Inserir http://localhost:8080/todos ->
Body -> raw formato JSON 

Após inserir informações:

[
    {
        "descricao": "Desc Todo 1",
        "nome": "Todo 1 ",
        "prioridade": 1,
        "realizado": false
    }
]

Pressionar SEND

*Listar tarefa

Postman -> GET -> Inserir http://localhost:8080/todos ->Pressionar SEND

[
    {
        "descricao": "Desc Todo 1",
        "nome": "Todo 1 ",
        "prioridade": 1,
        "realizado": false
    }
]

* Atualizar tarefas

Postman -> PUT -> Inserir http://localhost:8080/todos ->
Body -> raw formato JSON 

Inserir as informações:

[
    {
        "id": 1,
        "descricao": "Desc Todo update 1",
        "nome": "Updated Todo 1 ",
        "prioridade": 2,
        "realizado": false
    }
]

Pressionar SEND

* Deletar tarefas

Postman -> PUT -> Inserir http://localhost:8080/todos/1 -> Pressionar SEND

[]