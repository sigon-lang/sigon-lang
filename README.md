# Sigon 

Sigon is a framework for the development of agents as multi-context systems.
It is generic and extensible in the sense that it allows modeling agents according to existing architectures or to create new ones, as well as to extend an agent construction with additional features through other contexts and bridge rules.


## Quick Build


  - Java v8 or higher 
  - Maven 3
  - Eclipse
  - Lombok : https://projectlombok.org/

### Setup

```sh
$ cd  agent-project 
$ mvn clean install
```

We recommend Eclipse for development.
To import the project: File > Import > Existing Mavem Projects, select the root folder.

### Grammar class generation

_The command clean install will generate, but with the goal antlr4 it will be forced_


```sh
$ mvn antlr4:antlr4 
```
The generated class are in target/generated-sources/java 


## How to create a executable file

```sh
$ mvn clean package assembly:single
```

```sh
 java -jar agent-parser-jar-with-dependencies.jar filename 
```

## Contributing 


### With development

1. Creating a fork from master
2. Making and Submitting Changes
3. Submit a pull request to the repository

### With ideas

1. Creating an issue





