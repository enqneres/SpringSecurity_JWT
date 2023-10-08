package dio.aula.security;

import dio.aula.model.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import java.security.Key;
import java.util.Collections;
import java.util.Date;

public class TokenUtil {
    private static final String EMISSOR = "enoque";
    private static final String TOKEN_HEADER = "Bearer";
    private static final String TOKEN_KEY = "82749503459823409123450381235864";
    private static final long UM_SEGUNDO = 1000;
    private static final long UM_MINUTO = 20*UM_SEGUNDO;
    public static AuthToken encodeToken(Usuario u){
        Key secretKey = Keys.hmacShaKeyFor(TOKEN_KEY.getBytes());
        String tokenJWT = Jwts.builder()
                .setSubject(u.getLogin())
                .setIssuer(EMISSOR)
                .setExpiration(new Date(System.currentTimeMillis() + UM_MINUTO))
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact();
        AuthToken token = new AuthToken(TOKEN_HEADER + tokenJWT);
        return token;
    }
    public static Authentication decodeToken(HttpServletRequest request) {
        try {
            String jwtToken = request.getHeader("Authorization");
            jwtToken = jwtToken.replace(TOKEN_HEADER, "");

            Jws<Claims> jwsClaims = Jwts.parserBuilder().setSigningKey(TOKEN_KEY.getBytes()).build().parseClaimsJws(jwtToken);

            String usuario = jwsClaims.getBody().getSubject();
            String emissor = jwsClaims.getBody().getIssuer();
            Date validade = jwsClaims.getBody().getExpiration();

            if (usuario.length() > 0 && emissor.equals(EMISSOR) && validade.after(new Date(System.currentTimeMillis()))) {
                return new UsernamePasswordAuthenticationToken("user", null, Collections.emptyList());
            }
        }
        catch (Exception ex){
            System.out.println("DEBUG - Erro ao decodificar token");
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
