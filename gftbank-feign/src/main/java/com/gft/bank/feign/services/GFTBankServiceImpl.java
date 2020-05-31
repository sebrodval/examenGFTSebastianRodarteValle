package com.gft.bank.feign.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.bank.feign.client.GFTBankClient;
import com.gft.bank.feign.model.Cliente;
import com.gft.bank.feign.model.Cuenta;
/**
 * 
 * @author Sebastian Rodarte Valle
 *
 */
@Service
public class GFTBankServiceImpl implements GFTBankService {

	@Autowired
	GFTBankClient gftBankClient;
	
	@Override
	public List<Cliente> listAllClients() {
		List<Cliente> lstClientes = gftBankClient.listClientes().getBody();
		return lstClientes;
	}

	@Override
	public Cliente createCliente(Cliente cliente) {
		return gftBankClient.createCliente(cliente).getBody();
	}

	@Override
	public Cliente getCliente(Long id) {
		Cliente cliente = gftBankClient.getCliente(id).getBody();
		return cliente;
	}

	@Override
	public Cliente updateCliente(Cliente cliente) {
		return gftBankClient.updateCliente(cliente.getId(), cliente).getBody();
	}

	@Override
	public void deleteCliente(Long id) {
		gftBankClient.deleteCliente(id);
	}

	@Override
	public List<Cuenta> listAllCuentas() {
		return gftBankClient.listCuentas().getBody();
	}

	@Override
	public Cuenta createCuenta(Cuenta cuenta) {
		return gftBankClient.createCuenta(cuenta).getBody();
	}

	@Override
	public Cuenta getCuenta(Long id) {
		return gftBankClient.getCuenta(id).getBody();
	}

	@Override
	public Cuenta updateCuenta(Cuenta cuenta) {
		return gftBankClient.updateCuenta(cuenta.getId(), cuenta).getBody();
	}

	@Override
	public void deleteCuenta(Long id) {
		gftBankClient.deleteCuenta(id);
	}

	@Override
	public List<Cuenta> getCuentasByClient(Long clienteId) {
		return gftBankClient.getCuentasByClient(clienteId).getBody();
	}

  
}
