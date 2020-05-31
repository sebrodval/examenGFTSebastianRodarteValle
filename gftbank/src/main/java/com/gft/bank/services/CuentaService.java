package com.gft.bank.services;

import java.util.List;

import com.gft.bank.entity.Cliente;
import com.gft.bank.entity.Cuenta;

/**
 * 
 * @author Sebastian Rodarte Valle
 *
 */
public interface CuentaService {

	public List<Cuenta> listAllCuentas();

	public Cuenta createCuenta(Cuenta cuenta);
	public Cuenta getCuenta(Long id);
    public Cuenta updateCuenta(Cuenta cuenta);
    public void deleteCuenta(Long id);
    
    public List<Cuenta> findByCliente(Cliente clienteId);
    
}
