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
import com.gft.bank.services.ClienteService;


/**
 * 
 * @author Sebastian Rodarte Valle
 *
 */
@RestController
@RequestMapping (value = "/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;
    
    @GetMapping
    public ResponseEntity<List<Cliente>> listClientes(){
        List<Cliente> clientes = new ArrayList<>();
        clientes = clienteService.listAllClients();
        if (clientes.isEmpty()){
            return ResponseEntity.noContent().build();
        } 
        return ResponseEntity.ok(clientes);
    }


    @PostMapping
    public ResponseEntity<Cliente> createCliente(@Valid @RequestBody Cliente cliente){
        Cliente clienteCreado =  clienteService.createCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteCreado);
    }
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<Cliente> getCliente(@PathVariable("id") Long id) {
        Cliente cliente =  clienteService.getCliente(id);
        if (null==cliente){
            return ResponseEntity.notFound().build();
        } 
        return ResponseEntity.ok(cliente);
    }

   @PutMapping(value = "/{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable("id") Long id, @RequestBody Cliente cliente){
        cliente.setId(id);
        Cliente clienteActualizado =  clienteService.updateCliente(cliente);
        if (clienteActualizado == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clienteActualizado);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Cliente> deleteCliente(@PathVariable("id") Long id){
    	 Cliente cliente =  clienteService.getCliente(id);
         if (null==cliente){
             return ResponseEntity.notFound().build();
         }
    	clienteService.deleteCliente(id);
        return ResponseEntity.ok(cliente);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
	 
	    ex.getBindingResult().getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
	     
	    return errors;
	}
}
