package com.academis.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.academis.model.Administrador;
import com.academis.model.Chamada;
import com.academis.repository.AdministradorRepository;


@RestController
@RequestMapping(path = "/administrador")
public class AdministradorController {
	@Autowired
	private AdministradorRepository repository;
	
	@GetMapping
	public List<Administrador> listar() {
		return repository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Administrador>> buscar(@PathVariable int id) {
		Optional<Administrador> administrador = repository.findById(id);

		if (administrador == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(administrador);
	}

	@PostMapping
	public Administrador adicionar(@RequestBody Administrador administrador) {
		return repository.save(administrador);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Administrador> alterar(@RequestBody Administrador administrador, @PathVariable int id) {

		if (!repository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}

		administrador.setId(id);
		administrador = repository.save(administrador);
		return ResponseEntity.ok(administrador);
	}

//		  @DeleteMapping("/{id}")
//		  public  @ResponseBody void remover(@PathVariable int id) {
//			  repository.deleteById(id);
//		  }
}
