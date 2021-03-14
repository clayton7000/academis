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

import com.academis.model.Nota;
import com.academis.model.Turma_Materia;
import com.academis.repository.NotaRepository;
import com.academis.repository.Turma_MateriaRepository;

@RestController
@RequestMapping(path = "/nota")
public class NotaController {

	@Autowired
	private NotaRepository repository;

	@GetMapping
	public List<Nota> listar() {
		return repository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Nota>> buscar(@PathVariable int id) {
		Optional<Nota> nota = repository.findById(id);

		if (nota == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(nota);
	}

	@PostMapping
	public Nota adicionar(@RequestBody Nota nota) {
		return repository.save(nota);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Nota> alterar(@RequestBody Nota nota, @PathVariable int id) {

		if (!repository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}

		nota.setId(id);
		nota = repository.save(nota);
		return ResponseEntity.ok(nota);
	}

//			  @DeleteMapping("/{id}")
//			  public  @ResponseBody void remover(@PathVariable int id) {
//				  repository.deleteById(id);
//			  }
}
