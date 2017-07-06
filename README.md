crm-protocol
===================

Micro servi�o respons�vel por registrar manifesta��es do cliente.

----------

Requisitos
-------------

Todas os itens relacionados abaixo ser�o necess�rios para compilar e/ou executar o micro servi�o. 

- java jdk-8u131-windows-x64.
- docker version 17.06.0-ce 
- maven 3.3.9

Artefatos

- spring-boot-starter-parent 1.5.1.RELEASE
- spring-cloud-netflix 1.3.1.RELEASE
- docker-maven-plugin 0.4.14

> **Nota:** A correta execu��o desse projeto ser� garantida caso seja utilizada as vers�es citadas anteriormente.

Compilar
-------------
No diret�rio raiz do projeto executar: **mvn clean install docker:build**

Executar
-------------

Executar: **docker run --name i1-crm-manifestation -d -p 8282:8282 --add-host infra-eureka:$(docker inspect --format '{{.NetworkSettings.IPAddress}}' i1-infra-eureka) --add-host crm-protocol:$(docker inspect --format '{{.NetworkSettings.IPAddress}}' i1-crm-protocol) -it crm-manifestation cat /etc/hosts**


POST http://localhost:8282/manifestations (nova manifesta��o)

Request

{
    "cpf": "00011122233",
    "nome": "Nome",
    "email": "email@email.com",
    "telefone": "1112345678",
    "celular": "1112345678",
    "tipoContato": "RECLAMACAO",
    "motivoContato": "ATENDIMENTO",
    "mensagem": "Nova mensagem"
}

GET http://localhost:8282/manifestations/1 (recuperar manifesta��o por id)

Response

{
    "idManifestacao": 1,
    "protocolo": "20170706041711707",
    "cpf": "00011122233",
    "nome": "Nome",
    "email": "email@email.com",
    "telefone": "1112345678",
    "celular": "1112345678",
    "dataCriacao": 1499314631639,
    "tipoContato": "RECLAMACAO",
    "motivoContato": "ATENDIMENTO",
    "mensagem": "Nova mensagem"
}

PUT http://localhost:8282/manifestations/1 (Editar manifesta��o)

Request

{
    "cpf": "00011122233",
    "nome": "Nome",
    "email": "email@email.com",
    "telefone": "1112345678",
    "celular": "1112345678",
    "tipoContato": "RECLAMACAO",
    "motivoContato": "ATENDIMENTO",
    "mensagem": "Nova mensagem"
}

DELETE http://localhost:8282/manifestations/1 (Excluir manifesta��o)