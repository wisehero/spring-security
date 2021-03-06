package com.prgrms.devcourse.springsecuritymasterclass.user;

public class LoginRequest {

    private String principal;
    private String credentials;

    protected LoginRequest() {

    }

    public LoginRequest(String principal, String credentials) {
        this.principal = principal;
        this.credentials = credentials;
    }

    public String getPrincipal() {
        return principal;
    }

    public String getCredentials() {
        return credentials;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LoginRequest{");
        sb.append("principal='").append(principal).append('\'');
        sb.append(", credentials='").append(credentials).append('\'');
        sb.append('}');
        return sb.toString();
    }
}