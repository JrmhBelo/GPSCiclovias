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

/* Ordenação */

/* 1-Calcular Idade e Ordenar por Idade */
SELECT uti_id,uti_nome,TIMESTAMPDIFF(YEAR,uti_dNasc,CURDATE()) as uti_idade 
from utilizador
WHERE uti_dNasc IS NOT NULL
ORDER BY uti_idade;

/* 2-Visualizar Contactos do Utilizador */
SELECT Utilizador.uti_id,uti_nome as NomeCompleto,uti_contactos as Contactos from Utilizador
Inner join Utilizador_uti_contactos 
ON Utilizador.uti_id=Utilizador_uti_contactos.uti_id
order by Utilizador.uti_id asc;

/* 3-Visualizar Pontos de Interesse da Ciclovia */
SELECT cic.cic_id,cic.cic_nome as NomeCiclovia, c.cic_pdi as PontosInteresse from Ciclovia cic
Inner join Ciclovia_cic_pdi c
ON cic.cic_id=c.cic_id
order by cic.cic_id asc;

/* Agrupamento de 2 ou mais Tabelas */

/* 4-Visualizar Utilizador, Ciclovia e CategoriaCiclovia */
SELECT uti_id,uti_nome as NomeCompleto,cic_nome as NomeCiclovia,cc_nome as CategoriaCiclovia  from Utilizador
Left join Inclui
ON Utilizador.cod_id=Inclui.cod_id
Left join Ciclovia
ON Inclui.cic_id=Ciclovia.cic_id
Left join CategoriaCiclovia
ON Ciclovia.cc_id=CategoriaCiclovia.cc_id;

/* 5-Visualizar Utilizador e CodigoPostal */
SELECT uti_id,uti_nome as NomeCompleto,concat(cod_id_4d,'-',right(concat('000',cod_id_3d), 3)) as CodigoPostal from Utilizador 
Inner join CodigoPostal
ON Utilizador.cod_id=CodigoPostal.cod_id;

/* 6-Visualizar Número Total de Utilizadores */
select count(uti_id) as "Total Utilizadores"
from utilizador;

/* Funções de Linha, Funções de Grupo e GrouBy */

/* 7-Visualizar Estatísticas dos Utilizadores */
SELECT Utilizador.uti_id as Id , uti_nome as Nome, sum(cic_extensao) as Extensao , count(*) as Cicpercorridas,
		(select count(*) from veiculo where Utilizador.uti_id = veiculo.vei_id) as VeiUtilizados
from Utilizador
Inner join Ciclovia
ON Utilizador.uti_id=Ciclovia.cic_id
group by uti_id; 

/* 8-Quantos utilizadores existem por Concelho */
select count(uti_id) as "Total Utilizadores" ,cod_concelho as Concelho from Utilizador
Left join CodigoPostal
ON Utilizador.cod_id=CodigoPostal.cod_id
group by cod_concelho
order by cod_concelho desc; 

/* 9-Número de Ciclovias por cidade*/
select count(cic_id) as "Ciclovias" ,cic_cidade as Cidade 
from ciclovia
group by cic_cidade
order by cic_cidade desc;

/* 10-Total de ciclovias por categoria*/
select cc_nome as 'Categoria de Ciclovia',count(cc_id) as 'Nº Total de Ciclovias' 
from categoriaciclovia
group by cc_id;

/* 11-Visualizar Media de Avaliacoes para Ciclovia */		
SELECT cic_id,avg(escav_avaliacao) as MediaAvaliacoes 
from avaliacao
Inner join  Escala_avaliacao 
ON avaliacao.escav_id=Escala_avaliacao.escav_id
group by avaliacao.cic_id
order by avaliacao.cic_id;

/* 12-Visualizar quantos utilizadores existem do genero feminino e masculino */
select uti_genero as "Genero",count(uti_id) as "Total Utilizadores" from utilizador
where uti_genero="M" or uti_genero="F"
group by uti_genero;

/* 13-Utilizador com mais Veículos */ 
select  count(*) as "Veículos", uti_nome as "Nome", Utilizador.uti_id as "ID Utilizador"
from Veiculo ,Utilizador 
where Veiculo.uti_id = Utilizador.uti_id
group by uti_nome
order by 1 desc
limit 1;

/* Having*/

/* 14-Vizualizar codigo postal com mais veiculos*/
select cod_id_4d as 'Codigo4d',cod_id_3d as 'Codigo3d',count(vei_id) as 'Total de veiculos'
from CodigoPostal, veiculo
where vei_id = CodigoPostal.cod_id
group by vei_id
having max(vei_id);

/* 15-Visualizar Concelhos com 3 ou mais pessoas */
select count(u.uti_id) as "Numero",cod_concelho
from utilizador u ,CodigoPostal cod
where u.uti_id = cod.cod_id
group by cod.cod_concelho
having count(u.uti_id) >= 3;











