# GPSCiclovias



## Autores:

| Número | Nome |
|--------|------|
|  20190796  | Tomás Bourdain da Gama |
|  20190848  | João Ricardo Belo |
|  20190812  | João Pedro André |

Documentação REST disponível neste link:
https://docs.google.com/document/d/1UxPuBFXYXmgtk2fjNHi-jz9vmhUTPk2k8fgwjr9EnLw/edit?usp=sharing

## Enquadramento
  Cada vez estão a ser construídas mais ciclovias em Lisboa, sendo este um dos grandes investimentos da Câmara Municipal. O objetivo desta medida é reduzir a quantidade de carros em circulação na cidade. De acordo com a ONU, a bicicleta é o veículo mais rápido e prático para percursos de até 6 quilómetros de distância. O uso da bicicleta também contribui para reduzir as emissões de CO2, para além de favorecer o exercício físico e, logo, a saúde. Pensando nos Objetivos Sustentáveis da ONU, o uso da bicicleta nas cidades contribui para ter cidades e comunidades mais sustentáveis (objetivo 11), para o combate às alterações climáticas (objetivo 13) e indiretamente para a proteção da vida terrestre (objetivo 15).\
  O crescimento das ciclovias tem levado a um aumento dos seus utilizadores na cidade de Lisboa. No entanto, sendo a maioria das ciclovias na cidade relativamente recente, existe algum desconhecimento relativamente aos possíveis percursos. Tendo identificado esta falta de informação como problema, decidimos combatê-la através do projeto GPSCiclovias.
  O nosso projeto GPSCiclovias tem como objetivo criar uma aplicação para o telemóvel que facilite a deslocação das pessoas nas ciclovias através de meios não poluentes, incentivando o uso dos mesmos. Para isso, fornece ao utilizador alternativas de caminhos até ao seu destino. Ao reduzir o tráfego automóvel, irá gradualmente diminuir as emissões de CO2 por parte da nossa comunidade. Sendo Lisboa a Capital Verde Europeia de 2020, tentamos através desta aplicação fazer o nosso papel para a aproximação de Lisboa a uma cidade mais verde e sustentável, com uma menor emissão de gases poluentes, melhorando assim a qualidade de vida da população e tornando a cidade mais atrativa para os turistas.\
  A falta de conhecimento das localizações das ciclovias está na origem da utilização reduzida das mesmas em Portugal. Temos visto um surgimento crescente do número de ciclovias, e embora este seja um passo importante, é também crucial informar os residentes para que estes possam usufruir das mesmas. A nossa aplicação tem como objetivo informar os seus utilizadores das ciclovias existentes assim como uma descrição das mesmas na qual iram encontrar associados uma classficação, o relevo da mesma, o seu ponto de início e de fim, a sua extensão, trajeto e respetivos pontos de interesse. É possível, através da aplicação, a consulta de ciclovias e assim a escolha do melhor caminho por parte de cada utilizador, seja esse a combinação de multiplas ciclovias ou o uso de um pequeno troço de uma só. Assim permite-lhes planear antecipadamente o seu caminho, diminuindo o tempo necessário para fazer o percurso, aumentanto a acessibilidade das mesmas. É permitido ainda a quem utiliza a aplicação guardar percursos para que os possa repetir caso o deseje, ou até mesmo partilhá-los, aumentando ultimamente o número de utilizadores
  
  
- https://shifter.sapo.pt/2020/05/ciclovias-pt-mapa/
- http://www.ciclovia.pt/index.html
- https://lisbonbikemap.com/pt/mapa/ciclovias/


## Casos de utilização: 

### Consultar Lista de Ciclovias
**Descrição:** 
Esta opção permite ao utilizador consultar a lista onde estão inseridas as ciclovias. \

**Pré-condições:**
- Autenticado no sistema 

**Passo a passo:**
1. O utilizador encontra-se no menu inicial.
2. O utilizador escolhe a opção Consultar Lista de Ciclovias

**Pós-condições:**
- É disponibilizada uma lista onde estão contidas todas as ciclovias


### Escolher Ciclovia
**Descrição:** 
 Após consultar a Lista de Ciclovias, o utilizador da nossa aplicação consegue escolher uma, de modo a conhecer os seus detalhes (trajeto, extensão, relevo, descrição, pontos de interesse). 

**Pré-condições:**
- Autenticado no sistema 
- Consultado a Lista de Ciclovias   

**Passo a passo:**
1. O utilizador seleciona a opção Consultar Lista de Ciclovias
2. O utilizador após selecionar a opção, é apresentada uma Lista de Ciclovias
3. O utilizador escolhe uma ciclovia para conhecer os seus detalhes 
4. O utilizador indica a ciclovia pretendida

**Pós-condições:**
- A ciclovia escolhida é apresentada pela aplicação


### Pesquisar Ciclovias 
**Descrição:** \
O utilizar com a opção "Pesquisar Ciclovias", consegue fazer a filtragem  da sua pesquisa através da extensão, do distrito e da cidade. Na extensão, pode escrever um intervalo de distâncias (em metros) que pretende percorrer numa determinada ciclovia, depois de introduz um valor mínimo e um valor máximo são apresentadas todas as ciclovias que coincidem com o intervalo. No distrito e na cidade apenas é preciso escrever o que deseja e são lhe apresentado todas as ciclovias pertencentes a esses locais.

**Pré-condições:**
- Autenticado no sistema
- Consultado Lista de Ciclovias

**Passo a passo:**
1. O utilizador encontra-se no menu inicial.
2. O utilizador seleciona o menu "Consultar Lista de Ciclovias"
3. O utilizador seleciona a opção "Pesquisar Ciclovias"
4. O utilizador seleciona entre as opções, extensão, distrito e cidade
5. O utilizador escreve o que pretende procurar

**Pós-condições:**
- Apresenta ao utilizador todas as ciclovias que coincidem com a filtragem que fez


### Pesquisar Pontos de Interesse (em desenvolvimento)
**Descrição:** \
O utilizador, através da opção Pesquisar Pontos de Interesse, consegue pesquiar na lista de pontos de interesse o que considera pertinente visitar durante o trajeto na ciclovia. Quando seleciona o ponto de interesse é lhe apresentado todas as ciclovias à menor distância desse ponto.

**Pré-condições:**
- Autenticado no sistema

**Passo a passo:**
1. O utilizador seleciona a opção Pesquisar Pontos de Interesse
2. O utilizador após selecionar a opção, é apresentada uma Lista de Pontos de Interesse
3. O utilizador escolhe um ponto de interesse 


**Pós-condições:**
- Apresenta as ciclovias, com base no ponto de interesse selecionado 


### Pesquisar e Consultar Avaliações 
**Descrição:** \
O utilizar com a opção "Consultar Avaliações" consegue consultar a lista onde estão inseridas todas avaliações atribuidas pelos utilizadores às ciclovias. Com a opção "Pesquisar Avaliações", o utilizador consegue fazer a filtragem  da sua pesquisa através do id das ciclovias e do id dos utilizadores. Apenas é preciso escrever o que deseja e são lhe apresentado todas as avaliações pertencentes a esse utilizador ou ciclovia.

**Pré-condições:**
- Autenticado no sistema
- Consultado Lista de Avaliações

**Passo a passo:**
1. O utilizador encontra-se no menu inicial.
2. O utilizador seleciona o menu "Consultar Lista de Avaliações"
3. O utilizador seleciona a opção "Pesquisar Avaliações"
4. O utilizador seleciona entre as opções, id da ciclovia ou id do utilizador
5. O utilizador escreve o que pretende procurar

**Pós-condições:**
- Apresenta ao utilizador todas as avaliações que coincidem com a filtragem que fez


### Consultar Estatísticas dos utilizadores 
**Descrição:** \
O utilizar com a opção "Atividade" consegue consultar a lista onde estão inseridas todas estatatisticas dos utilizadores como ciclovias percorridas, metros percorridos e veiculos utilizados.

**Pré-condições:**
- Autenticado no sistema

**Passo a passo:**
1. O utilizador encontra-se no menu inicial.
2. O utilizador seleciona o menu "Atividade"

**Pós-condições:**
- Apresenta ao utilizador uma lista de estatisticas dos utilizadores.

## Referências:
1 - “Ciclovias Portugal” ciclovia.pt.[Online].Available: http://www.ciclovia.pt/index.html.[Accessed:28-12-2020][Accessed:30-12-2020] \
2 - “Tipos de Dados no SQL”rlsystem.com.[Online].Available: https://www.rlsystem.com.br/tipos-dados-sql-server/.[Accessed:10-11-2020] \
3 - “SQL Tutorial”w3schools.com[Online].Available: https://www.w3schools.com/sql/default.asp.[Accessed:10-11-2020] \
4 - “O que é um diagrama entidade relacional?”lucidchart.com.[Online].Available: https://www.lucidchart.com/pages/pt/o-que-e-diagrama-entidade-relacionamento.[Accessed:15-11-2020] \
5 - “Ciclovias Portugal” ciclovia.pt.[Online].Available: http://www.ciclovia.pt/index.html.[Accessed:28-12-2020][Accessed:30-12-2020] \
6 - PowerPoints disponibilizados na Unidade Curricular de Programação Orientada por Objetos

