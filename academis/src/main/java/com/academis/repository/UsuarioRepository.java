package com.academis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.academis.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,String>{

}
