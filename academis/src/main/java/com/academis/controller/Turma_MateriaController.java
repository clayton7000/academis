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

import com.academis.model.Turma;
import com.academis.model.Turma_Materia;
import com.academis.model.Usuario;
import com.academis.repository.TurmaRepository;
import com.academis.repository.Turma_MateriaRepository;
import com.academis.repository.UsuarioRepository;

@RestController
@RequestMapping(path = "/turma_materia")
public class Turma_MateriaController {

	@Autowired
	private Turma_MateriaRepository repository;

	@GetMapping
	public List<Turma_Materia> listar() {
		return repository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Turma_Materia>> buscar(@PathVariable int id) {
		Optional<Turma_Materia> turma_Materia = repository.findById(id);

		if (turma_Materia == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(turma_Materia);
	}

	@PostMapping
	public Turma_Materia adicionar(@RequestBody Turma_Materia turma_Materia) {
		return repository.save(turma_Materia);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Turma_Materia> alterar(@RequestBody Turma_Materia turma_Materia, @PathVariable int id) {

		if (!repository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}

		turma_Materia.setId(id);
		turma_Materia = repository.save(turma_Materia);
		return ResponseEntity.ok(turma_Materia);
	}

//		  @DeleteMapping("/{id}")
//		  public  @ResponseBody void remover(@PathVariable int id) {
//			  materiaRepository.deleteById(id);
//		  }
}
