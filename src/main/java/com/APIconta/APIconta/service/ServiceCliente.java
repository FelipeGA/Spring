package com.APIconta.APIconta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.APIconta.APIconta.dadosDuplicados.DadosDuplicados;
import com.APIconta.APIconta.entidade.Cliente;
import com.APIconta.APIconta.repositorio.RepositorioCliente;
import com.APIconta.APIconta.validacaoDados.ValidacaoCliente;

@Service
public class ServiceCliente {

	@Autowired
	private RepositorioCliente repositorio;
	@Autowired
	private ValidacaoCliente validacao;
	@Autowired
	private DadosDuplicados duplicados;
	
	public String saveCliente(Cliente cliente) {
			
		if (!duplicados.checkDuplicados(cliente)) {
			return "Cliente não registrado. CPF ou Email já cadastrados no banco de dados.";
		}
		
		if (validacao.dataIsValid(cliente.getDataNascimento())) {
			if (validacao.cpfIsValid(cliente.getCPF())) {
				if (validacao.emailIsValid(cliente.getEmail())) {
					repositorio.save(cliente);
					return "Cliente registrado.";
				} else {
					return "Cliente não registrado. Email inválido!";
				}
			} else {
				return "Cliente não registrado. CPF inválido!";
			}
		} else {
			return "Cliente não registrado. Data de nascimento inválida!";
		}
	}
	
	public String deleteCliente(int id) {
		repositorio.deleteById(id);
		return "cliente removido " + id;
	}
	
	public Cliente atualizarcliente(Cliente cliente) {
		Cliente clienteExistente = repositorio.findById(cliente.getId()).orElse(null);
		
		clienteExistente.setNome(cliente.getNome());
		clienteExistente.setEmail(cliente.getEmail());
		clienteExistente.setCPF(cliente.getCPF());
		clienteExistente.setDataNascimento(cliente.getDataNascimento());
		
		return repositorio.save(clienteExistente);
	}
}
