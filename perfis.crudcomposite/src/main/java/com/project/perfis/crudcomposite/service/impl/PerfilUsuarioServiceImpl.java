package com.project.perfis.crudcomposite.service.impl;

import java.sql.Timestamp;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.perfis.crudcomposite.DTO.PerfilUsuarioRequestDTO;
import com.project.perfis.crudcomposite.model.PerfilUsuarioHistorico;
import com.project.perfis.crudcomposite.model.PerfilUsuarioHistoricoPrimaryKeyModel;
import com.project.perfis.crudcomposite.model.PerfilUsuarioModel;
import com.project.perfis.crudcomposite.model.UsuariosModel;
import com.project.perfis.crudcomposite.service.PerfilUsuarioHistoricoService;
import com.project.perfis.crudcomposite.service.PerfilUsuarioService;
import com.project.perfis.crudcomposite.service.UsuarioService;

@Service
public class PerfilUsuarioServiceImpl {
	
	@Autowired
	private PerfilUsuarioService repository;
	
	@Autowired
	private UsuarioService repositoryUser;
	
	@Autowired
	private PerfilUsuarioHistoricoService repositoryUserHistory;

	
	public Object save(PerfilUsuarioRequestDTO profileUser) {
		
		Optional<UsuariosModel> user = repositoryUser.findByDocumentNumber(profileUser.getLinkedCPFnumber());
		if(!user.isPresent()) {
			createUser(profileUser);
			Optional<UsuariosModel> userExists = repositoryUser.findByDocumentNumber(profileUser.getLinkedCPFnumber());
			return saveTablePerfilUsuario(profileUser, userExists.get());
		}else {
			return saveTablePerfilUsuario(profileUser, user.get());
		}
	}
	
	public void createUser(PerfilUsuarioRequestDTO perfil) {
		UsuariosModel userNotExists =  new UsuariosModel();
		userNotExists.setCompanyCode("SNT");
		userNotExists.setUserName(perfil.getNome());
		userNotExists.setDocumentNumber(perfil.getLinkedCPFnumber());
		userNotExists.setInclusionDate(new Timestamp(System.currentTimeMillis()));
		userNotExists.setInclusionUser("");
		userNotExists.setLastUpdateDate(null);
		userNotExists.setLastUpdateUser(null);
		repositoryUser.save(userNotExists);
	}
	
	public Object saveTablePerfilUsuario(PerfilUsuarioRequestDTO profile, UsuariosModel user) {
		PerfilUsuarioModel model = new PerfilUsuarioModel();
		model.setProfileType(profile.getProfileType());
		model.setContactEmailDescription(profile.getContactEmailDescription());
		model.setContactPhone(profile.getContactPhone());
		model.setDdd(profile.getDdd());
		model.setInclusionDate(new Timestamp(System.currentTimeMillis()));
		model.setInclusionUser("");
		model.setLastUpdateDate(null);
		model.setLastUpdateUser(null);
		model.setLinkedCNPJnumber(profile.getLinkedCNPJnumber());
		model.setLinkedCPFnumber(profile.getLinkedCPFnumber());
		model.setLinkedCompanyName(profile.getLinkedCompanyName());
		model.setPrincipalAcessFirst("S");
		model.setUsuario(user);
		this.repository.save(model);
		return saveTableHistorico(model);
		
	}
	
	public Object saveTableHistorico(PerfilUsuarioModel perfil) {
		Optional<PerfilUsuarioModel> userProfile = repository.findByLinkedCPFnumberAndProfileType(perfil.getLinkedCPFnumber(), perfil.getProfileType());
		PerfilUsuarioHistorico modelHistorico = new PerfilUsuarioHistorico();
		PerfilUsuarioHistoricoPrimaryKeyModel id = new PerfilUsuarioHistoricoPrimaryKeyModel();
		userProfile.stream().forEach((a) -> {
			id.setIdPerfilUsuario(a.getIdPerfilUsuario());
			id.setIdUsuarioHistorico(a.getUsuario().getIdUsuario());
		});
		id.setInclusionDate(new Timestamp(System.currentTimeMillis()));
		modelHistorico.setId(id);
		modelHistorico.setProfileType(perfil.getProfileType());
		modelHistorico.setProfileSituation("A");
		modelHistorico.setUpdateType("a");
		return repositoryUserHistory.save(modelHistorico);
	}
}
