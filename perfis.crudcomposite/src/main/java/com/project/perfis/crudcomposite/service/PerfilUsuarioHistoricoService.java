package com.project.perfis.crudcomposite.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.perfis.crudcomposite.model.PerfilUsuarioHistorico;
import com.project.perfis.crudcomposite.model.PerfilUsuarioHistoricoPrimaryKeyModel;

@Repository
public interface PerfilUsuarioHistoricoService extends JpaRepository<PerfilUsuarioHistorico, PerfilUsuarioHistoricoPrimaryKeyModel> {

}
