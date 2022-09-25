package com.project.perfis.crudcomposite.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

import com.project.perfis.crudcomposite.DTO.UsuarioRequestDTO;
import com.project.perfis.crudcomposite.DTO.UsuarioResponseDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "usuario")
@NoArgsConstructor
@AllArgsConstructor
public class UsuariosModel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idusuario")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "usuario_seq", allocationSize = 1, sequenceName = "usuario_seq")
	private Integer idUsuario;
	
	@Column(name = "cdempresa", length = 3)
	private	String companyCode;
	
	@Column(name = "numerodocumento")
	private long documentNumber;
	
	@Column(name = "nomeusuario")
	private String userName;

	@Column(name = "usuarioinclusao")
	private String inclusionUser;
	
	@Column(name = "datainclusao")
	private Timestamp inclusionDate = new Timestamp(System.currentTimeMillis());;
	
	@Column(name = "usuarioultimaalteracao")
	private String lastUpdateUser;
	
	@Column(name = "dataultimaatualizacao")
	private Timestamp lastUpdateDate;
	
	@OneToMany(mappedBy = "usuario")
	public List<PerfilUsuarioModel> perfil;
	
	public UsuarioRequestDTO toDto()
	{
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(this, UsuarioRequestDTO.class);
	}
	
	public UsuarioResponseDTO toDtoResponse()
	{
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(this, UsuarioResponseDTO.class);
	}
}
