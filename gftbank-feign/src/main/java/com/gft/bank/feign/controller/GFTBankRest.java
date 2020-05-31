package com.gft.bank.feign.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
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

import com.gft.bank.feign.model.Cliente;
import com.gft.bank.feign.model.Cuenta;
import com.gft.bank.feign.services.GFTBankService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * 
 * @author Sebastian Rodarte Valle
 *
 */
@RestController
@RequestMapping("/gftbank")
public class GFTBankRest {

    @Autowired
    GFTBankService gftBankService;

    
    
    
    
    @GetMapping(value = "/all-customers")
    @ApiOperation(value = "Servicio all-customers", notes = "Devuelve todos los clientes de GFT Bank")
	@ApiResponses({ @ApiResponse(code = HttpServletResponse.SC_OK, message = "OK"),
	@ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "Error interno del servidor"),
	@ApiResponse(code = HttpServletResponse.SC_UNAUTHORIZED, message = "No autorizado"),
	@ApiResponse(code = HttpServletResponse.SC_FORBIDDEN, message = "Acceso denegado"),
	@ApiResponse(code = HttpServletResponse.SC_NOT_FOUND, message = "No se encontraron clientes") })
    public ResponseEntity<List<Cliente>> listClientes(){
        List<Cliente> clientes = new ArrayList<>();
        clientes = gftBankService.listAllClients();
        if (null==clientes || (null!=clientes && clientes.isEmpty())){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(clientes);
    }


    @PostMapping(value = "/create-customer")
    @ApiOperation(value = "Servicio create-customer", notes = "Da de alta un nuevo cliente en GFT Bank")
   	@ApiResponses({ @ApiResponse(code = HttpServletResponse.SC_OK, message = "OK"),
   	@ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "Error interno del servidor"),
   	@ApiResponse(code = HttpServletResponse.SC_UNAUTHORIZED, message = "No autorizado"),
   	@ApiResponse(code = HttpServletResponse.SC_FORBIDDEN, message = "Acceso denegado")})
    public ResponseEntity<Cliente> createCliente(@Valid @RequestBody Cliente cliente){
        Cliente clienteCreado =  gftBankService.createCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteCreado);
    }
    
    @GetMapping(value = "/read-customer/{id}")
    @ApiOperation(value = "Servicio read-customer", notes = "Devuelve el cliente de GFT Bank por medio de su id")
	@ApiResponses({ @ApiResponse(code = HttpServletResponse.SC_OK, message = "OK"),
	@ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "Error interno del servidor"),
	@ApiResponse(code = HttpServletResponse.SC_UNAUTHORIZED, message = "No autorizado"),
	@ApiResponse(code = HttpServletResponse.SC_FORBIDDEN, message = "Acceso denegado"),
	@ApiResponse(code = HttpServletResponse.SC_NOT_FOUND, message = "No se obtuvo el cliente") })
    public ResponseEntity<Cliente> getCliente(@PathVariable("id") Long id) {
        Cliente cliente =  gftBankService.getCliente(id);
        if (null==cliente){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cliente);
    }

   @PutMapping(value = "/update-customer/{id}")
   @ApiOperation(value = "Servicio update-customer", notes = "Actualiza al cliente de GFT Bank por medio de su id")
	@ApiResponses({ @ApiResponse(code = HttpServletResponse.SC_OK, message = "OK"),
	@ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "Error interno del servidor"),
	@ApiResponse(code = HttpServletResponse.SC_UNAUTHORIZED, message = "No autorizado"),
	@ApiResponse(code = HttpServletResponse.SC_FORBIDDEN, message = "Acceso denegado") })
    public ResponseEntity<Cliente> updateCliente(@PathVariable("id") Long id, @RequestBody Cliente cliente){
        cliente.setId(id);
        Cliente clienteActualizado =  gftBankService.updateCliente(cliente);
        if (clienteActualizado == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clienteActualizado);
    }

    @DeleteMapping(value = "/delete-customer/{id}")
    @ApiOperation(value = "Servicio delete-customer", notes = "Borra al cliente de GFT Bank por medio de su id")
	@ApiResponses({ @ApiResponse(code = HttpServletResponse.SC_OK, message = "OK"),
	@ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "Error interno del servidor"),
	@ApiResponse(code = HttpServletResponse.SC_UNAUTHORIZED, message = "No autorizado"),
	@ApiResponse(code = HttpServletResponse.SC_FORBIDDEN, message = "Acceso denegado") })
    public ResponseEntity<Cliente> deleteCliente(@PathVariable("id") Long id){
    	 Cliente cliente =  gftBankService.getCliente(id);
         if (null==cliente){
             return ResponseEntity.notFound().build();
         }
    	gftBankService.deleteCliente(id);
        return ResponseEntity.ok(cliente);
    }

    @GetMapping(value = "/all-accounts")
    @ApiOperation(value = "Servicio all-accounts", notes = "Devuelve todas las cuentas bancarias de GFT Bank")
	@ApiResponses({ @ApiResponse(code = HttpServletResponse.SC_OK, message = "OK"),
	@ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "Error interno del servidor"),
	@ApiResponse(code = HttpServletResponse.SC_UNAUTHORIZED, message = "No autorizado"),
	@ApiResponse(code = HttpServletResponse.SC_FORBIDDEN, message = "Acceso denegado"),
	@ApiResponse(code = HttpServletResponse.SC_NOT_FOUND, message = "No se encontraron cuentas") })
    public ResponseEntity<List<Cuenta>> listCuentas(){
        List<Cuenta> cuentas = new ArrayList<>();
        cuentas = gftBankService.listAllCuentas();
        if (null==cuentas || (null!=cuentas && cuentas.isEmpty())){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(cuentas);
    }


    @PostMapping(value = "/create-account")
    @ApiOperation(value = "Servicio create-account", notes = "Da de alta una nueva cuenta bancaria de GFT Bank para un cliente en especifico")
   	@ApiResponses({ @ApiResponse(code = HttpServletResponse.SC_OK, message = "OK"),
   	@ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "Error interno del servidor"),
   	@ApiResponse(code = HttpServletResponse.SC_UNAUTHORIZED, message = "No autorizado"),
   	@ApiResponse(code = HttpServletResponse.SC_FORBIDDEN, message = "Acceso denegado") })
    public ResponseEntity<Cuenta> createCuenta(@Valid @RequestBody Cuenta cuenta){
        Cuenta cuentaCreada =  gftBankService.createCuenta(cuenta);
        return ResponseEntity.status(HttpStatus.CREATED).body(cuentaCreada);
    }
    
    @GetMapping(value = "/read-account/{id}")
    @ApiOperation(value = "Servicio read-account", notes = "Devuelve una cuenta bancaria de GFT Bank por medio de su id")
   	@ApiResponses({ @ApiResponse(code = HttpServletResponse.SC_OK, message = "OK"),
   	@ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "Error interno del servidor"),
   	@ApiResponse(code = HttpServletResponse.SC_UNAUTHORIZED, message = "No autorizado"),
   	@ApiResponse(code = HttpServletResponse.SC_FORBIDDEN, message = "Acceso denegado"),
   	@ApiResponse(code = HttpServletResponse.SC_NOT_FOUND, message = "No se obtuvo la cuenta") })
    public ResponseEntity<Cuenta> getCuenta(@PathVariable("id") Long id) {
        Cuenta cuenta =  gftBankService.getCuenta(id);
        if (null==cuenta){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cuenta);
    }

   @PutMapping(value = "/update-account/{id}")
   @ApiOperation(value = "Servicio update-account", notes = "Actualiza la cuenta bancaria de GFT Bank por medio de su id")
  	@ApiResponses({ @ApiResponse(code = HttpServletResponse.SC_OK, message = "OK"),
  	@ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "Error interno del servidor"),
  	@ApiResponse(code = HttpServletResponse.SC_UNAUTHORIZED, message = "No autorizado"),
  	@ApiResponse(code = HttpServletResponse.SC_FORBIDDEN, message = "Acceso denegado")})
    public ResponseEntity<Cuenta> updateCuenta(@PathVariable("id") Long id, @RequestBody Cuenta cuenta){
        cuenta.setId(id);
        Cuenta cuentaActualizado =  gftBankService.updateCuenta(cuenta);
        if (cuentaActualizado == null){
            return ResponseEntity.notFound().build();
        } else {
        	gftBankService.updateCliente(cuentaActualizado.getClienteId());
        }
        
        
        return ResponseEntity.ok(cuentaActualizado);
    }

    @DeleteMapping(value = "/delete-account/{id}")
    @ApiOperation(value = "Servicio delete-account", notes = "Borra la cuenta bancaria de GFT Bank por medio de su id")
   	@ApiResponses({ @ApiResponse(code = HttpServletResponse.SC_OK, message = "OK"),
   	@ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "Error interno del servidor"),
   	@ApiResponse(code = HttpServletResponse.SC_UNAUTHORIZED, message = "No autorizado"),
   	@ApiResponse(code = HttpServletResponse.SC_FORBIDDEN, message = "Acceso denegado") })
    public ResponseEntity<Cuenta> deleteCuenta(@PathVariable("id") Long id){
    	 Cuenta cuenta =  gftBankService.getCuenta(id);
         if (null==cuenta){
             return ResponseEntity.notFound().build();
         }
    	gftBankService.deleteCuenta(id);
        return ResponseEntity.ok(cuenta);
    }
    
    @GetMapping(value = "/read-accounts-customer/{id}")
    @ApiOperation(value = "Servicio read-accounts-customer", notes = "Devuelve todas las cuentas bancarias de GFT Bank correspondientes a un cliente por medio de su id")
   	@ApiResponses({ @ApiResponse(code = HttpServletResponse.SC_OK, message = "OK"),
   	@ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "Error interno del servidor"),
   	@ApiResponse(code = HttpServletResponse.SC_UNAUTHORIZED, message = "No autorizado"),
   	@ApiResponse(code = HttpServletResponse.SC_FORBIDDEN, message = "Acceso denegado"),
   	@ApiResponse(code = HttpServletResponse.SC_NOT_FOUND, message = "No se encontraron cuentas del cliente indicado") })
    public ResponseEntity<List<Cuenta>> getCuentasByClient(@PathVariable("id") Long id) {
    	Cliente cliente = gftBankService.getCliente(id);
        List<Cuenta> cuentasCliente =  gftBankService.getCuentasByClient(id);
        if (null==cuentasCliente || cuentasCliente.size()==0){
            return ResponseEntity.notFound().build();
        } else
        {
        	for(Cuenta cuenta:cuentasCliente)
        	{
        		cuenta.setClienteId(cliente);
        	}
        	return ResponseEntity.ok(cuentasCliente);	
        }
        
    }
    
   	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
	 
	    ex.getBindingResult().getFieldErrors().forEach(error -> 
	        errors.put(error.getField(), error.getDefaultMessage()));
	     
	    return errors;
	}
}
