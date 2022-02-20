package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

@Component
public class RestauranteRepositoryJPA implements RestauranteRepository{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Restaurante> buscarTodos() {
		return entityManager.createQuery("from Restaurante", Restaurante.class).getResultList();
	}

	@Override
	public Restaurante buscarPorId(Long id) {
		return entityManager.find(Restaurante.class, id);
	}

	@Override
	@Transactional
	public Restaurante adicionar(Restaurante restaurante) {
		return entityManager.merge(restaurante);
	}

	@Override
	@Transactional
	public void remover(Restaurante restaurante) {
		Restaurante removido = buscarPorId(restaurante.getId());
		entityManager.remove(removido);
	}
}
