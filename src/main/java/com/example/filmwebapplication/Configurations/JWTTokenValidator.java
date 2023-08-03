package com.example.filmwebapplication.Configurations;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Date;
import java.util.Map;

@Component
public class JWTTokenValidator {

    public static final String SECRET_KEY;

    static {
        SECRET_KEY = "4d93a47b3b411c7d50b37eaa3f9f3b2757fe2781195b2c6f1c7dedd7ff5922cd";
    }
    private static final long EXPIRATION_TIME = 86400000;

    private static String generateSecureKey() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] keyBytes = new byte[32];
        secureRandom.nextBytes(keyBytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(keyBytes);
    }

    public String generateToken(String username) {
        Date now = new Date();
        Date expiration = new Date(now.getTime() + EXPIRATION_TIME);

        Header header = Jwts.header().setType("JWT");

        byte[] decodedKey = Base64.getUrlDecoder().decode(SECRET_KEY);
        SecretKey secretKey = new SecretKeySpec(decodedKey, SignatureAlgorithm.HS256.getJcaName());

        return Jwts.builder()
                .setHeader((Map<String, Object>) header)
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(secretKey)
                .compact();
    }

    public String extractUsername(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(Base64.getUrlDecoder().decode(SECRET_KEY))
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }
}
