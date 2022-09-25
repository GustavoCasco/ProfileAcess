package com.project.perfis.crudcomposite.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class PerfilUsuarioHistoricoPrimaryKeyModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "idusuario")
	private Integer idUsuarioHistorico;
	
	@Column(name = "idperfilusuario")
	private Integer idPerfilUsuario;
	
	@Column(name = "datainclusao")
	private Timestamp inclusionDate;
}
