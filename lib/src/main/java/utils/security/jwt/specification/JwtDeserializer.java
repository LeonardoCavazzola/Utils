package utils.security.jwt.specification;

import utils.security.jwt.ClaimsBody;

public interface JwtDeserializer {
    ClaimsBody deserialize(String jwt);
}
