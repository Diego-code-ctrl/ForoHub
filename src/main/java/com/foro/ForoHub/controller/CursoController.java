package com.foro.ForoHub.controller;

import com.foro.ForoHub.model.RegistroCurso;
import org.springframework.web.bind.annotation.PostMapping;
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
    
    @PostMapping
    public void registrarCurso(@RequestBody RegistroCurso curso){
        System.out.println(curso);
    }
}
