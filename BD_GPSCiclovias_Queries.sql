USE gpscicloviaslab;

/* 1-Calcular Idade e Ordenar por Idade*/
SELECT uti_id,uti_nome,TIMESTAMPDIFF(YEAR,uti_dNasc,CURDATE()) as uti_idade 
from utilizador
WHERE uti_dNasc IS NOT NULL
ORDER BY uti_idade;

/* 2-Visualizar Contactos do Utilizador*/
SELECT Utilizador.uti_id,uti_nome as NomeCompleto,uti_contactos as Contactos from Utilizador
Inner join Utilizador_uti_contactos 
ON Utilizador.uti_id=Utilizador_uti_contactos.uti_id;

/* 3-Visualizar Utilizador e Marca do Veiculo*/
SELECT Utilizador.uti_id,uti_nome as NomeCompleto ,vei_marca as Marca from Utilizador
Left join Veiculo
ON Utilizador.uti_id=Veiculo.uti_id;

/* 4-Visualizar Utilizador,Veiculo e TipoVeiculo*/
SELECT Utilizador.uti_id,uti_nome as NomeCompleto,vei_numeroRodas as NumeroRodas, vei_marca as Marca,tv_nome as TipoVeiculo from Utilizador
Left join Veiculo 
ON Utilizador.uti_id=Veiculo.uti_id
Left join Tipoveiculo
ON TipoVeiculo.tv_id=Veiculo.uti_id;

/* 5-Visualizar Utilizador e CodigoPostal*/
SELECT uti_id,uti_nome as NomeCompleto,concat(cod_id_4d,'-',right(concat('000',cod_id_3d), 3)) as CodigoPostal from Utilizador 
Inner join CodigoPostal
ON Utilizador.cod_id=CodigoPostal.cod_id;

/* 6-Visualizar Utilizador, Ciclovia e CategoriaCiclovia */
SELECT uti_id,uti_nome as NomeCompleto,cic_nome as NomeCiclovia,cc_nome as CategoriaCiclovia  from Utilizador
Inner join Ciclovia
ON Utilizador.uti_id=Ciclovia.cic_id
Inner join CategoriaCiclovia
ON Ciclovia.cc_id=CategoriaCiclovia.cc_id;

/* 7-Visualizar Pontos de Interesse da Ciclovia */
SELECT cic.cic_id,cic.cic_nome as NomeCiclovia, c.cic_pdi as PontosInteresse from Ciclovia cic
Inner join Ciclovia_cic_pdi c
ON cic.cic_id=c.cic_id;

/* 8-Visualizar Ciclovia e CategoriaCiclovia*/
SELECT cic_id,cic_nome as NomeCiclovia,CategoriaCiclovia.cc_id,cc_nome as CategoriaCiclovia,cc_descricao as Descricao from Ciclovia
Inner join CategoriaCiclovia
ON Ciclovia.cc_id=CategoriaCiclovia.cc_id;

/* 9-Visualizar Ciclovia e Escala*/
SELECT cic_id,Escala.esc_id from Ciclovia
Inner join Escala
ON Ciclovia.esc_id=Escala.esc_id;

/* 10-Visualizar Veiculo e TipoVeiculo*/
SELECT veic.*, tveic.tv_nome as TipoVeiculo,tveic.tv_descricao as Descricao from Veiculo veic
Left join TipoVeiculo tveic 
on veic.tv_id=tveic.tv_id ;

/* 11-Visualizar Número Total de Utilizadores*/
select count(uti_id) as "Total Utilizadores"
from utilizador;

/* 12-Quantos utilizadores existem por Concelho*/
select count(uti_id) as "Total Utilizadores" ,cod_concelho as Concelho from Utilizador
Left join CodigoPostal
ON Utilizador.cod_id=CodigoPostal.cod_id
group by cod_concelho
order by cod_concelho desc;

/* 13-Visualizar quantos utilizadores existem do genero feminino e masculino*/
select uti_genero as "Genero",count(uti_id) as "Total Utilizadores" from utilizador
where uti_genero="M" or uti_genero="F"
group by uti_genero;

/* 14-Visualizar Media de Avaliacoes para Ciclovia*/
SELECT Avaliacao.cic_id,avg(esc_avaliacao) as MediaAvaliacoes from Avaliacao
Inner join  Escala 
ON Avaliacao.esc_id=Escala.esc_id
group by Avaliacao.cic_id
order by Avaliacao.cic_id;

/* 15-Visualizar Concelhos com 3 ou mais pessoas*/
select count(u.uti_id) as "Numero",cod_concelho
from utilizador u ,CodigoPostal cod
where u.uti_id = cod.cod_id
group by cod.cod_concelho
having count(u.uti_id) >= 3;


