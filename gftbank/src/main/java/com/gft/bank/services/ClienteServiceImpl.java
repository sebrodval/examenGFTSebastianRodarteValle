package com.gft.bank.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.bank.entity.Cliente;
import com.gft.bank.entity.Cuenta;
import com.gft.bank.repository.ClienteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl  implements ClienteService{

//	@Autowired
//	private CuentaService cuentaService;

    private final ClienteRepository clienteRepository;

    @Override
    public List<Cliente> listAllClients() {
    	List<Cliente> lstClientes = clienteRepository.findAll();
//    	for(Cliente cliente:lstClientes)
//    	{
//    		List<Cuenta> lstCuentas = cuentaService.findByCliente(cliente);
//    		cliente.setCuentas(lstCuentas);
//    	}
    	return lstClientes;
    }

    @Override
    public Cliente createCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
    
    @Override
    public Cliente getCliente(Long id) {
        Cliente cliente = clienteRepository.findById(id).orElse(null);
//        List<Cuenta> lstCuentas = cuentaService.findByCliente(cliente);
//		cliente.setCuentas(lstCuentas);
        return cliente;
    }

    @Override
    public Cliente updateCliente(Cliente cliente) {
        Cliente clienteDB = getCliente(cliente.getId());
        if (null == clienteDB){
            return null;
        }
        clienteDB.setApellidos(cliente.getApellidos());
        clienteDB.setFechaNacimiento(cliente.getFechaNacimiento());
        clienteDB.setNombre(cliente.getNombre());
        clienteDB.setSexo(cliente.getSexo());
        return clienteRepository.save(clienteDB);
    }

    @Override
    public void deleteCliente(Long id) {
    	Cliente clienteDB = getCliente(id);
        if (null != clienteDB){
        	clienteRepository.delete(clienteDB);
        }
        
    }


}
