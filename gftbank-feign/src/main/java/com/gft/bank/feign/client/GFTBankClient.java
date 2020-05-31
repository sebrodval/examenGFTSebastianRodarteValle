package com.gft.bank.feign.client;

import java.util.List;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.gft.bank.feign.model.Cliente;
import com.gft.bank.feign.model.Cuenta;

@FeignClient(name = "gftbank")
public interface GFTBankClient {

	@GetMapping(value = "/clientes")
	public ResponseEntity<List<Cliente>> listClientes();
    
    @PostMapping(value = "/clientes")
    public ResponseEntity<Cliente> createCliente(@Valid @RequestBody Cliente cliente);
    
	
    @GetMapping(value = "/clientes/{id}")
    public ResponseEntity<Cliente> getCliente(@PathVariable("id") Long id);
    
    
    @PutMapping(value = "/clientes/{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable("id") Long id, @RequestBody Cliente cliente);
    
    
    @DeleteMapping(value = "/clientes/{id}")
    public ResponseEntity<Cliente> deleteCliente(@PathVariable("id") Long id);
    
    
    @GetMapping(value = "/cuentas")
    public ResponseEntity<List<Cuenta>> listCuentas();
    
    
    @PostMapping(value = "/cuentas")
    public ResponseEntity<Cuenta> createCuenta(@Valid @RequestBody Cuenta cuenta);
    
    
    @GetMapping(value = "/cuentas/{id}")
    public ResponseEntity<Cuenta> getCuenta(@PathVariable("id") Long id);

    @PutMapping(value = "/cuentas/{id}")
    public ResponseEntity<Cuenta> updateCuenta(@PathVariable("id") Long id, @RequestBody Cuenta cuenta);
    
    @DeleteMapping(value = "/cuentas/{id}")
    public ResponseEntity<Cuenta> deleteCuenta(@PathVariable("id") Long id);
    
	
    @GetMapping(value = "/cuentas/cliente/{id}")
    public ResponseEntity<List<Cuenta>> getCuentasByClient(@PathVariable("id") Long id);
    
}

