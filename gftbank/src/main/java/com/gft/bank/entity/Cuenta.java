package com.gft.bank.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Sebastian Rodarte Valle
 *
 */
@Entity
@Table(name = "tb_cuentas")
@Data //Para evitar escribir getters y setters
@NoArgsConstructor @AllArgsConstructor @Builder
public class Cuenta implements Serializable {

	private static final long serialVersionUID = 3491934415425477240L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "el numero de cuenta no puede ser nulo")
	@Column(name = "numero_cuenta")
	private String numeroCuenta;
	
	private Double saldo;
	
	@Column(name = "tipo_producto")
	private String tipoProducto;
    
	@NotNull(message = "el id del cliente no puede ser nulo")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Cliente clienteId;
}
