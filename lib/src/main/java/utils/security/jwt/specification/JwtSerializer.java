package utils.security.jwt.specification;

import utils.security.jwt.ClaimsBody;

public interface JwtSerializer {
    String serialize(ClaimsBody claimsBody);
}
