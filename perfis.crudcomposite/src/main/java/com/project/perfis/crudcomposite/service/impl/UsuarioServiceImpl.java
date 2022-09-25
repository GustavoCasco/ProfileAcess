package com.project.perfis.crudcomposite.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.perfis.crudcomposite.DTO.UsuarioRequestDTO;
import com.project.perfis.crudcomposite.DTO.UsuarioResponseDTO;
import com.project.perfis.crudcomposite.model.PerfilUsuarioHistoricoPrimaryKeyModel;
import com.project.perfis.crudcomposite.model.UsuariosModel;
import com.project.perfis.crudcomposite.service.PerfilUsuarioHistoricoService;
import com.project.perfis.crudcomposite.service.PerfilUsuarioService;
import com.project.perfis.crudcomposite.service.UsuarioService;

@Service
public class UsuarioServiceImpl {
	
	@Autowired
	private UsuarioService repository;
	
	@Autowired
	private PerfilUsuarioHistoricoService repositorys;

	
	public List<UsuarioResponseDTO> getall()
	{
		List<UsuariosModel> users = this.repository.findAll();
		return users.stream().map(a -> a.toDtoResponse()).collect(Collectors.toCollection(ArrayList::new));
	}
	
	public Object getById(PerfilUsuarioHistoricoPrimaryKeyModel id) throws Exception
	{
		return this.repositorys.findById(id)
				.orElseThrow(() -> new Exception("Not Found"));
	}
	
	public UsuarioRequestDTO save(UsuarioRequestDTO user) {
		UsuariosModel model = new UsuariosModel();
		model.setCompanyCode(user.getCompanyCode());
		model.setDocumentNumber(user.getDocumentNumber());
		model.setInclusionDate(new Timestamp(System.currentTimeMillis()));
		model.setInclusionUser("");
		model.setUserName(user.getUserName());
		return this.repository.save(model).toDto();
	}
}
