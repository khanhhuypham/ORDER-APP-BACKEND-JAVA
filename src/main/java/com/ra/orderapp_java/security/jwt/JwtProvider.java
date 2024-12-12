package com.ra.orderapp_java.security.jwt;

import com.ra.orderapp_java.security.UserPrinciple;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtProvider {
    @Value("${expired}")
    private Long EXPIRED;

    @Value("${secret_key}")
    private String SECRET_KEY;

    private Logger logger = LoggerFactory.getLogger(JwtProvider.class);

    public String generateToken(UserPrinciple userPrinciple) {
        Date dateExpiration = new Date(System.currentTimeMillis() + EXPIRED);

        return Jwts.builder().setSubject(userPrinciple.getUsername())
                .signWith(SignatureAlgorithm.HS512,SECRET_KEY)
                .setExpiration(dateExpiration)
                .compact();
    }

    public boolean validateToken(String token) {
        try{
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
            return true;
        }catch (ExpressionException | SignatureException | MalformedJwtException e) {
            logger.error(e.getMessage());
        }
        return false;
    }

    public String getUsernameFromToken(String token) {

        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getSubject();
    }

}
