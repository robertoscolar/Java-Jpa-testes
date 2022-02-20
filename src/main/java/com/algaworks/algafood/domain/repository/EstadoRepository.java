package com.algaworks.algafood.domain.repository;

import java.util.List;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Estado;

public interface EstadoRepository {

	List<Estado> buscarTodos();
	Cozinha buscarPorId(Long id);
	Cozinha adicionar (Estado estado);
	void remover (Estado estado);
}
