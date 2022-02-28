package com.clienteapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.clienteapi.model.Cliente;
import com.clienteapi.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<Cliente> getAll() {
		return clienteRepository.findAll();
	}
	
	public ResponseEntity<?> saveNewClient(Cliente cliente) {
		Cliente clienteGet = clienteRepository.findByCpf(cliente.getCpf());
		if (clienteGet != null) {
			if (clienteGet.getId() != cliente.getId()) {
				return new ResponseEntity<>("{message:Já existe cliente cadastrado com este CPF}", HttpStatus.OK);
			}
		}
		return new ResponseEntity<>(this.saveClient(cliente), HttpStatus.CREATED);
	}
	
	public Cliente saveClient(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public Cliente editClient(Cliente cliente) {
		if (cliente.getId() == null) {
			return null;
		}
		
		if (this.getById(cliente.getId()) == null) {
			return null;
		}
		return this.saveClient(cliente);
	}
	
	public HttpStatus delete(Long id) {
		Cliente clienteGet = this.getById(id);
		if (clienteGet == null) {
			return HttpStatus.NOT_FOUND;
		}
		clienteRepository.delete(clienteGet);
		return HttpStatus.OK;
	}
	
	public Cliente getById(Long id) {
		if (clienteRepository.existsById(id)) {
			return clienteRepository.findById(id).get();
		}
		return null;
	}

}
