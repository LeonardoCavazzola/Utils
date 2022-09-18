package sec.jwt.specification;

import sec.jwt.ClaimsBody;

public interface JwtDeserializer {
    ClaimsBody deserialize(String jwt);
}
