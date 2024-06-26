package com.foro.ForoHub.model;

import java.util.Date;

/**
 *
 * @author diegobecerril
 */
public record RegistroTopicos(Long id, String titulo, String mensaje, Date fechaCreacion) {

}
