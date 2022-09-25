package com.project.perfis.crudcomposite.DTO;

import java.sql.Timestamp;

import org.modelmapper.ModelMapper;

import com.project.perfis.crudcomposite.model.UsuariosModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioResponseDTO  {

	private	String companyCode;
	
	private Number documentNumber;
	
	private String userName;

	private String inclusionUser;
	
	private Timestamp inclusionDate;
	
	private String lastUpdateUser;
	
	private Timestamp lastUpdateDate;
	
	public UsuariosModel toModel()
	{
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(this, UsuariosModel.class);
	}
	
}
