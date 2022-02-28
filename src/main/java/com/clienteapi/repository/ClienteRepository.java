package com.clienteapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.clienteapi.model.Cliente;

@Repository //responsavel em interagir com banco de dados
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	@Query("select c from Cliente c where c.cpf = ?1")
	Cliente findByCpf(String cpf);

}
