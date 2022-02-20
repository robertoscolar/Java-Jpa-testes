package com.algaworks.algafood.domain.repository;

import java.util.List;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.FormaPagamento;

public interface FormaPagamentoRepository {

	List<FormaPagamento> buscarTodos();
	Cozinha buscarPorId(Long id);
	Cozinha adicionar (FormaPagamento formaPagamento);
	void remover (FormaPagamento formaPagamento);
}
