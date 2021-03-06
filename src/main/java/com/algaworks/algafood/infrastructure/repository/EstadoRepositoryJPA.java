package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.EstadoRepository;

@Component
public class EstadoRepositoryJPA implements EstadoRepository{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Estado> buscarTodos() {
		return manager.createQuery("from Estado", Estado.class).getResultList();
	}

	@Override
	public Estado buscarPorId(Long id) {
		return manager.find(Estado.class, id);
	}

	@Transactional
	@Override
	public Estado adicionar(Estado estado) {
		return manager.merge(estado);
	}

	@Transactional
	@Override
	public void remover(Estado estado) {
		Estado exclusao = buscarPorId(estado.getId());
		manager.remove(exclusao);
	}


}
