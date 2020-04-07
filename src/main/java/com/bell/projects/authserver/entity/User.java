package com.bell.projects.authserver.entity;

import org.codehaus.jackson.map.Serializers;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "USER")
public class User extends BaseIdEntity implements UserDetails {

//    ID INT PRIMARY KEY AUTO_INCREMENT,
//    USERNAME VARCHAR(24) NOT NULL,
//    PASSWORD VARCHAR(255) NOT NULL,
//    EMAIL VARCHAR(255) NOT NULL,
//    ENABLED BIT(1) NOT NULL,
//    ACCOUNT_EXPIRED BIT(1) NOT NULL,
//    CREDENTIALS_EXPIRED BIT(1) NOT NULL,
//    ACCOUNT_LOCKED BIT(1) NOT NULL,

    private String email;
    private String username;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    private boolean enabled;

    @Column(name = "account_locked")
    private boolean accountNonLocked;

    @Column(name = "account_expired")
    private boolean accountNonExpired;

    @Column(name = "credentials_expired")
    private boolean credentialsNonExpired;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "role_user", joinColumns = {
            @JoinColumn(name = "user_id", referencedColumnName = "id")}, inverseJoinColumns = {
                @JoinColumn(name = "role_id", referencedColumnName = "id")
    })
    private List<Role> roles;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();

        roles.forEach(r -> {
            authorities.add(new SimpleGrantedAuthority(r.getRoleName()));
            r.getPermissions().forEach(p -> {
                authorities.add(new SimpleGrantedAuthority(p.getPermissionName()));
            });
        });

        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
