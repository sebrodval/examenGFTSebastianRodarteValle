package com.gft.bank.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gft.bank.entity.Cliente;
import com.gft.bank.entity.Cuenta;

@Repository
public interface CuentaRepository  extends JpaRepository<Cuenta, Long> {

    public List<Cuenta> findByClienteId(Cliente clienteId);
}
