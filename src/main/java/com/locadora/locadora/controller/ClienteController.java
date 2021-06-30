package com.locadora.locadora.controller;
import com.locadora.locadora.repository.ClienteRepository;
import java.util.List;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.locadora.locadora.models.Cliente;

@CrossOrigin(value = "*")
@RestController
@RequestMapping("/cliente")

public class ClienteController {

	@Autowired
	public ClienteRepository clienteRepository;


	@GetMapping
	public ResponseEntity<List <Cliente>> listaClientes() {

		ResponseEntity response = ResponseEntity.badRequest().build();
		List<Cliente> clienteList = clienteRepository.findAll();

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
	public Cliente lCliente (@PathVariable(value = "id") long id) {
		return clienteRepository.findById(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente sCliente(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@PutMapping("/{id}")
	public Cliente aCliente(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void dCliente(@PathVariable(value = "id") long id) {
		clienteRepository.deleteById(id);

	}
}
