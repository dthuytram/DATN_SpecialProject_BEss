package com.tramdt.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.Collection;

public class JwtResponse implements Serializable {
    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwttoken;
    private  Long accountId;
    private String name;
    private String accountName;
    private String photoURL;
    private Collection<? extends GrantedAuthority> authorities;

    public JwtResponse(String jwttoken, Long accountId, String name, String accountName, String photoURL, Collection<? extends GrantedAuthority> authorities) {
        this.jwttoken = jwttoken;
        this.accountId = accountId;
        this.name = name;
        this.accountName = accountName;
        this.photoURL = photoURL;
        this.authorities = authorities;
    }

    public String getJwttoken() {
        return jwttoken;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
}


