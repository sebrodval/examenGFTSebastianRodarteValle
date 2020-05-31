package com.gft.bank.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gft.bank.entity.Cliente;
import com.gft.bank.entity.Cuenta;
import com.gft.bank.services.ClienteService;
import com.gft.bank.services.CuentaService;

@RestController
@RequestMapping (value = "/cuentas")
public class CuentaController {

    @Autowired
    private CuentaService cuentaService;
    
    @Autowired
    private ClienteService clienteService ;

    @GetMapping
    public ResponseEntity<List<Cuenta>> listCuentas(){
        List<Cuenta> cuentas = new ArrayList<>();
        cuentas = cuentaService.listAllCuentas();
        if (cuentas.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(cuentas);
    }


    @PostMapping
    public ResponseEntity<Cuenta> createCuenta(@Valid @RequestBody Cuenta cuenta){
        Cuenta cuentaCreada =  cuentaService.createCuenta(cuenta);
        return ResponseEntity.status(HttpStatus.CREATED).body(cuentaCreada);
    }
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<Cuenta> getCuenta(@PathVariable("id") Long id) {
        Cuenta cuenta =  cuentaService.getCuenta(id);
        if (null==cuenta){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cuenta);
    }

   @PutMapping(value = "/{id}")
    public ResponseEntity<Cuenta> updateCuenta(@PathVariable("id") Long id, @RequestBody Cuenta cuenta){
        cuenta.setId(id);
        Cuenta cuentaActualizado =  cuentaService.updateCuenta(cuenta);
        if (cuentaActualizado == null){
            return ResponseEntity.notFound().build();
        } 
//        else {
//        	clienteService.updateCliente(cuentaActualizado.getClienteId());
//        }
        
        
        return ResponseEntity.ok(cuentaActualizado);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Cuenta> deleteCuenta(@PathVariable("id") Long id){
    	 Cuenta cuenta =  cuentaService.getCuenta(id);
         if (null==cuenta){
             return ResponseEntity.notFound().build();
         }
    	cuentaService.deleteCuenta(id);
        return ResponseEntity.ok(cuenta);
    }
    
    @GetMapping(value = "/cliente/{id}")
    public ResponseEntity<List<Cuenta>> getCuentasByClient(@PathVariable("id") Long id) {
    	Cliente cliente = clienteService.getCliente(id);
        List<Cuenta> cuentasCliente =  cuentaService.findByCliente(cliente);
        if (null==cuentasCliente || cuentasCliente.size()==0){
            return ResponseEntity.notFound().build();
        } else
        {
        	return ResponseEntity.ok(cuentasCliente);	
        }
        
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
	 
	    ex.getBindingResult().getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
	     
	    return errors;
	}
}
