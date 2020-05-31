package com.gft.bank.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gft.bank.entity.Cliente;
import com.gft.bank.entity.Cuenta;
import com.gft.bank.repository.CuentaRepository;

import lombok.RequiredArgsConstructor;

/**
 * 
 * @author Sebastian Rodarte Valle
 *
 */
@Service
@RequiredArgsConstructor
public class CuentaServiceImpl  implements CuentaService{


    private final CuentaRepository cuentaRepository;

    @Override
    public List<Cuenta> listAllCuentas() {
        return cuentaRepository.findAll();
    }

    @Override
    public Cuenta createCuenta(Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }
    
    @Override
    public Cuenta getCuenta(Long id) {
        return cuentaRepository.findById(id).orElse(null);
    }


    @Override
    public Cuenta updateCuenta(Cuenta cuenta) {
    	Cuenta cuentaDB = getCuenta(cuenta.getId());
        if (null == cuentaDB){
            return null;
        }
        cuentaDB.setNumeroCuenta(cuenta.getNumeroCuenta());
        cuentaDB.setSaldo(cuenta.getSaldo());
        cuentaDB.setTipoProducto(cuenta.getTipoProducto());
        cuentaDB.setClienteId(cuenta.getClienteId());
        cuentaDB = cuentaRepository.save(cuentaDB);
        return cuentaDB;
    }

    @Override
    public void deleteCuenta(Long id) {
    	Cuenta cuentaDB = getCuenta(id);
        if (null != cuentaDB){
        	cuentaRepository.delete(cuentaDB);
        }
        
    }

    @Override
    public List<Cuenta> findByCliente(Cliente clienteId) {
        return cuentaRepository.findByClienteId(clienteId);
    }

    
}
