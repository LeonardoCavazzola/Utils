package tk.leonardocavazzola.utils.security.jwt.specification;

import tk.leonardocavazzola.utils.security.jwt.ClaimsBody;

public interface JwtSerializer {
    String serialize(ClaimsBody claimsBody);
}
