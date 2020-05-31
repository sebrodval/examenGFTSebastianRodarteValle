package com.gft.bank.feign.services;


import java.util.List;


import com.gft.bank.feign.model.Cliente;
import com.gft.bank.feign.model.Cuenta;


public interface GFTBankService {

	
	public List<Cliente> listAllClients();
	public Cliente createCliente(Cliente cliente);
	public Cliente getCliente(Long id);
    public Cliente updateCliente(Cliente cliente);
    public void deleteCliente(Long id);
	
    public List<Cuenta> listAllCuentas();
	public Cuenta createCuenta(Cuenta cuenta);
	public Cuenta getCuenta(Long id);
    public Cuenta updateCuenta(Cuenta cuenta);
    public void deleteCuenta(Long id);  
    public List<Cuenta> getCuentasByClient(Long clienteId);
}
