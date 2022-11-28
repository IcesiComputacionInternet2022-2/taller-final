package com.edu.icesi.virtualshop.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;
import java.util.Map;

public class JWTParser {

    private static final String SECRET_KEY= "contodorespetoprofesornovoyahacerunallavesecretaparaalgoacademicoxd";

    public static String createJWT(String id,Map<String, String> claims, long ttlMilis){
        SignatureAlgorithm algorithm = SignatureAlgorithm.HS256;
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(SECRET_KEY);

        Key signInKey = new SecretKeySpec(apiKeySecretBytes, algorithm.getJcaName());
        JwtBuilder builder = Jwts.builder().setId(id)
                .setIssuedAt(now)
                .setClaims(claims)
                .signWith(signInKey, algorithm);

        if(ttlMilis > 0){
            long expMillis = nowMillis + ttlMilis;
            Date expDate = new Date(expMillis);
            builder.setExpiration(expDate);
        }

        return builder.compact();
    }

    public static Claims decodeJWT(String jwt){
        return Jwts.parserBuilder().setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY)).build().parseClaimsJws(jwt).getBody();
    }

}
