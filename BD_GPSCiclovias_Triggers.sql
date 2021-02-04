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

USE gpscicloviaslab;

/* Stored Procedure Insert Dummy Data */
DROP PROCEDURE IF EXISTS sp_InserirVarios;

DELIMITER //

CREATE PROCEDURE sp_InserirVarios (IN Ninicio INT, IN Nfim INT)

BEGIN
	DECLARE Contador INT DEFAULT Ninicio;
	DECLARE dt datetime DEFAULT '2000/01/12';
    DECLARE idade INT DEFAULT TIMESTAMPDIFF (YEAR,dt,CURDATE());
    DECLARE cod INT;
    DECLARE cod_4d INT;
    DECLARE cod_id_3d INT(3) DEFAULT 0;
    
    select max(cod_id)+1, max(cod_id_4d)+10 into cod,cod_4d from Codigopostal;
    
	WHILE (Contador <= Nfim) DO
    
INSERT INTO CodigoPostal (cod_id,cod_id_4d, cod_id_3d, cod_distrito, cod_cidade)
	VALUES (
    cod,
    cod_4d,
    cod_id_3d,
	CONCAT('Distrito ', Contador),
	CONCAT('Cidade ', Contador)
);

INSERT INTO Utilizador (uti_nome, uti_morada, uti_genero, uti_dnasc,uti_idade,cod_id)
	VALUES (
	CONCAT('Primeiro ', Contador),
	CONCAT('Rua ', Contador),
    'M',
	dt,
    idade,
    cod
);
	SET cod = cod + 1;
	SET cod_4d = cod_4d + 10;
    SET cod_id_3d = cod_id_3d + 1;
	Set dt = DATE(dt) + INTERVAL 10 day;
	SET Contador = Contador + 1;
    
	END WHILE;
END//

DELIMITER ;

CALL sp_InserirVarios (1,100);

SELECT * FROM Utilizador;

SELECT * FROM CodigoPostal;

/* Stored Procedure Audit */

DROP TABLE IF EXISTS Audit;

CREATE TABLE Audit(
	aud_id INT AUTO_INCREMENT PRIMARY KEY,
    aud_ident VARCHAR(100) NOT NULL,
    aud_tabela VARCHAR(100) NOT NULL,
    aud_campo VARCHAR(100) NOT NULL,
    aud_operacao VARCHAR(100) NOT NULL,
    aud_mensagem VARCHAR(512) NOT NULL,
    aud_data DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
    ) ENGINE = MYISAM;

DROP PROCEDURE IF EXISTS sp_audit_ins;

DELIMITER //
CREATE PROCEDURE sp_audit_ins(IN identificacao VARCHAR(100), IN tabela VARCHAR(100), IN campo VARCHAR(100), IN operacao VARCHAR(100),IN msg VARCHAR(512))
BEGIN
	INSERT INTO Audit(aud_ident, aud_tabela,aud_campo,aud_operacao,aud_mensagem) values (Identificacao, Tabela, Campo, Operacao, Msg);
END//
DELIMITER ;
    
SELECT * FROM Audit;

/* Trigger Verificar Genero */

DROP TRIGGER IF EXISTS trg_verificar_genero_inserir;

DELIMITER //

CREATE TRIGGER trg_verificar_genero_inserir BEFORE INSERT ON Utilizador FOR EACH ROW
BEGIN 
DECLARE Mensagem VARCHAR(100) DEFAULT "";
	IF NEW.uti_genero<>'M' AND NEW.uti_genero<>'F' THEN
		SET NEW.uti_genero='X';
			SET Mensagem = 'Género Indefinido';
            CALL sp_audit_ins(NEW.uti_nome,'Utilizador','uti_genero','INSERT', Mensagem);
	END IF;
    
END//

DELIMITER ;

INSERT INTO Utilizador (uti_nome, uti_morada, uti_genero, uti_dnasc, uti_idade, cod_id)
	VALUES (
	'Zé da Silva',
	'Rua Iade',
    'J',
	'2001-02-02',
    20,
    1
);

SELECT * FROM Utilizador;

SELECT * FROM Audit;

/* Trigger Update Extensão Ciclovias */ 

DROP TRIGGER IF EXISTS trg_before_cicExtensao_update;  

DELIMITER //

CREATE TRIGGER trg_before_cicExtensao_update BEFORE UPDATE ON Ciclovia 
    FOR EACH ROW
    	
BEGIN
	DECLARE Mensagem VARCHAR(100) DEFAULT "";
    SET Mensagem = old.cic_extensao;
	CALL sp_audit_ins(OLD.cic_nome,'Ciclovia','OLD','UPDATE', Mensagem);
     SET Mensagem = new.cic_extensao;
	CALL sp_audit_ins(new.cic_nome,'Ciclovia','NEW','UPDATE', Mensagem);
END//

DELIMITER ;

UPDATE Ciclovia 
SET
	cic_extensao = 8000 
WHERE
    cic_id = 1;
    
SELECT * FROM Ciclovia;

SELECT * FROM Audit;

/* Stored Procedure Extensão Hierárquico (atribuir os valores dos metros percorridos em ciclovias) */

DROP PROCEDURE IF EXISTS sp_uti_hierarquia_cic;

DELIMITER //
CREATE PROCEDURE sp_uti_hierarquia_cic()
BEGIN
	ALTER TABLE Utilizador ADD COLUMN uti_metros INTEGER;
    
    UPDATE Utilizador SET uti_metros = (SELECT sum(cic_extensao) 
										From Inclui
										Left join Ciclovia
										ON Inclui.cic_id=Ciclovia.cic_id
										WHERE utilizador.cod_id=inclui.cod_id
                                        );
 
END//
DELIMITER ;

CALL sp_uti_hierarquia_cic();

SELECT * FROM Utilizador;

/* Stored Procedure	Descrição Hierárquica */ 

DROP PROCEDURE IF EXISTS sp_utilizadores_descricao;

DELIMITER //
CREATE PROCEDURE sp_utilizadores_descricao()
BEGIN
	SELECT u.uti_id, u.uti_nome, u.uti_genero, u.uti_dnasc, IFNULL(u.uti_metros, 0 ) AS 'uti_id_metros', IFNULL((SELECT b.uti_nome FROM Utilizador b WHERE b.uti_metros>u.uti_metros order by b.uti_metros limit 1), 'Campeão das Ciclovias') AS 'Sup.Hierárquico'
    From Utilizador u ;
    
END//
DELIMITER ;

call sp_utilizadores_descricao();

SELECT * FROM Utilizador;

/* Trigger Apagar Utilizador juntamente com tabelas relacionadas ( Exemplo Teste de DELETE de acordo com o RGPD) */ 

DROP TRIGGER IF EXISTS trg_after_uti_delete;  

DELIMITER //

CREATE TRIGGER trg_after_uti_delete BEFORE DELETE ON Utilizador 
	FOR EACH ROW
BEGIN
	DELETE FROM veiculo WHERE uti_id=old.uti_id; 
    DELETE FROM avaliacao WHERE uti_id=old.uti_id;
    DELETE FROM inclui WHERE iti_id IN( SELECT iti_id FROM itinerario WHERE uti_id=old.uti_id);
    DELETE FROM itinerario_per_coordgps where iti_id in ( SELECT iti_id FROM itinerario WHERE uti_id=old.uti_id);
    DELETE FROM itinerario WHERE uti_id=old.uti_id;
    DELETE FROM utilizador_uti_contactos WHERE uti_id=old.uti_id;
END//

DELIMITER ;

DELETE FROM Utilizador WHERE UTI_id = 1;

SELECT * FROM Veiculo WHERE uti_id=1;
SELECT * FROM avaliacao WHERE uti_id=1;
SELECT * FROM Itinerario WHERE uti_id=1;
SELECT * FROM Inclui WHERE cod_id=1;
SELECT * FROM Utilizador WHERE uti_id=1;


