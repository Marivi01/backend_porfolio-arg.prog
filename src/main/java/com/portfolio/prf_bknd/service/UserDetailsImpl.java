
package com.portfolio.prf_bknd.service;

import com.portfolio.prf_bknd.security.Entity.Usuario;
import com.portfolio.prf_bknd.security.Entity.UsuarioPrincipal;
import com.portfolio.prf_bknd.security.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsImpl implements UserDetailsService{
    @Autowired
    UsuarioService usuarioService;

    @Override
public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
Usuario usuario = usuarioService.getByNombreUsuario(nombreUsuario).get();
return UsuarioPrincipal.build(usuario);
    }
}
