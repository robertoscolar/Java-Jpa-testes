package com.algaworks.algafood.jpa.teste;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgaworksApiApplication;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

public class ConsultaRestauranteMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgaworksApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		RestauranteRepository restauranteRepository = applicationContext.getBean(RestauranteRepository.class);
		
		List <Restaurante> restaurantes = restauranteRepository.buscarTodos();
		
		for (Restaurante restaurante : restaurantes) {
			System.out.printf("%s  -   %f    -     %s\n", restaurante.getNome(), restaurante.getFrete(), restaurante.getCozinha().getNome());
		}
	}	
}
