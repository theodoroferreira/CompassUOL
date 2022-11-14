Avaliação Sprint 3 
Theodoro Gaspar Ferreira

Questão 1:

Nota: tentei fazer um filtro em que o usuário digitasse na url, por exemplo, `/api/states?regiao=NORTE` para listar apenas os estados daquela região, entretanto, após muitas tentativas, não consegui codar uma lógica para tal filtro e acabei usando outra estratégia que segue abaixo.

- Filtro regiões:
Se o usuário usar o endpoint GET - `/api/states`, a API devolverá um JSON em que os Estados estão *ordenados* por região, mas não separados.

- Filtro população:
Se o usuário usar o endpoint GET - `/api/states?sort=populacao,desc`, a API devolverá um JSON em que os Estados estão *ordenados* por população em ordem descrescente.

- Filtro área:
  Se o usuário usar o endpoint GET - `/api/states?sort=area,desc`, a API devolverá um JSON em que os Estados estão *ordenados* por área em ordem descrescente.

Os demais endpoints estão de acordo com o que foi requisitado.