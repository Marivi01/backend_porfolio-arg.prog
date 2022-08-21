
package com.portfolio.prf_bknd.security.Controler;

import com.portfolio.prf_bknd.security.DTO.JwtDto;
import com.portfolio.prf_bknd.security.DTO.LoginUsuario;
import com.portfolio.prf_bknd.security.DTO.NuevoUsuario;
import com.portfolio.prf_bknd.security.Entity.Rol;
import com.portfolio.prf_bknd.security.Entity.Usuario;
import com.portfolio.prf_bknd.security.Enum.RolNombre;
import com.portfolio.prf_bknd.security.Service.RolService;
import com.portfolio.prf_bknd.security.Service.UsuarioService;
import com.portfolio.prf_bknd.security.jwt.JwtProviders;
import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@Validated
@RequestMapping("/auth")
public class AuthControler {
   @Autowired
   PasswordEncoder passwordEncoder;
   @Autowired
   AuthenticationManager authenticationManager;
   @Autowired
   UsuarioService usuarioService;
   
   @Autowired
   RolService rolService;
   @Autowired
   JwtProviders jwtProviders;
   
   @CrossOrigin
   @PostMapping("/nuevo")
       public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario,
               BindingResult bindingResult){
          if(bindingResult.hasErrors())
              return new ResponseEntity
   (new Mensaje ("campo mal ingresado o email incorrecto"), HttpStatus.BAD_REQUEST);
   
          if (usuarioService.existsByNombreUsuario(nuevoUsuario.getNombreUsuario ()))
              return new ResponseEntity(new Mensaje ("El nombre de usuario ya existe"),HttpStatus.BAD_REQUEST);

       if (usuarioService.existsByEmail(nuevoUsuario.getEmail ()))
              return new ResponseEntity(new Mensaje ("El email de usuario ya existe"),HttpStatus.BAD_REQUEST);
       
       Usuario usuario = new Usuario(nuevoUsuario.getNombre(),nuevoUsuario.getNombreUsuario(),
       nuevoUsuario.getEmail(), passwordEncoder.encode(nuevoUsuario.getPassword()));
       
       Set<Rol> roles = new HashSet<>();
       roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());
       
       if(nuevoUsuario.getRoles().contains("admin"))
         roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());  
         usuario.setRoles(roles);
         usuarioService.save(usuario);
         
         return new ResponseEntity(new Mensaje ("Usuario guardado"),HttpStatus.CREATED);
        }
       
       
       @CrossOrigin
       @PostMapping("/login")
       @Validated
       public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult)
       {
           if(bindingResult.hasErrors())
               return new ResponseEntity(new Mensaje ("Campos mal puestos"),HttpStatus.BAD_REQUEST);
          
           Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken
        (loginUsuario.getNombreUsuario(),loginUsuario.getPassword()));
           
           SecurityContextHolder.getContext().setAuthentication(authentication);
           
           String jwt = jwtProviders.generateToken(authentication);
           UserDetails userDetails = (UserDetails) authentication.getPrincipal();
           JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
       return new ResponseEntity (jwtDto, HttpStatus.OK);
       }
       
       
       }
       
