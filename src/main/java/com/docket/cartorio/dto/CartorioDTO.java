package com.docket.cartorio.dto;

import com.docket.cartorio.model.Cartorio;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CartorioDTO {
	
	private Integer id;
	private String nome;
	
	public CartorioDTO(Cartorio cartorio) {
		id = cartorio.getId();
		nome = cartorio.getNome();
	}
}
