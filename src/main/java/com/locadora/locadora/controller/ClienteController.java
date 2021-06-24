package com.locadora.locadora.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@PostMapping
	public String form() {

		return " POST - > cliente/formCliente";
	}

	@GetMapping
	public String from2() {
		return "GET - > cliente/formCliente";

	}


	@GetMapping("/dual")
	public String from22() {
		return "GET / DUAL - > cliente/formCliente";

	}

	@GetMapping("/dual/{id}")
	public String from22(@PathVariable("id") String id ) {
		return "GET / DUAL - > cliente/formCliente" + id;

	}

}
