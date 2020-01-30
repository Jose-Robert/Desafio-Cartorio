package com.docket.cartorio.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CARTORIO")
public class Cartorio implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "NOME", nullable = false)
	private String nome;
	
	@Column(name = "CNPJ", nullable = false, length = 14, unique = true)
	private String cnpj;
	
	@Column(name = "RAZAO_SOCIAL", nullable = false, unique = true)
	private String razaoSocial;
	
	@Column(name = "ENDERECO", nullable = false)
	private String endereco;
	
	@Column(name = "TELEFONE", nullable = false , length = 11)
	private String telefone;
}
