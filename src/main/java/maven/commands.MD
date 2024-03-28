

| Comando                                  | Descrição                                  |
|------------------------------------------|--------------------------------------------|
| mvn validate                             | Valida arquivo pom.xml                     |
| mvn dependency:resolve                   | Faz o download das dependências do projeto |
| mvn compile                              | Gera os arquivos java em class - (target)  |
| mvn verify                               | Compila projeto                            |
| mvn package                              | Gera arquivo JAR                           |
| mvn install                              | Joga o seu projeto na pasta .m2            |
| mvn clean                                | Limpa a pasta target                       |
| mvn test                                 | Realiza tests unitários                    |
| mvn clean package -Dmaven.test.skip=true | Realiza o build sem testes                 |
| mvn test jacoco:report                   | Relatório do Jacoco                        |
