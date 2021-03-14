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

import com.academis.model.Materia;
import com.academis.model.Turma;
import com.academis.repository.MateriaRepository;
import com.academis.repository.TurmaRepository;

@RestController
@RequestMapping(path="/turma")
public class TurmaController {
	@Autowired
	private TurmaRepository repository;
	
	@GetMapping
	public  List<Turma> listar() {
		return repository.findAll();
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Optional<Turma>> buscar(@PathVariable int codigo) {
		Optional<Turma> materia=repository.findById(codigo);	
		
		if (materia == null) {
			return ResponseEntity.notFound().build();
		}		
		return ResponseEntity.ok(materia);
	}
	
	@PostMapping
	public Turma adicionar (@RequestBody Turma turma) {	
		return repository.save(turma);
	}	 
	
	 @PutMapping("/{codigo}")
	  public ResponseEntity<Turma>  alterar(@RequestBody Turma turma, @PathVariable int codigo) {
	    
	    if(!repository.existsById(codigo)) {
	    	return ResponseEntity.notFound().build();
	    }
	    
	    turma.setCodigo(codigo);
	    turma=repository.save(turma);
	    return ResponseEntity.ok(turma);
	  }
	 
	
//	  @DeleteMapping("/{id}")
//	  public  @ResponseBody void remover(@PathVariable int id) {
//		  materiaRepository.deleteById(id);
//	  }
}
