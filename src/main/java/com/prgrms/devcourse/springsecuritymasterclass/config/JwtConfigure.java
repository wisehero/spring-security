package com.prgrms.devcourse.springsecuritymasterclass.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "jwt")
public class JwtConfigure {

    private String header;
    private String issuer;
    private String clientSecret;
    private int expirySeconds;

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public int getExpirySeconds() {
        return expirySeconds;
    }

    public void setExpirySeconds(int expirySecond) {
        this.expirySeconds = expirySecond;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("JwtConfigure{");
        sb.append("header='").append(header).append('\'');
        sb.append(", issuer='").append(issuer).append('\'');
        sb.append(", clientSecret='").append(clientSecret).append('\'');
        sb.append(", expirySecond=").append(expirySeconds);
        sb.append('}');
        return sb.toString();
    }
}