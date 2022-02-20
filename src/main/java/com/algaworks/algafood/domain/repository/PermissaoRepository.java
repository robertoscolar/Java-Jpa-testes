package com.algaworks.algafood.domain.repository;

import java.util.List;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Permissao;

public interface PermissaoRepository {

	List<Permissao> buscarTodos();
	Cozinha buscarPorId(Long id);
	Cozinha adicionar (Permissao permissao);
	void remover (Permissao permissao);
	
}
