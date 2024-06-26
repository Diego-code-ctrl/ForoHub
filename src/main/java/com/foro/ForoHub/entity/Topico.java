package com.foro.ForoHub.entity;

import com.foro.ForoHub.model.RegistroTopicos;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author diegobecerril
 */
@Table(name = "topicos")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    
    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;
    
    private boolean activo;
    
    public Topico(RegistroTopicos registroTopico){
        this.activo = true; 
        this.mensaje = registroTopico.mensaje();
        this.titulo = registroTopico.titulo();
        this.fechaCreacion = registroTopico.fechaCreacion();
    }
    
    public void actualizarTopico(RegistroTopicos registroTopico){
        if (registroTopico.titulo() != null)
            this.titulo = registroTopico.titulo();
        
        if (registroTopico.mensaje() != null)
            this.mensaje = registroTopico.mensaje();
    }
    
    public void desactivarTopico() {
        this.activo = false;
    }
}
