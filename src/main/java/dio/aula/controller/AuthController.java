package dio.aula.controller;

import org.springframework.web.bind.annotation.GetMapping;
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
}
