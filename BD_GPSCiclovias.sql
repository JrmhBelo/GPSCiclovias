/************************************************************
*	Grupo: GPSCiclovias    |  Curso: L-IG
*  	UC: Bases de Dados
*
*	Pojeto: GPSCiclovias  
*
*  	Nome: Tomás Gama (20190796)
*  	Nome: João Belo (20190848)
    Nome: João André (20190812)
*
************************************************************/

DROP DATABASE IF EXISTS GPSCicloviaslab ;

CREATE DATABASE GPSCicloviaslab;

USE GPSCicloviaslab;

/************************************************************
*  Lista de Entidades Informaconais Primárias
************************************************************/

CREATE TABLE TipoVeiculo 
(
  tv_id INT AUTO_INCREMENT,
  tv_nome VARCHAR(60),
  tv_descricao VARCHAR(200),
  PRIMARY KEY (tv_id)
);

CREATE TABLE CodigoPostal
(
  cod_id INT AUTO_INCREMENT,
  cod_id_4d INT NOT NULL,
  cod_id_3d INT NOT NULL,
  cod_distrito VARCHAR(35) NOT NULL,
  cod_cidade VARCHAR(35) NOT NULL,
  cod_localidade VARCHAR(35),
  cod_concelho VARCHAR(35),
  cod_freguesia VARCHAR(35),
  PRIMARY KEY (cod_id),
  UNIQUE (cod_id_4d,cod_id_3d)
);

CREATE TABLE CategoriaCiclovia
(
  cc_id INT AUTO_INCREMENT,
  cc_nome VARCHAR(60) NOT NULL,
  cc_descricao VARCHAR(200) NOT NULL,
  PRIMARY KEY (cc_id)
);

CREATE TABLE Escala
(
  esc_id INT AUTO_INCREMENT,
  esc_descricao VARCHAR(200) NOT NULL,
  esc_nvdif TINYINT NOT NULL,
  PRIMARY KEY (esc_id)
);

CREATE TABLE Escala_avaliacao
(
	escav_id INT AUTO_INCREMENT,
    escav_descricao VARCHAR(200) NOT NULL,
    escav_avaliacao TINYINT NOT NULL,
    PRIMARY KEY(escav_id)
);

/************************************************************
*  Lista de Entidades Informaconais com FK
************************************************************/
CREATE TABLE Utilizador
(
  uti_id INT AUTO_INCREMENT,
  uti_nome VARCHAR(60) NOT NULL,
  uti_morada VARCHAR(200) NOT NULL,
  uti_genero CHAR ,
  uti_dnasc DATE NOT NULL,
  uti_idade INT NOT NULL, 
  cod_id INT,
  CHECK (14 <=2020 - year(uti_dNasc)<= 130), -- TIMESTAMPDIFF (YEAR,uti_dNasc,CURDATE() --
  PRIMARY KEY (uti_id),
  FOREIGN KEY (cod_id) REFERENCES CodigoPostal(cod_id)
);

CREATE TABLE Utilizador_uti_contactos
(
  uti_contactos VARCHAR(100) NOT NULL,
  uti_id INT NOT NULL,
  PRIMARY KEY (uti_contactos, uti_id),
  FOREIGN KEY (uti_id) REFERENCES Utilizador(uti_id)
);

CREATE TABLE Veiculo
(
  vei_id INT AUTO_INCREMENT,
  vei_numerorodas TINYINT NOT NULL,
  vei_marca VARCHAR(35),
  vei_modelo VARCHAR(50),
  tv_id INT NOT NULL,
  uti_id INT NOT NULL,
  PRIMARY KEY (vei_id),
  FOREIGN KEY(uti_id) REFERENCES Utilizador(uti_id),
  FOREIGN KEY (tv_id) REFERENCES TipoVeiculo(tv_id)
);

CREATE TABLE Itinerario
(
  iti_id INT AUTO_INCREMENT,
  iti_pontoDePartida VARCHAR(200) NOT NULL,
  iti_pontoDeChegada VARCHAR(200) NOT NULL,
  uti_id INT NOT NULL,
  PRIMARY KEY (iti_id),
  FOREIGN KEY (uti_id) REFERENCES Utilizador(uti_id)
);

CREATE TABLE Itinerario_per_coordGPS(
  iti_coordGPS_data DATETIME NOT NULL,
  iti_coordGPS_long FLOAT NOT NULL,
  iti_coordGPS_lat FLOAT NOT NULL,
  iti_coordGPS_alt FLOAT NOT NULL,
  iti_id INT NOT NULL,
  PRIMARY KEY (iti_id,iti_coordGPS_data,iti_coordGPS_long,iti_coordGPS_lat, iti_coordGPS_alt),
  FOREIGN KEY (iti_id) REFERENCES Itinerario(iti_id)
  );

CREATE TABLE Ciclovia(
  cic_id INT AUTO_INCREMENT,
  cic_nome VARCHAR(200) NOT NULL,
  cic_extensao INT NOT NULL,
  cic_inicio VARCHAR(200) NOT NULL,
  cic_iniCoord VARCHAR(20) NOT NULL,
  cic_descricao VARCHAR(200),
  cic_fim VARCHAR(200) NOT NULL,
  cic_fimCoord VARCHAR(20) NOT NULL,
  cic_distrito VARCHAR(35) NOT NULL,
  cic_cidade VARCHAR(35) NOT NULL,
  cc_id INT NOT NULL,
  esc_id INT NOT NULL,
  PRIMARY KEY (cic_id),
  FOREIGN KEY (cc_id) REFERENCES CategoriaCiclovia(cc_id),
  FOREIGN KEY (esc_id) REFERENCES Escala(esc_id)
);

CREATE TABLE Ciclovia_cic_pdi(
	cic_pdi varchar(50) NOT NULL,
    cic_id INT NOT NULL,
    PRIMARY KEY (cic_pdi, cic_id),
	FOREIGN KEY (cic_id) REFERENCES Ciclovia(cic_id)
);

CREATE TABLE BikeDock
(
  bik_id INT AUTO_INCREMENT,
  bik_morada VARCHAR(200) NOT NULL,
  bik_localizacao VARCHAR(35) NOT NULL,
  bik_capMax TINYINT NOT NULL,
  cic_id INT NOT NULL,
  PRIMARY KEY (bik_id),
  FOREIGN KEY (cic_id) REFERENCES Ciclovia(cic_id)
);

/************************************************************
*  Lista de Entidades de Associação 
************************************************************/

CREATE TABLE inclui
(
  cod_id INT NOT NULL,
  cic_id INT NOT NULL,
  iti_id INT NOT NULL,
  inc_data TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (cod_id,cic_id,iti_id),
  FOREIGN KEY (iti_id) REFERENCES Itinerario(iti_id),
  FOREIGN KEY (cod_id) REFERENCES CodigoPostal(cod_id),
  FOREIGN KEY (cic_id) REFERENCES Ciclovia(cic_id)
);

CREATE TABLE avaliacao
(
  av_data DATE NOT NULL,
  cic_id INT NOT NULL,
  uti_id INT NOT NULL,
  escav_id INT NOT NULL,
  PRIMARY KEY (cic_id, uti_id, escav_id),
  FOREIGN KEY (cic_id) REFERENCES Ciclovia(cic_id),
  FOREIGN KEY (escav_id) REFERENCES Escala_avaliacao(escav_id),
  FOREIGN KEY (uti_id) REFERENCES Utilizador(uti_id)
);

