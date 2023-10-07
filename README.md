# SpringSecurity_JWT

## Em construção 🚧

- Java 17 e Spring Boot v3.1.4
- Apresentação básica do Spring Security - Autenticação e Autorização com JWT Tokens.
- Os professores Glayson Sampaio e Isidoro foram os responsáveis para que eu pudesse por em prática esse conceito inicial do Spring Security.

#### Testando a API usando o Postman

- Ao enviar um GET para "http://localhost:8080/free" o programa retorna a mensagem "Endpoint liberado pela API" confirmando o sucesso da comunicação. 
- Ao enviar um GET para "http://localhost:8080/auth" o programa retorna o Status 403 Forbidden pois ele espera um token de autorização.
- Ao definir o tipo **Bearer Token** e inserir o token esperado pela API, o programa retorna a mensagem "Endpoint necessita de autenticação".
- Caso o usuário insira o token inválido, o programa retorna o Status 401 e a mensagem "Usuario não autorizado para este sistema", esta que foi personalizada dentro do código. 