package utils.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import utils.security.jwt.specification.JwtUtils;

import java.security.Key;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.TemporalAmount;
import java.util.Date;

public class JwtUtilsImp implements JwtUtils {
    private final JwtParser parser;
    private final JwtBuilder builder;
    private final TemporalAmount duration;

    public JwtUtilsImp(String key, Long duration) {
        Key key1 = Keys.hmacShaKeyFor(key.getBytes());
        this.parser = Jwts.parserBuilder().setSigningKey(key1).build();
        this.builder = Jwts.builder().signWith(key1);
        this.duration = Duration.ofMillis(duration);
    }

    @Override
    public String serialize(ClaimsBody claimsBody) {
        Instant expirationInstant = Instant.now().plus(duration);
        Date expiration = Date.from(expirationInstant);
        return builder.addClaims(claimsBody.toClaims())
                .setExpiration(expiration)
                .compact();
    }

    @Override
    public ClaimsBody deserialize(String jwt) {
        Claims claims = (Claims) parser.parse(jwt).getBody();
        return ClaimsBody.fromClaims(claims);
    }
}

