package com.algaworks.algafood.api.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.api.model.CozinhasXmlWrapper;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;

//@Controller
//@ResponseBody
@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {
	
	@Autowired
	private CozinhaRepository cozinhaRepository;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Cozinha> listar() {
		return cozinhaRepository.buscarTodos(); 
	}		
	
	@GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
	public CozinhasXmlWrapper listarXml() {
		return new CozinhasXmlWrapper(cozinhaRepository.buscarTodos());
	}
	
//	public Cozinha buscar(@PathVariable("cozinhaId") Long id) {
//		return cozinhaRepository.buscarPorId(id);
//	}
	
//	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = "/{cozinhaId}")  //PathVariable
	public ResponseEntity<Cozinha> buscar(@PathVariable Long cozinhaId) {
		Cozinha cozinha = cozinhaRepository.buscarPorId(cozinhaId);
		
//		return ResponseEntity.status(HttpStatus.OK).body(cozinha);
//		return ResponseEntity.ok(cozinha); //shortcut para código acima
		if (cozinha != null ) {
			return ResponseEntity.ok(cozinha);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cozinha adicionar(@RequestBody Cozinha cozinha) {
		return cozinhaRepository.adicionar(cozinha);
	}
	
	@PutMapping("/{cozinhaId}")
	public ResponseEntity<Cozinha> atualizar(@PathVariable Long cozinhaId,
			@RequestBody Cozinha cozinha) {
		Cozinha cozinhaAtual = cozinhaRepository.buscarPorId(cozinhaId);
		
		if (cozinhaAtual != null) {
//		cozinhaAtual.setNome(cozinha.getNome());
		BeanUtils.copyProperties(cozinha, cozinhaAtual, "id"); //faz a mesma coisa que o de cima
		
		cozinhaAtual = cozinhaRepository.adicionar(cozinhaAtual);
		
		return ResponseEntity.ok(cozinhaAtual);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{cozinhaId}")
	public ResponseEntity<Cozinha> remover (@PathVariable Long cozinhaId) {		
		try {
			Cozinha cozinha = cozinhaRepository.buscarPorId(cozinhaId); 
		
			if (cozinha != null) {
				cozinhaRepository.remover(cozinha);
				
	//			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
				return ResponseEntity.noContent().build();
			}	
			
				return ResponseEntity.notFound().build();
		}catch (DataIntegrityViolationException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
}