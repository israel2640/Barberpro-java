package br.com.barberpro.api.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

// Esta é uma abordagem mais tradicional e robusta para propriedades aninhadas
@Component
@ConfigurationProperties(prefix = "api")
public class ApiProperties {

    private final Security security = new Security();

    public Security getSecurity() {
        return security;
    }

    public static class Security {
        private final Token token = new Token();

        public Token getToken() {
            return token;
        }
    }

    public static class Token {
        private String secret;

        public String getSecret() {
            return secret;
        }

        public void setSecret(String secret) {
            this.secret = secret;
        }
    }
}