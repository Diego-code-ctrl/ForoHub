package com.foro.ForoHub.entity;

import com.foro.ForoHub.model.RegistroCurso;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 *
 * @author diegobecerril
 */
@Table(name = "cursos")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Curso {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String tipo;
    
    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Topico> topicos;
    
    private boolean activo;
    
    public Curso(RegistroCurso registroCurso){
        this.activo = true;
        this.nombre = registroCurso.nombre();
        this.tipo = registroCurso.tipo();
    }
    
    public void actualizarDatos(RegistroCurso registroCurso){
        if(registroCurso.nombre() != null)
            this.nombre = registroCurso.nombre();
        
        if(registroCurso.tipo() != null)
            this.tipo = registroCurso.tipo();
    }

    public void desactivarCurso() {
        this.activo = false;
    }
}
