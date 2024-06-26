package com.foro.ForoHub.controller;

import com.foro.ForoHub.entity.Curso;
import com.foro.ForoHub.model.RegistroCurso;
import com.foro.ForoHub.repository.CursoRepository;
import jakarta.transaction.Transactional;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
        Curso existeCurso = cursoRepository.findByNombre(curso.nombre());
        
        if (existeCurso == null) {
            cursoRepository.save(new Curso(curso));
            return ResponseEntity.ok(curso);
        } else{
            return ResponseEntity.ok("Curso ya registrado");
        }
    }
    
    @GetMapping("/listarCursos")
    public Stream<Curso> listarCurosos(){
        return cursoRepository.findAll().stream().filter(curso -> curso.isActivo());
    }
    
    @PutMapping("/modificarCurso")
    @Transactional
    public ResponseEntity actualizarCurso(@RequestBody RegistroCurso registroCurso){
        Curso curso = cursoRepository.findByNombre(registroCurso.nombre());
        if (curso == null) {
            return ResponseEntity.ok("Registro no encontrado");
        }
        curso.actualizarDatos(registroCurso);
        return ResponseEntity.ok("Registro actualizado");
    }
    
    @DeleteMapping("/eliminarCurso/{id}")
    @Transactional
    public void eliminarCurso(@PathVariable Long id){
        Curso curso = cursoRepository.getReferenceById(id);
        if (curso == null) {
            return;
        }
        curso.desactivarCurso();
    }
}
