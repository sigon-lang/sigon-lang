# Sigon Agent

## Ambiente de desenvolvimento

Para manter e desenvolver o projeto é necessário ter as seguintes tecnologias instaladas:

  - Java versão 8 ou superior 
  - Maven 3
  - Eclipse
  - Lombok : https://projectlombok.org/
Como como compilar o projeto:

```sh
$ cd  agent-project 
$ mvn clean install
```
_Obs: A IDE utilizada para o desenvolvimento é o Eclipse, para importar o projeto : File > Import > Existing Mavem Projects, selecionar o diretório do projeto e fazer a importação._

## Gerar as classes da gramática

_O comando clean install já deve gerar as classes, o objetivo de usar o goal antlr4 é forçar a geração_


```sh
$ mvn antlr4:antlr4 
```
O pacote gerado fica disponível para ser usado no projeto de forma automática. As classes geradas ficam em target/generated-sources/java 


## Como gerar um arquivo executável

```sh
$ mvn clean package assembly:single
```
Após a geração basta entrar na pasta target e executar o comando para rodar o interpretador:

```sh
 java -jar agent-parser-jar-with-dependencies.jar filename 
```

## Como contribuir 


### Com código

1. Crie um fork do master
2. Implemente uma atualização
3. Seja descritivo nos commits. Se for de uma issue, coloque o número
4. Faça pull request para o branch Master

### Com ideias

1. Crie uma issue com etiqueta





