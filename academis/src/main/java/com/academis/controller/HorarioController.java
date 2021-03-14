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

import com.academis.model.Horario;
import com.academis.model.Turma_Materia;
import com.academis.repository.HorarioRepository;
import com.academis.repository.Turma_MateriaRepository;

@RestController
@RequestMapping(path = "/horario")

public class HorarioController {

	@Autowired
	private HorarioRepository repository;

	@GetMapping
	public List<Horario> listar() {
		return repository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Horario>> buscar(@PathVariable int id) {
		Optional<Horario> horario = repository.findById(id);

		if (horario == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(horario);
	}

	@PostMapping
	public Horario adicionar(@RequestBody Horario horario) {
		return repository.save(horario);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Horario> alterar(@RequestBody Horario horario, @PathVariable int id) {

		if (!repository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}

		horario.setId(id);
		horario = repository.save(horario);
		return ResponseEntity.ok(horario);
	}

//			  @DeleteMapping("/{id}")
//			  public  @ResponseBody void remover(@PathVariable int id) {
//				  materiaRepository.deleteById(id);
//			  }
}
