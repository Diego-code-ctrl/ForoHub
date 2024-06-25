package com.foro.ForoHub.repository;

import com.foro.ForoHub.entity.Curso;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author diegobecerril
 */
public interface CursoRepository extends JpaRepository<Curso, Long>{
    
    public Optional<Curso> findByNombre(String nombre);
}
