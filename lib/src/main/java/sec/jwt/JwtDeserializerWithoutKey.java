package sec.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import sec.jwt.specification.JwtDeserializer;

public class JwtDeserializerWithoutKey implements JwtDeserializer {
    private final JwtParser parser = Jwts.parserBuilder().build();

    @Override
    public ClaimsBody deserialize(String jwt) {
        int index = jwt.lastIndexOf('.');
        String withoutSignature = jwt.substring(0, index+1);

        Claims claims = (Claims) parser.parse(withoutSignature).getBody();

        return ClaimsBody.fromClaims(claims);
    }
}
