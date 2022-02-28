package com.clienteapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clienteapi.model.Cliente;
import com.clienteapi.service.ClienteService;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
	
	@Autowired
	ClienteService clienteService;
	
	@GetMapping
	public List<Cliente> obterTodosClientes() {
		return clienteService.getAll();
	}
	
	@GetMapping(value = "/{id}")
	public Cliente obterClientePorId(@PathVariable Long id) {
		return clienteService.getById(id);
	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> adicionarCliente(@RequestBody Cliente cliente) {
		return clienteService.saveNewClient(cliente);
	}
	
	@PutMapping
	public Cliente editarCliente(@RequestBody Cliente cliente) {
		return clienteService.editClient(cliente);
	}
	
	@DeleteMapping(value = "/{id}")
	public HttpStatus excluirCliente(@PathVariable Long id) {
		return clienteService.delete(id);
	}
}
