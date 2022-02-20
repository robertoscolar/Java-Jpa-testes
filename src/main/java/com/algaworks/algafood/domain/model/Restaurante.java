package com.algaworks.algafood.domain.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Restaurante {

	@EqualsAndHashCode.Include
	@Id
	private Long id;
	
	@Column(name="nome")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String nome;
	
	@Column(name="taxa_frete")
	private BigDecimal frete;

}