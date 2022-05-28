package com.prgrms.devcourse.springsecuritymasterclass.user;

public class UserDto {

    private final String token;
    private final String username;
    private final String group;

    public UserDto(String token, String username, String group) {
        this.token = token;
        this.username = username;
        this.group = group;
    }

    public String getToken() {
        return token;
    }

    public String getUsername() {
        return username;
    }

    public String getGroup() {
        return group;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserDto{");
        sb.append("token='").append(token).append('\'');
        sb.append(", username='").append(username).append('\'');
        sb.append(", group='").append(group).append('\'');
        sb.append('}');
        return sb.toString();
    }
}