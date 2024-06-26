package com.foro.ForoHub.controller;

import com.foro.ForoHub.entity.Usuario;
import com.foro.ForoHub.model.DatosJWTToken;
import com.foro.ForoHub.model.DatosUsuario;
import com.foro.ForoHub.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author diegobecerril
 */
@RestController
@RequestMapping("/login")
public class AutenticacionController {
    
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private TokenService tokenService;
    
    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody @Validated DatosUsuario datosUsuario){
        Authentication authToken = new UsernamePasswordAuthenticationToken(datosUsuario.login(), datosUsuario.clave());
        var usuarioAutenticado = authenticationManager.authenticate(authToken);
        var jwtToken = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());
        return ResponseEntity.ok(new DatosJWTToken(jwtToken));
    }
}
