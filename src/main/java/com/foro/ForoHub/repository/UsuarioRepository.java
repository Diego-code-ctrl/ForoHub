package com.foro.ForoHub.repository;

import com.foro.ForoHub.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author diegobecerril
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

    public UserDetails findByLogin(String username);
    
}
