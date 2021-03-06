package com.algaworks.algafood.domain.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Restaurante {

	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	
	@Column(name="nome", nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String nome;
	
	@Column(name="taxa_frete", nullable = false)
	private BigDecimal frete;
	
	@ManyToOne
	@JoinColumn(name="cozinha_id", nullable = false )
	private Cozinha cozinha;

}
