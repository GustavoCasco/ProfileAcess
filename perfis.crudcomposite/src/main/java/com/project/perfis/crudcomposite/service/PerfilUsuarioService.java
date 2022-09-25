package com.project.perfis.crudcomposite.service;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.perfis.crudcomposite.model.PerfilUsuarioModel;

@Repository
public interface PerfilUsuarioService extends JpaRepository<PerfilUsuarioModel, Integer> {

	Optional<PerfilUsuarioModel> findByLinkedCPFnumberAndProfileType(long cpf, String profile);
}
