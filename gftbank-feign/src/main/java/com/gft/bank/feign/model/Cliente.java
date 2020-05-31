
package com.gft.bank.feign.model;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Sebastian Rodarte Valle
 *
 */

@Data //Para evitar escribir getters y setters
@AllArgsConstructor @NoArgsConstructor @Builder
public class Cliente implements Serializable{
	
	private static final long serialVersionUID = -6999787170016893373L;

	private Long id;
	
	private String nombre;
	
	private String apellidos;
	
	private Date fechaNacimiento;
	
	private String sexo;
	
	
}
