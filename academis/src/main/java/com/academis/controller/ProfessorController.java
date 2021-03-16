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
import com.academis.model.Professor;
import com.academis.repository.AlunoRepository;
import com.academis.repository.ProfessorRepository;

@RestController
@RequestMapping(path="/professor")
public class ProfessorController {
	@Autowired
	private ProfessorRepository repository;
	
	@GetMapping
	public List<Professor> listar() {
		return repository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Professor>> buscar(@PathVariable int id) {
		Optional<Professor> professor = repository.findById(id);

		if (professor == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(professor);
	}

	@PostMapping
	public Professor adicionar(@RequestBody Professor professor) {
		return repository.save(professor);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Professor> alterar(@RequestBody Professor professor, @PathVariable int id) {

		if (!repository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}

		professor.setId(id);
		professor = repository.save(professor);
		return ResponseEntity.ok(professor);
	}

//		  @DeleteMapping("/{id}")
//		  public  @ResponseBody void remover(@PathVariable int id) {
//			  repository.deleteById(id);
//		  }
}
