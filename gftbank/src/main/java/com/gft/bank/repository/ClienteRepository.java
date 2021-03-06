package com.gft.bank.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gft.bank.entity.Cliente;

/**
 * 
 * @author Sebastian Rodarte Valle
 *
 */
@Repository
public interface ClienteRepository  extends JpaRepository<Cliente, Long> {


}
