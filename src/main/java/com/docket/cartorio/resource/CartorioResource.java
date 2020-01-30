package com.docket.cartorio.resource;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.docket.cartorio.dto.CartorioDTO;
import com.docket.cartorio.model.Cartorio;
import com.docket.cartorio.service.CartorioService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "cartorios")
public class CartorioResource {
	
	@Autowired
	private CartorioService cartorioService;
	
	@ApiOperation(value = "Listar cartorios")
	@ApiResponses(value = {
	        @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
	        @ApiResponse(code = 500, message = "Não foi possivel encontrar o recurso, verifique a requisição"),
	    })
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	private ResponseEntity<List<CartorioDTO>> listAll(){
		List<Cartorio> result = cartorioService.listAll();
		List<CartorioDTO> listDto = result.stream().map(obj -> new CartorioDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@ApiOperation(value = "Cadastrar novos cartorios")
	@RequestMapping(method = RequestMethod.POST, produces = "application/json") 
	public ResponseEntity<Cartorio> save(@Valid @RequestBody Cartorio cartorio){
		Cartorio createdCartorio = cartorioService.save(cartorio);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdCartorio);
	}
	
	@ApiOperation(value = "Atualizar cartorios")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<Cartorio> update(@PathVariable(name = "id") Integer id, @Valid @RequestBody Cartorio cartorio){
		cartorio.setId(id);
		Cartorio updateCartorio = cartorioService.save(cartorio);
		return ResponseEntity.ok(updateCartorio);
	}
	
	@ApiOperation(value = "Excluir cartorios")
	@ApiResponses(value = {
	        @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
	        @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	    })
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
	private ResponseEntity<Cartorio> delete(@PathVariable(name = "id") Integer id){
		cartorioService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation(value = "Retornar um cartorio pelo identificado")
	@ApiResponses(value = {
	        @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
	        @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	    })
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Cartorio> searchById(@PathVariable("id") Integer id) throws Exception {
		Cartorio cartorio = cartorioService.searchById(id);
		return ResponseEntity.ok(cartorio);
	}
 	
}
