package com.project.perfis.crudcomposite.service;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.perfis.crudcomposite.model.UsuariosModel;

@Repository
public interface UsuarioService extends JpaRepository<UsuariosModel, Integer> {
	
	Optional<UsuariosModel> findByDocumentNumber(Long id);

}
 