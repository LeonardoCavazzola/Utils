package tk.leonardocavazzola.utils.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.impl.DefaultClaims;

import java.util.HashMap;
import java.util.Map;

public class ClaimsBody {
    private final String subject;
    private final String issuer;
    private final Map<String, Object> other;

    private ClaimsBody(String subject, String issuer, Map<String, Object> other) {
        this.subject = subject;
        this.issuer = issuer;
        this.other = other;
    }

    public String getIssuer() {
        return issuer;
    }

    public String getSubject() {
        return subject;
    }

    public Object getOther(String name) {
        return other.get(name);
    }

    Claims toClaims() {
        return new DefaultClaims(other).setSubject(subject).setIssuer(issuer);
    }

    static ClaimsBody fromClaims(Claims claims) {
        return new ClaimsBody(claims.getSubject(), claims.getIssuer(), new HashMap<>(claims));
    }

    public static class Builder {
        private String subject;
        private String issuer;
        private final Map<String, Object> other;

        public Builder(String subject) {
            this.subject = subject;
            this.other = new HashMap<>();
        }

        public Builder setIssuer(String issuer) {
            this.issuer = issuer;
            return this;
        }

        public Builder setSubject(String subject) {
            this.subject = subject;
            return this;
        }

        public Builder setOther(String name, Object value) {
            other.put(name, value);
            return this;
        }

        public ClaimsBody build() {
            return new ClaimsBody(subject, issuer, other);
        }
    }
}
