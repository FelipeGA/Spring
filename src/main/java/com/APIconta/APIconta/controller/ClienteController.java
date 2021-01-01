package com.APIconta.APIconta.controller;

import com.APIconta.APIconta.entidade.Cliente;
import com.APIconta.APIconta.service.ServiceCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClienteController {
	
	@Autowired
	private ServiceCliente service;
	
	@PostMapping("/addCliente")
	public String addCliente(@RequestBody Cliente cliente) {
		return service.saveCliente(cliente);
	}
	
	@DeleteMapping("/delCliente/{id}")
	public String delCliente(@PathVariable int id) {
		return service.deleteCliente(id);
	}
	
	@PutMapping("/updCliente")
	public Cliente updCliente(@RequestBody Cliente cliente) {
		return service.atualizarcliente(cliente);
	}
}
