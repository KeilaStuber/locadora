package com.locadora.locadora.controller;
import java.util.List;
import java.util.Optional;

import com.locadora.locadora.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.locadora.locadora.models.Cliente;

@CrossOrigin(value = "*")
@RestController
@RequestMapping("/cliente")

public class ClienteController {

	@Autowired
	public ClienteService clienteService;

	@GetMapping
	public ResponseEntity<List <Cliente>> listarClientes() {
		ResponseEntity response = ResponseEntity.badRequest().build();
		List<Cliente> clienteList = clienteService.findAll();
		if (clienteList != null) {
			if (clienteList.size() > 0) {
				response = ResponseEntity.ok(clienteList);
			} else {
				response = ResponseEntity.noContent().build();
			}
		}
		return response;
	}

	@GetMapping("/{id}")
	public Optional<Cliente> listarClienteId (@PathVariable(value = "id") long id) {return clienteService.getCliente(id);}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente cadastrarCliente(@RequestBody Cliente cliente) {
		return clienteService.save(cliente);
	}

	@PutMapping("/{id}")
	public Cliente atualizarCliente(@RequestBody Cliente cliente) {
		return clienteService.save(cliente);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletarCliente(@PathVariable(value = "id") long id) {
		clienteService.deleteById(id);

	}
}
