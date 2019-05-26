# starwars_complete
Desafio Star Wars - May the force be with you!

     Star Wars:
	 
A Jedi uses the Force for knowledge and defense, never for attack.	 

O medo é o caminho para o lado negro. Treine a si mesmo a deixar partir tudo que teme perder. Faça ou não faça.

Para Rodar o meu projeto:

1º fazer o Download do meu projeto aqui no meu GitHub.

2° Fazer o import do meu projeto para a sua IDE  (Existing Projects into Workspace).

3º Esperar carregar todas as dependências - Por conta do maven.

4º Antes de startar o projeto, primeiro deve inicializar o banco mongoDB.

4.1 - Vai até o diretório: (exemplo) -  C:\Program Files\MongoDB\Server\4.0\bin 

4.2 - copia o caminho, abra o seu cmd e digite: cd C:\Program Files\MongoDB\Server\4.0\bin

4.3 - Confere se o mongod.exe existe no caminho passado, se for Windows use comando 'dir' ou 'ls' se for linux.

4.4 - depois de conferir, digite: mongod.exe 

5° Agora você pode startar o projeto - dentro de um servlet - no caso do spring boot ele já vem com um [tomcat].

6° Agora é testar a minha API starwars :) - Eu usei o POSTMAN.

7° Será necessário mexer no authorization colocando o Username: user , Passaword: password - Para consultar a minha API

- Buscar todos os planetas da API star Wars -  Adicionei uma variável para saber a quantidade de filmes. 
GET: localhost:8080/api/planetsAPI

- Cadastrando um planeta
POST: localhost:8080/api/

{
	
	"name": "name1",
	"climate": "climate1",
	"terrain": "terrain1"
	
}


- Atualizando um planeta - usando um ID do planeta
PUT: localhost:8080/api/5ceab7aede15e135b0251803

{
	
	"name": "name1update",
	"climate": "climate1",
	"terrain": "terrain1"
	
}

- Buscar todos os planetas do Banco de Dados
GET: localhost:8080/api/planetsDB

- Deletando um planeta, usando um ID de um planeta
DELETE: localhost:8080/api/5ceab798de15e135b0251802

- Buscando um planeta por ID no banco de dados
GET: localhost:8080/api/5ceab7aede15e135b0251803

- Buscando um planeta por nome no banco de dados
GET: localhost:8080/api/search/name1


May the force be with you!
 
