package com.foro.ForoHub.controller;

import com.foro.ForoHub.entity.Curso;
import com.foro.ForoHub.entity.Topico;
import com.foro.ForoHub.model.RegistroTopicos;
import com.foro.ForoHub.repository.CursoRepository;
import com.foro.ForoHub.repository.TopicoRepository;
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
@RestController
@RequestMapping("/topicos")
public class TopicoController {
    
    @Autowired
    private TopicoRepository topicoRepository;
    
    @Autowired
    private CursoRepository cursoRepository;
    
    @GetMapping("/listarTopicos")
    public Stream<Topico> listarTopicos(){
        return topicoRepository.findAll().stream().filter(topico -> topico.isActivo());
    }
    
    @PostMapping("/agregarTopico/{cursoNombre}")
    public ResponseEntity agregarTopico(@PathVariable String cursoNombre, @RequestBody RegistroTopicos registroTopicos){
        Curso existeCurso = cursoRepository.findByNombre(cursoNombre);
        Topico existeTopico = topicoRepository.findByTitulo(registroTopicos.titulo());
        
        if (existeCurso == null || !existeCurso.isActivo()) {
            return ResponseEntity.ok("Curso no encontrado o no existe");
        }
        
        if (existeTopico == null) {
            Topico topico = new Topico(registroTopicos);
            topico.setCurso(existeCurso);
            topicoRepository.save(topico);
            return ResponseEntity.ok(registroTopicos);
        } else {
            return ResponseEntity.ok("El topico ya existe");
        }
    }
    
    @PutMapping("/modificarTopico")
    @Transactional
    public ResponseEntity actualizarTopico(@RequestBody RegistroTopicos registroTopico){
        Topico topico = topicoRepository.findByTitulo(registroTopico.titulo());
        if (topico == null) {
            return ResponseEntity.ok("Registro no encontrado");
        }
        topico.actualizarTopico(registroTopico);
        return ResponseEntity.ok("Registro actualizado");
    }
    
    @DeleteMapping("/eliminarTopico/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id){
        Topico topico = topicoRepository.getReferenceById(id);
        if (topico == null) {
            return ResponseEntity.ok("Registro no encontrado");
        }
        topico.desactivarTopico();
        return ResponseEntity.ok("Registro eliminado");
    }
}
