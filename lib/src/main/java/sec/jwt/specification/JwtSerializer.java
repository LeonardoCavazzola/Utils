package sec.jwt.specification;

import sec.jwt.ClaimsBody;

public interface JwtSerializer {
    String serialize(ClaimsBody claimsBody);
}
