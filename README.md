# GPSCiclovias



## Autores:

| Número | Nome |
|--------|------|
|  20190796  | Tomás Bourdain da Gama |
|  20190848  | João Ricardo Belo |
|  20190812  | João Pedro André |

## Enquadramento
  Cada vez estão a ser construídas mais ciclovias em Lisboa, sendo este um dos grandes investimentos da Câmara Municipal. O objetivo desta medida é reduzir a quantidade de carros em circulação na cidade. De acordo com a ONU, a bicicleta é o veículo mais rápido e prático para percursos de até 6 quilómetros de distância. O uso da bicicleta também contribui para reduzir as emissões de CO2, para além de favorecer o exercício físico e, logo, a saúde. Pensando nos Objetivos Sustentáveis da ONU, o uso da bicicleta nas cidades contribui para ter cidades e comunidades mais sustentáveis (objetivo 11), para o combate às alterações climáticas (objetivo 13) e indiretamente para a proteção da vida terrestre (objetivo 15).\
  O crescimento das ciclovias tem levado a um aumento dos seus utilizadores na cidade de Lisboa. No entanto, sendo a maioria das ciclovias na cidade relativamente recente, existe algum desconhecimento relativamente aos possíveis percursos. Tendo identificado esta falta de informação como problema, decidimos combatê-la através do projeto GPSCiclovias.
  O nosso projeto GPSCiclovias tem como objetivo criar uma aplicação para o telemóvel que facilite a deslocação das pessoas nas ciclovias através de meios não poluentes, incentivando o uso dos mesmos. Para isso, fornece ao utilizador alternativas de caminhos até ao seu destino. Ao reduzir o tráfego automóvel, irá gradualmente diminuir as emissões de CO2 por parte da nossa comunidade. Sendo Lisboa a Capital Verde Europeia de 2020, tentamos através desta aplicação fazer o nosso papel para a aproximação de Lisboa a uma cidade mais verde e sustentável, com uma menor emissão de gases poluentes, melhorando assim a qualidade de vida da população e tornando a cidade mais atrativa para os turistas.\
  Este projeto será desenvolvido ao longo do semestre no âmbito de uma iniciativa de Project Base Learning que interliga as Unidades Curriculares de Bases de Dados, Programação Orientada por Objetos e Competências Comunicacionais do segundo ano da Licenciatura de Informática de Gestão.\
  Um exemplo de persona seria o João, o João reside na cidade de Lisboa e possui uma bicicleta convencional. O João pretende ir ás compras, e planeia ir de bicicleta para evitar o trânsito. Através do uso da nossa aplicação, consegue consultar uma lista de ciclovias ou planear um itinerário de forma a chegar ao seu destino.\
  Outro caso é o André, o André utiliza a bicicleta como meio de deslocação para ir para o trabalho, mas usufrui da estrada como via de deslocação, pondo em risco a sua vida. Um dia o André ganha o conhecimento da nossa aplicação e usa a de modo a planear um itinerário desde sua casa até ao trabalho passando a servir se de uma via de deslocação segura, a ciclovia.
  
Descrever o contexto em que o projeto está inserido:
- https://shifter.sapo.pt/2020/05/ciclovias-pt-mapa/
- http://www.ciclovia.pt/index.html
- https://lisbonbikemap.com/pt/mapa/ciclovias/

## Casos de utilização:
(substituir todo o texto pelo vosso) \
Definir 3 casos de utilização (o primeiro deve ser core) cada um com o template mostrado em baixo. \
Cada caso de uso tem um nome, uma descrição, pré-condições (pode-se omitir se vazio), passsos e pós-condições (pode-se omitir se vazio)

### Introduzir Destino 
**Descrição:** \
 Através deste Caso de Uso, o utilizador da nossa aplicação pode inserir o seu destino. Recebendo depois a indicação do melhor\
caminho até à mesma.

**Pré-condições:**
- Já se ter autenticado no sistema 
- Ter inserido a sua localização
- Ter disponibilizado a sua localização   

**Passo a passo:**
1. O utilizador indica a sua localização ou disponibiliza a mesma.
2. O utilizador indica o seu destino.
3. A aplicação mostra ao utilizador o melhor caminho até ao seu destino.

**Pós-condições:**
- O caminho é definido pela aplicação 
- A aplicação indica quanto tempo demorará aproximadamente a viagem


### Autorizar o acesso à localização
**Descrição:** \
 O utilizador permite o uso da localização, de modo a planear o seu itinerário.

**Pré-condições:**
- O utilizador autenticou-se no sistema.

**Passo a passo:**
1. Apresenta um pedido de acesso à localização.
2. A localização pretendida é inserida.

**Pós-condições:**
- A localização é fornecida ao sistema.

### Disponibilizar Mapa de Ciclovias
**Descrição:** \
A aplicação disponibiliza ao utilizador um mapa com os diferentes tipos de ciclovias na área de Lisboa.

**Pré-condições:**
- O utilizador autenticou-se no sistema. 

**Passo a passo:**
1. Disponibilizado um mapa dos diferentes tipos de ciclovias.
1. O utilizador consulta o mapa.

**Pós-condições:**
- NA


## Referências:
(substituir todo o texto pelo vosso) \
Usar a norma APA. Para o caso de sites podem usar: \
[1] Autor, A.A. (2000). Título do documento. Acedido em: dia, mês, ano, em: URL. \
(Ano/autor podem ser removidos se não fizerem sentido para o site, o resto é obrigatório)
