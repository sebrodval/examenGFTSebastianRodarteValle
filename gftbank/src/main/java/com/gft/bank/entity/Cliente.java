
package com.gft.bank.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table (name="tb_clientes")
@Data //Para evitar escribir getters y setters
@AllArgsConstructor @NoArgsConstructor @Builder
public class Cliente implements Serializable {
	
	private static final long serialVersionUID = 528527729180453199L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "El nombre no debe ser vacio")
	private String nombre;
	
	@NotEmpty(message = "Los apellidos no deben ser vacios")
	private String apellidos;
	
	@Column(name="fecha_nacimiento")
	private Date fechaNacimiento;
	
	private String sexo;
	
	
	
}
