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
import com.academis.model.Aluno;
import com.academis.repository.AdministradorRepository;
import com.academis.repository.AlunoRepository;

@RestController
@RequestMapping(path = "/aluno")
public class AlunoController {
	@Autowired
	private AlunoRepository repository;
	
	@GetMapping
	public List<Aluno> listar() {
		return repository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Aluno>> buscar(@PathVariable int id) {
		Optional<Aluno> aluno = repository.findById(id);

		if (aluno == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(aluno);
	}

	@PostMapping
	public Aluno adicionar(@RequestBody Aluno aluno) {
		return repository.save(aluno);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Aluno> alterar(@RequestBody Aluno aluno, @PathVariable int id) {

		if (!repository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}

		aluno.setId(id);
		aluno = repository.save(aluno);
		return ResponseEntity.ok(aluno);
	}

//		  @DeleteMapping("/{id}")
//		  public  @ResponseBody void remover(@PathVariable int id) {
//			  repository.deleteById(id);
//		  }
}
