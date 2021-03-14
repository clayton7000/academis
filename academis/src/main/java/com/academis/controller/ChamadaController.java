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

import com.academis.model.Chamada;
import com.academis.model.Turma_Materia;
import com.academis.repository.ChamadaRepository;
import com.academis.repository.Turma_MateriaRepository;


@RestController
@RequestMapping(path = "/chamada")


public class ChamadaController {

	
	

		@Autowired
		private ChamadaRepository repository;

		@GetMapping
		public List<Chamada> listar() {
			return repository.findAll();
		}

		@GetMapping("/{id}")
		public ResponseEntity<Optional<Chamada>> buscar(@PathVariable int id) {
			Optional<Chamada> chamada = repository.findById(id);

			if (chamada == null) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok(chamada);
		}

		@PostMapping
		public Chamada adicionar(@RequestBody Chamada chamada) {
			return repository.save(chamada);
		}

		@PutMapping("/{id}")
		public ResponseEntity<Chamada> alterar(@RequestBody Chamada chamada, @PathVariable int id) {

			if (!repository.existsById(id)) {
				return ResponseEntity.notFound().build();
			}

			chamada.setId(id);
			chamada = repository.save(chamada);
			return ResponseEntity.ok(chamada);
		}

//			  @DeleteMapping("/{id}")
//			  public  @ResponseBody void remover(@PathVariable int id) {
//				  repository.deleteById(id);
//			  }
}
