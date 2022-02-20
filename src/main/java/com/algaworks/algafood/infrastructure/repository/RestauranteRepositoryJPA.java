package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

@Component
public class RestauranteRepositoryJPA implements RestauranteRepository{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Restaurante> todos() {
		return entityManager.createQuery("from Restaurante", Restaurante.class).getResultList();
	}

	@Override
	public Restaurante buscar(Long id) {
		return entityManager.find(Restaurante.class, id);
	}

	@Override
	public Restaurante adicionar(Restaurante restaurante) {
		return entityManager.merge(restaurante);
	}

	@Override
	public void remover(Restaurante restaurante) {
		Restaurante removido = entityManager.find(Restaurante.class, restaurante);
		entityManager.remove(removido);
	}
}
