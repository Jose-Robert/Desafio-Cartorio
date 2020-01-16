package com.docket.cartorio.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.docket.cartorio.model.Cartorio;
import com.docket.cartorio.service.CartorioService;

@RestController
@RequestMapping(value = "cartorios")
public class CartorioResource {
	
	@Autowired
	private CartorioService cartorioService;
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Cartorio> searchById(@PathVariable("id") Integer id) throws Exception {
		Cartorio user = cartorioService.searchById(id);
		return ResponseEntity.ok(user);
	}
	
	@PostMapping 
	public ResponseEntity<Cartorio> save(@RequestBody Cartorio cartorio){
		Cartorio createdCartorio = cartorioService.save(cartorio);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdCartorio);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Cartorio> update(@PathVariable(name = "id") Integer id, @RequestBody Cartorio cartorio){
		cartorio.setId(id);
		Cartorio updateCartorio = cartorioService.save(cartorio);
		return ResponseEntity.ok(updateCartorio);
	}
	
	@DeleteMapping("/{id}")
	private ResponseEntity<Cartorio> delete(@PathVariable Integer id){
		cartorioService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping
	private ResponseEntity<List<Cartorio>> listAll(){
		List<Cartorio> result = cartorioService.listAll();
		return ResponseEntity.ok().body(result);
	}
 	
}
