package com.gft.bank.services;

import java.util.List;

import com.gft.bank.entity.Cliente;

/**
 * 
 * @author Sebastian Rodarte Valle
 *
 */
public interface ClienteService {

	public List<Cliente> listAllClients();

	public Cliente createCliente(Cliente cliente);
	public Cliente getCliente(Long id);
    public Cliente updateCliente(Cliente cliente);
    public void deleteCliente(Long id);
    

    
}
