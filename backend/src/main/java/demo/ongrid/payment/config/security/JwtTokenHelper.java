package demo.ongrid.payment.config.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import  io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class JwtTokenHelper {
    public static final long JWT_TOKEN_VALIDITY = 60 * 60 * 1000;  // token validity in milliseconds
    private String secret = "HRlELXqpSB";
    Date currentDate = new Date();
    Date expiredDate = new Date(currentDate.getTime() + JWT_TOKEN_VALIDITY);

    public String generateToken(Authentication authentication) {
        String username = authentication.getName();
        return doGenerateToken(username);
    }
    /*     while creating the token -
            1. Build the token and set Issuer, Expiration, Subject etc.
            2. Sign the JWT using the HS512 algorithm and secret key.
            3. According to JWS Compact Serialization(https://tools.ietf.org/html/draft-ietf-jose-json-web-signature-41#section-3.1)
               compaction of the JWT to a URL-safe string
    */
    private String doGenerateToken(String subject) {
        return Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(currentDate)
                .setExpiration(expiredDate)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public  String getUsernameFromToken(String token){
        Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }


    /*
        By calling parseClaimsJws(token), we are performing essential security checks on the JWT, such as:
        Verifying the signature to ensure the token has not been modified since it was signed.
        Checking the token's expiration time to ensure it is not expired.
        Ensuring that the token is issued by a trusted authority (the issuer validation can be done separately if needed).
    */
    public  Boolean validateToken(String token){
        try{
            // Parse and verify the JWT token using the specified secret key
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            // If parsing succeeds, the token is valid
            return true;
        }catch (Exception e){
            // If an exception occurs during parsing, the token is invalid or expired
            throw new AuthenticationCredentialsNotFoundException("JWT is expired or incorrect");
        }
    }
}


