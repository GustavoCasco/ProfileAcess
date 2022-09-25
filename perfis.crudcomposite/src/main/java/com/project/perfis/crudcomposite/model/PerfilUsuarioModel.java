package com.project.perfis.crudcomposite.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

import com.project.perfis.crudcomposite.DTO.PerfilUsuarioRequestDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "perfilusuario")
public class PerfilUsuarioModel implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idperfilusuario")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(sequenceName = "perfilusuario_seq",allocationSize = 1, name = "perfilusuario_seq")
	private Integer idPerfilUsuario;
	
	@Column(name = "tipoperfil")
	private String profileType;
	
	@Column(name = "numerocnpjvinculado")
	private long linkedCNPJnumber;

	@Column(name = "numerocpfvinculado")
	private long linkedCPFnumber;
	
	@Column(name = "situacaoperfil")
	private String profileSituation;
	
	@Column(name = "indperfilprincipal")
	private String principalProfileIdentificacao;
	
	@Column(name = "indprimeiroacesso")
	private String principalAcessFirst;
	
	@Column(name = "nomeempresavinculada")
	private String linkedCompanyName;
	
	@Column(name = "descricaoemailcontato")
	private String contactEmailDescription;
	
	@Column(name = "ddd")
	private Integer ddd;	
	
	@Column(name = "telefonecontato")
	private long contactPhone;	
	
	@Column(name = "usuarioinclusao")
	private String inclusionUser;
	
	@Column(name = "datainclusao")
	private Timestamp inclusionDate;
	
	@Column(name = "usuarioultimaalteracao")
	private String lastUpdateUser;
	
	@Column(name = "dataultimaatualizacao")
	private Timestamp lastUpdateDate;
	
	@ManyToOne
	@JoinColumn(name = "idusuario")
	public UsuariosModel usuario;
	
	public PerfilUsuarioRequestDTO toDto()
	{
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(this, PerfilUsuarioRequestDTO.class);
	}
}
