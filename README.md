crm-protocol
===================

Micro serviço responsável por registrar manifestações do cliente.

----------

Requisitos
-------------

Todas os itens relacionados abaixo serão necessários para compilar e/ou executar o micro serviço. 

- java jdk-8u131-windows-x64.
- docker version 17.06.0-ce 
- maven 3.3.9

Artefatos

- spring-boot-starter-parent 1.5.1.RELEASE
- spring-cloud-netflix 1.3.1.RELEASE
- docker-maven-plugin 0.4.14

> **Nota:** A correta execução desse projeto será garantida caso seja utilizada as versões citadas anteriormente.

Compilar
-------------
No diretório raiz do projeto executar: **mvn clean install docker:build**

Executar
-------------

Executar: **docker run --name i1-crm-manifestation -d -p 8282:8282 --add-host infra-eureka:$(docker inspect --format '{{.NetworkSettings.IPAddress}}' i1-infra-eureka) --add-host crm-protocol:$(docker inspect --format '{{.NetworkSettings.IPAddress}}' i1-crm-protocol) -it crm-manifestation cat /etc/hosts**


POST http://localhost:8282/manifestations (nova manifestação)

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

GET http://localhost:8282/manifestations/1 (recuperar manifestação por id)

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

PUT http://localhost:8282/manifestations/1 (Editar manifestação)

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

DELETE http://localhost:8282/manifestations/1 (Excluir manifestação)