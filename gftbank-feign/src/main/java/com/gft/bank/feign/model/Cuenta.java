package com.gft.bank.feign.model;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data //Para evitar escribir getters y setters
@AllArgsConstructor @NoArgsConstructor @Builder
public class Cuenta implements Serializable {

	private static final long serialVersionUID = -182396621157714009L;

	private Long id;
	
	private String numeroCuenta;
	
	private Double saldo;
	
	private String tipoProducto;
    
    private Cliente clienteId;
}
