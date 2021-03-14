package com.academis.controller;

import java.util.List;
import java.util.Optional;

import javax.swing.text.html.parser.Entity;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.academis.model.Materia;
import com.academis.model.Usuario;
import com.academis.repository.MateriaRepository;

@RestController
@RequestMapping(path="/materia")
public class MateriaController {
	
	
	@Autowired
	private MateriaRepository materiaRepository;
	
	@GetMapping
	public  List<Materia> listar() {
		return materiaRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Materia>> buscar(@PathVariable int id) {
		Optional<Materia> materia=materiaRepository.findById(id);	
		
		if (materia == null) {
			return ResponseEntity.notFound().build();
		}		
		return ResponseEntity.ok(materia);
	}
	
	@PostMapping
	public Materia adicionar (@RequestBody Materia m) {	
		return materiaRepository.save(m);
	}	 
	
	 @PutMapping("/{id}")
	  public ResponseEntity<Materia>  alterar(@RequestBody Materia materia, @PathVariable int id) {
	    
	    if(!materiaRepository.existsById(id)) {
	    	return ResponseEntity.notFound().build();
	    }
	    
	    materia.setId(id);
	    materia=materiaRepository.save(materia);
	    return ResponseEntity.ok(materia);
	  }
	 
	
//	  @DeleteMapping("/{id}")
//	  public  @ResponseBody void remover(@PathVariable int id) {
//		  materiaRepository.deleteById(id);
//	  }
}
