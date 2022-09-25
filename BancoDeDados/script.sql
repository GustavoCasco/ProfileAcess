CREATE SEQUENCE perfilusuariohistorico_seq
INCREMENT 1
MINVALUE 1
MAXVALUE 999999999999999999
START 1;

CREATE TABLE usuario(
    idusuario integer primary key not null DEFAULT NEXTVAL('usuario_seq'),
    cdempresa char(3),
    numerodocumento NUMERIC(11,0),
    nomeusuario varchar(60),
    usuarioinclusao char(20),
    datainclusao TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP(),
    usuarioultimaalteracao char(20),
    dataultimaatualizacao TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
)

CREATE TABLE perfilusuario(
    idperfilusuario integer not null DEFAULT NEXTVAL('perfilusuario_seq'),
    idusuario integer,
    FOREIGN KEY (idusuario) REFERENCES usuario (idusuario),
    PRIMARY KEY (idperfilusuario),
    tipoperfil char(2),
    numerocnpjvinculado numeric(15,0),
    numerocpfvinculado numeric(11,0),
    situacaoperfil char(1),
    indperfilprincipal char(2),
    indprimeiroacesso char(1),
    nomeempresavinculada varchar(60),
    descricaoemailcontato varchar(60),
    ddd numeric(3,0),
    telefonecontato numeric(9,0),
    usuarioinclusao char(20),
    datainclusao TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    usuarioultimaalteracao char(20),
    dataultimaatualizacao TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
)

CREATE TABLE perfilusuariohistorico(
    idusuario INTEGER,
    idperfilusuario INTEGER,
    datainclusao timestamp default CURRENT_TIMESTAMP,
    tipoperfil char(2),
    situacaoperfil char(1),
    tipoatualizacao char(1),
    usuarioultimaalteracao char(20),
    dataultimaatualizacao timestamp default CURRENT_TIMESTAMP,
    PRIMARY KEY (idusuario, idperfilusuario,datainclusao)
)

SELECT CURRENT_TIMESTAMP;
select * from perfilusuariohistorico
