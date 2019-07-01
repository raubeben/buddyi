package ch.zhaw.sml.iwi.meng.leantodo.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

public class JwtAuthentication implements Authentication {

    private static final long serialVersionUID = 1L;

    private Jws<Claims> jws;

    public JwtAuthentication(Jws<Claims> jws) {
        this.jws = jws;
    }

    @Override
    public String getName() {
        return jws.getBody().getSubject();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        String authoritiesString = jws.getBody().get("ROLES").toString();
        for (String role : authoritiesString.split(",")) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }

    @Override
    public Object getCredentials() {
        return jws;
    }

    @Override
    public Object getDetails() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return jws.getBody().getSubject();
    }

    @Override
    public boolean isAuthenticated() {
        return true;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {

    }

}