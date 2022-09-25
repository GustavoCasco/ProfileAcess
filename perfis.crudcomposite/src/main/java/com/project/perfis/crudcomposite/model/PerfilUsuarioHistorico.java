package com.project.perfis.crudcomposite.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "perfilusuariohistorico")
public class PerfilUsuarioHistorico {
	
	@EmbeddedId
	private PerfilUsuarioHistoricoPrimaryKeyModel id;
	
	@Column(name = "tipoperfil")
	private String profileType;
	
	@Column(name = "situacaoperfil")
	private String profileSituation;
	
	@Column(name = "tipoatualizacao")
	private String updateType;
	
	@Column(name = "usuarioultimaalteracao")
	private String updateLastUser;
	
	@Column(name = "dataultimaatualizacao")	
	private Timestamp updateLastData;

}
