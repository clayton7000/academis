package com.academis.controller;

import java.util.List;
import java.util.Optional;

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
import com.academis.repository.UsuarioRepository;


@RestController
@RequestMapping(path="/usuario") 
public class UsuarioController {
	@Autowired
	private UsuarioRepository repository;	
	
	
	
	@GetMapping
	public  List<Usuario> listar() {
		return (List<Usuario>) repository.findAll();
	}
	
	@GetMapping("/{matricula}")
	public ResponseEntity<Optional<Usuario>> buscar(@PathVariable String matricula) {
		Optional<Usuario> usuario=repository.findById(matricula);	
		
		if (usuario == null) {
			return ResponseEntity.notFound().build();
		}		
		return ResponseEntity.ok(usuario);
	}
	
	@PostMapping
	public Usuario adicionar (@RequestBody Usuario usuario) {	
		return repository.save(usuario);
	}	 
	
	 @PutMapping("/{matricula}")
	  public ResponseEntity<Usuario>  alterar(@RequestBody Usuario usuario, @PathVariable String matricula) {
	    
	    if(!repository.existsById(matricula)) {
	    	return ResponseEntity.notFound().build();
	    }
	    
	    usuario.setMatricula(matricula);
	    usuario=repository.save(usuario);
	    return ResponseEntity.ok(usuario);
	  }
	 
	
//	  @DeleteMapping("/{matricula}")
//	  public void remover(@PathVariable String matricula) {
//		  repository.deleteById(matricula);
//	  }
}
