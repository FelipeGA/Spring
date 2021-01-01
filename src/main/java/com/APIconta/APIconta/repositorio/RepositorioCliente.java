package com.APIconta.APIconta.repositorio;

import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import com.APIconta.APIconta.entidade.Cliente;

public interface RepositorioCliente extends JpaRepository<Cliente,Integer> {
}
