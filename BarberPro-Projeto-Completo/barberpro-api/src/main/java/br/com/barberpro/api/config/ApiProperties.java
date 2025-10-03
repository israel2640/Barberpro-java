package br.com.barberpro.api.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "api")
public record ApiProperties(Security security) {
    public record Security(Token token) {}
    public record Token(String secret) {}
}