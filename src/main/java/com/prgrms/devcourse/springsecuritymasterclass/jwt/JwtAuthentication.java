package com.prgrms.devcourse.springsecuritymasterclass.jwt;

import static org.apache.logging.log4j.util.Strings.isNotEmpty;
import static com.google.common.base.Preconditions.checkArgument;

public class JwtAuthentication {

    private final String token;
    private final String username;

    public JwtAuthentication(String token, String username) {
        checkArgument(isNotEmpty(token), "token must be provided");
        checkArgument(isNotEmpty(username), "username must be provided");
        this.token = token;
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public String getUsername() {
        return username;
    }
}