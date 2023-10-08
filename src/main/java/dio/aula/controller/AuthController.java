package dio.aula.controller;

import dio.aula.model.Usuario;
import dio.aula.security.AuthToken;
import dio.aula.security.TokenUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @GetMapping("/free")
    public String sayFreeHello(){
        return "Endpoint liberado pela API";
    }
    @GetMapping("/auth")
    public String sayAuthHello(){
        return "Endpoint necessita de autenticação";
    }
    @PostMapping("/login")
    public ResponseEntity<AuthToken> realizarLogin(@RequestBody Usuario u){
        if(u.getLogin().equals("enoque") && u.getSenha().equals("12345")){
            return ResponseEntity.ok(TokenUtil.encodeToken(u));
        }
        return ResponseEntity.status(403).build();
    }
}
