<h1> Projeto Pessoa Api </h1>

para rodar o projeto é necessario fazer download ou git clone 

## Requisitos do projeto 

	é necessario que uma pessoa tenha todos esses dados que esta em Json
	e mais de um endereço vinculado a uma pessoa 
	e informar endereço principal dessa pessoa
	projeto em construção utilizando Java 17
  
pom.xml maven
contém todas dependencias utilizadas no projeto 
que são 

JPA
Lombok 
H2
Validation
DevTools
start web

todas informações necessarias para acessar o banco de dados H2 em memoria está no 
resource 
> application.properties 


Collection Postman contem 

Get EnderecoPessoaId 
Get ListarPessoa (ok)
Get ConsultarPessoaId
Put Endereco
Put EditarPessoa (ok) 
Post SalvarPessoa(cadastra) (ok)
Post SalvarEnderecoPessoa(cadastra) (ok)

nem todas funcionalidades estão funcionando ainda falta o relacionamento entre as tabelas no h2 
projeto em desenvolvimento os que tão ok, é que ja foram testados 
projeto ainda falta os testes e Exception



