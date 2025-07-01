package org.spring.milliytaomlar.config;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtService {
@Value("${token.secret.key}")
    private String secretKey;

@Value("${jwt.access.expiry}")
private String accessTokenExpiry;
@Value("${jwt.refresh.expiry}")
private String refreshTokenExpiry;
public String generateToken(String username){
    Date expiryDate = new Date(System.currentTimeMillis() + Long.parseLong(accessTokenExpiry));
    return Jwts.builder()
            .setSubject(username)
            .setIssuedAt(new Date(System.currentTimeMillis()))
            .setExpiration(expiryDate)
            .signWith(Keys.hmacShaKeyFor(secretKey.getBytes()), SignatureAlgorithm.HS256)
            .compact();
}



public String generateRefreshToken(UserDetails userEntity) {
        Date expiryDate = new Date(System.currentTimeMillis() + Long.parseLong(refreshTokenExpiry));
        return Jwts.builder()
                .signWith(Keys.hmacShaKeyFor(secretKey.getBytes()), SignatureAlgorithm.HS256)
                .setSubject(userEntity.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)
                .compact();
    }

public String extractUsername(String token){
    return Jwts.parserBuilder()
            .setSigningKey(secretKey.getBytes())
            .build()
            .parseClaimsJws(token).getBody().getSubject();
}


public boolean isTokenExpired(String token){
    return Jwts.parserBuilder()
            .setSigningKey(secretKey.getBytes())
            .build()
            .parseClaimsJws(token).getBody().getExpiration().before(new Date());
}



public boolean isValidToken(String token, UserDetails userDetails){
    String user = extractUsername(token);
    return user.equals(userDetails.getUsername())&&!isTokenExpired(token);
}


}
