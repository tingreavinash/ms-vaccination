package io.github.tingreavinash.microservice.citizenservice.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

@Getter
@Setter
public class MyUserDetails implements UserDetails {
    String username;
    String password;
    boolean enabled;
    boolean accountNonExpired;
    boolean accountNonLocked;
    boolean credentialsNonExpired;
    List<GrantedAuthority> authorities;


}
