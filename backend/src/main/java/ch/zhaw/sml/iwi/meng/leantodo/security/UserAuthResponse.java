package ch.zhaw.sml.iwi.meng.leantodo.security;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserAuthResponse {
    private String loginName;
    private List<String> roles = new ArrayList<>();
    private Date expiresAt;
    
    @JsonIgnore
    private String jwsToken;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public Date getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(Date expiresAt) {
        this.expiresAt = expiresAt;
    }

    public String getJwsToken() {
        return jwsToken;
    }

    public void setJwsToken(String jwsToken) {
        this.jwsToken = jwsToken;
    }

}