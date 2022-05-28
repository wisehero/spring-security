package com.prgrms.devcourse.springsecuritymasterclass.user;

import javax.persistence.*;
import java.util.Optional;

import static com.google.common.base.Preconditions.checkArgument;
import static org.apache.logging.log4j.util.Strings.isNotEmpty;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "login_id")
    private String provider;

    @Column(name = "passwd")
    private String providerId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "group_id")
    private Group group;

    @Column(name = "profile_image")
    private String profileImage;

    protected User() {
    }

    public User(String username, String provider, String providerId, Group group, String profileImage) {
        checkArgument(isNotEmpty(username), "username must be provided");
        checkArgument(isNotEmpty(provider), "provider must be provided");
        checkArgument(isNotEmpty(providerId), "providerId must be provided");
        checkArgument(group != null, "group must be provided");
        this.username = username;
        this.provider = provider;
        this.providerId = providerId;
        this.group = group;
        this.profileImage = profileImage;
    }

    public Long getId() {
        return id;
    }

    public String getProvider() {
        return provider;
    }

    public String getProviderId() {
        return providerId;
    }

    public String getUsername() {
        return username;
    }

    public Optional<String> getProfileImage() {
        return Optional.ofNullable(profileImage);
    }

    public Group getGroup() {
        return group;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("id=").append(id);
        sb.append(", username='").append(username).append('\'');
        sb.append(", provider='").append(provider).append('\'');
        sb.append(", providerId='").append(providerId).append('\'');
        sb.append(", group=").append(group);
        sb.append(", profileImage='").append(profileImage).append('\'');
        sb.append('}');
        return sb.toString();
    }
}