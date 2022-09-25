package com.project.perfis.crudcomposite.DTO;

import java.io.Serializable;
import java.sql.Timestamp;

import com.project.perfis.crudcomposite.model.UsuariosModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PerfilUsuarioRequestDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String nome;
	
	private String profileType;
	
	private long linkedCNPJnumber;

	private long linkedCPFnumber;
	
	private String profileSituation;
	private String principalProfileIdentificacao;
	
	private String principalAcessFirst;
	
	private String linkedCompanyName;
	
	private String contactEmailDescription;
	
	private Integer ddd;	
	
	private long contactPhone;	
	
	private String inclusionUser;
	
	private Timestamp inclusionDate;
	
	private String lastUpdateUser;
	
	private Timestamp lastUpdateDate;
	
	public UsuariosModel usuario;
}
