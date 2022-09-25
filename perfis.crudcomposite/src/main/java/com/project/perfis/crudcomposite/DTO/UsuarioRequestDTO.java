package com.project.perfis.crudcomposite.DTO;

import org.modelmapper.ModelMapper;

import com.project.perfis.crudcomposite.model.UsuariosModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioRequestDTO {

	private	String companyCode;
	
	private long documentNumber;
	
	private String userName;

	private String inclusionUser;
	
	private String lastUpdateUser;
	
	public UsuariosModel toModel()
	{
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(this, UsuariosModel.class);
	}
	
}
