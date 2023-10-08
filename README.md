# Spring Security - Autorização e Autenticação com JWT Tokens

- Apresentação básica do Spring Security - Autenticação e Autorização com JWT Tokens.
- Java 17 e Spring Boot v3.1.4
- Os professores [Glayson Sampaio](https://github.com/glysns) e [Isidoro](https://github.com/professorisidro) foram os responsáveis para que eu pudesse por em prática esse conceito inicial do Spring Security.

#### Testando a API usando o Postman

- Ao enviar um GET para "http://localhost:8080/free" o programa retorna a mensagem "Endpoint liberado pela API" confirmando o sucesso da comunicação. 
- Ao enviar um GET para "http://localhost:8080/auth" o programa retorna o Status 403 Forbidden pois ele espera um token de autorização.
- Ao definir o tipo **Bearer Token** e inserir o token esperado pela API, o programa retorna a mensagem "Endpoint necessita de autenticação".
- Caso o usuário insira o token inválido, o programa retorna o Status 401 e a mensagem "Usuario não autorizado para este sistema", esta que foi personalizada dentro do código. 
- Ao enviar um POST para "http://localhost:8080/login" inserindo login e senha pré-definidos no código, o programa retorna um token válido por 20 segundos (definido dentro do código).
- Após passar os 20 segundos, o programa retorna a mensagem "Usuario não autorizado para este sistema"