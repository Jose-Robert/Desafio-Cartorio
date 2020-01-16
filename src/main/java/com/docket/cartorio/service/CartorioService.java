package com.docket.cartorio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docket.cartorio.exception.IdentificadorNuloOuInexistenteException;
import com.docket.cartorio.exception.ObjectNotFoundException;
import com.docket.cartorio.model.Cartorio;
import com.docket.cartorio.repository.CartorioRepository;

@Service
public class CartorioService {

	@Autowired
	public CartorioRepository cartorioRepository;

	public Cartorio save(Cartorio cartorio) {
		Cartorio createdCartorio = cartorioRepository.save(cartorio);
		return createdCartorio;
	}

	public Cartorio update(Cartorio obj) {
		Cartorio updateCartorio = cartorioRepository.save(obj);
		return updateCartorio;
	}

	public void delete(Integer id) {
		try {
			Optional<Cartorio> cartorio = cartorioRepository.findById(id);
			this.cartorioRepository.delete(cartorio.get());

		} catch (Exception e) {
			throw new IdentificadorNuloOuInexistenteException(
					"Não foi possivel remover cartorio para o identificador = " + id);
		}
	}

	public List<Cartorio> listAll() {
		List<Cartorio> cartorios = cartorioRepository.findAll();
		return cartorios;
	}

	public Cartorio searchById(Integer id) throws ObjectNotFoundException {
		Optional<Cartorio> obj = cartorioRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("identificador não encontrado = " + id));
	}
}
