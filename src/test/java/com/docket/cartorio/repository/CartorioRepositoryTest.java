package com.docket.cartorio.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.docket.cartorio.model.Cartorio;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartorioRepositoryTest {

	@Autowired
	private CartorioRepository cartorioRepository;
	
	@Test
	@BeforeClass
	public void saveTest() {
		Cartorio cartorio = new Cartorio(null,"jose Robert", "65147331000102", "ROBERT CARTORIO SA", "Rua Airton Senna da Silva, 38","99615-4232");
		Cartorio cadastrarCartorio = cartorioRepository.save(cartorio);
		
		assertThat(cadastrarCartorio.getId().equals(22));
	}
	
	@Test
	public void updateTest() {
		Cartorio cartorio = new Cartorio(22,"jose Robert Gonçalves", "65147331000102", "ROBERT CARTORIO SA", "Rua Airton Senna da Silva, 38","996154232");
		Cartorio atualizarCartorio = cartorioRepository.save(cartorio);
		
		assertThat(atualizarCartorio.getNome().equals("jose Robert Gonçalves"));
	}
	
	@Test
	public void searchByIdTest() {
		Optional<Cartorio> result = cartorioRepository.findById(12);
		Cartorio cartorio = result.get();
		
		assertThat(cartorio.getCnpj().equals("27027742000167"));
	}
	
	@Test
	public void listTest() {
		List<Cartorio> cartorios = cartorioRepository.findAll();
		
		assertThat(cartorios.size());
	}
	
	@Test
	public void deleteTest() {
		Optional<Cartorio> cartorio = cartorioRepository.findById(22);
		this.cartorioRepository.delete(cartorio.get());
		
		assertTrue("Cartorio deletado com Sucesso!", true);
	}
}
