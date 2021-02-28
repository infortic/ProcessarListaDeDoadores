# Processar Lista de Possíveis Doadores

Solucão crianda para processar e extrair informações .

### Informações Adicionais

Uma agência de banco de sangue forneceu uma lista de candidatos a doadores e precisa de um sistema<br/>
que processe esses dados para extrair algumas informações. <br/>
Implemente um sistema web que receba um JSON com os dados e mostre os seguintes resultados:<br/><br/>
• Quantos candidatos temos nessa lista em cada estado do Brasil?<br/>
• IMC médio em cada faixa de idade de dez em dez anos: 0 a 10; 11 a 20; 21 a 30, etc. (IMC = peso /
altura^2)<br/>
• Qual o percentual de obesos entre os homens e entre as mulheres? (É obeso quem tem IMC >30)<br/>
• Qual a média de idade para cada tipo sanguíneo?<br/>
• A quantidade de possíveis doadores para cada tipo sanguíneo receptor.<br/><br/>


ATENÇÃO: Somente pessoas com idade de 16 a 69 anos e com peso acima de 50 Kg podem doar sangue. 

### Solução:

Para cada resultado esperado foi criando um endPoint que recebe uma lista de possiveis doadores e processa a mesma e retorna o resultado esperado.

* veja como subir o projeto e estar os endPoints um pouco mais a baixo.


## Executando e testando o projeto

### Pré-requisitos
* Java 8
* Mave


### Passo a passo

`Ultilize esta linha de código para baixar a branch da aplicação`

`git clone https://github.com/infortic/ProcessarListaDeDoadores.git`

### Buildar e executar a aplicação

Dentro do diretório root da aplicação executar os passos abaixo.

2.a - Para buildar a aplicação:
` mvn clean install #buildando o pacote da aplicação`

a linha de código a cima criara uma pasta chamada `target` com a versão final da aplicação.

2.b Para executar a aplicação:

` java -jar ProcessaListaDeDoadores-0.0.1.jar`

A partir deste ponto se tudo ocorrer corretamente a aplicação estará rodando 
e atendendo requisições através da porta cadastrada no arquivo `application.yml` (se não foi alterado estará na porta 5001).

É possível utilizar o client do swagger através da url [http://localhost:5001/swagger-ui.html], possibilitando a verificação dos endpoints, dos DTOs esperados, e até mesmo realizar testes de requisições. 

#### 4 - Executando Testes Automatizados
` mvn test #Dentro do pacote da aplicação para executar os testes automatizados`
