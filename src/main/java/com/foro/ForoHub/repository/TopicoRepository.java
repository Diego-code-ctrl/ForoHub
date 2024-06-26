package com.foro.ForoHub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.foro.ForoHub.entity.Topico;

/**
 *
 * @author diegobecerril
 */
public interface TopicoRepository extends JpaRepository<Topico, Long>{
    
    public Topico findByTitulo(String titulo);
}
