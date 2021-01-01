package com.APIconta.APIconta.dadosDuplicados;

import com.APIconta.APIconta.entidade.Cliente;
import com.APIconta.APIconta.repositorio.RepositorioCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DadosDuplicados {

	@Autowired
	private RepositorioCliente repositorio;
	
	public boolean checkDuplicados(Cliente cliente) {

		List<Cliente> lista = repositorio.findAll();

		for (Cliente elementoLista : lista) {
			if (cliente.getCPF().equals(elementoLista.getCPF()) || cliente.getEmail().equals(elementoLista.getEmail())) {
				return false;
			}
		}
		
		return true;
	}
	
}
