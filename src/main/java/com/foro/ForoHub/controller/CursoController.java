package com.foro.ForoHub.controller;

import com.foro.ForoHub.entity.Curso;
import com.foro.ForoHub.model.RegistroCurso;
import com.foro.ForoHub.repository.CursoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author diegobecerril
 */

@RestController()
@RequestMapping("/cursos")
public class CursoController {
    
    @Autowired
    private CursoRepository cursoRepository;
    
    @PostMapping("/agregarCurso")
    public ResponseEntity registrarCurso(@RequestBody RegistroCurso curso){
        Optional<Curso> existeCurso = cursoRepository.findByNombre(curso.nombre());
        
        if (existeCurso.isEmpty()) {
            cursoRepository.save(new Curso(curso));
            return ResponseEntity.ok(curso);
        } else{
            return ResponseEntity.ok("Curso ya registrado");
        }
    }
    
    @GetMapping("/listarCursos")
    public List<Curso> listarCurosos(){
        return cursoRepository.findAll();
    }
    
    @PutMapping("/modificarCurso")
    public void modificarCurso(@RequestBody RegistroCurso curso){
        
    }
    
    @DeleteMapping("/eliminarCurso")
    public void eliminarCurso(@RequestParam String nombre){
        
    }
}
