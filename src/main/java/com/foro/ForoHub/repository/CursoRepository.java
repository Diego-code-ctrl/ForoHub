package com.foro.ForoHub.repository;

import com.foro.ForoHub.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author diegobecerril
 */
public interface CursoRepository extends JpaRepository<Curso, Long>{
    
    public Curso findByNombre(String nombre);

}
