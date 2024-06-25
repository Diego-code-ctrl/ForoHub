package com.foro.ForoHub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.foro.ForoHub.entity.Topico;
import java.util.Optional;

/**
 *
 * @author diegobecerril
 */
public interface TopicoRepository extends JpaRepository<Topico, Long>{
    
    public Optional<Topico> findByTitulo(String titulo);
}
