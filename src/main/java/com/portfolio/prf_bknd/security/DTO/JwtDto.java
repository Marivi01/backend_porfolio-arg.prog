

package com.portfolio.prf_bknd.security.DTO;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;


public class JwtDto {
 private String token;
 private String bearer = "Bearer";
 private String nombreUsuario;
 Collection<? extends GrantedAuthority> authorities;

    public JwtDto(String token, String nombreUsuario, Collection<? extends GrantedAuthority> autorities) {
        this.token = token;
        this.nombreUsuario = nombreUsuario;
        this.authorities = autorities;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getBearer() {
        return bearer;
    }

    public void setBearer(String bearer) {
        this.bearer = bearer;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
 
 
}
