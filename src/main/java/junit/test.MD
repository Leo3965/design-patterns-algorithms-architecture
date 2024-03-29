### Tipos de Testes

**Teste de Integração**

1. dbunit.sourceforge.net (banco de dados)

**Teste de aceitação (E2E)**

1. www.seleniumhq.org

**Testes de carga**

1. jmeter.apache.org

**Testes Unitários**

1. junit.org
2. AssertJ

## Hierarquia de Testes

![img](../../../../files/imgs/test.png)

- Testes manuais demoram e são chatos
- Agiliza o teste de uma aplicação
- Evita que bugs ocorram ao alterar o código
- Documenta as funcionalidades do sistema, assim como as regras
- O testes dão mais segurança para refatoramento

### O Princípio FIRST

1. Fast: Teste unitários devem ser rápidos (segundos/milisegundos)
2. Independent: Testes unitários devem ser indepentes
3. Repeatable: Testes unitários devem permitir repetição
4. Self-validating: Testes devem ter autoavaliação
5. Timely: Testes devem ser escritos junto ao desenvolvimento
6. Thorough: Testes devem ser minuciosos

### Padrão Triple A

- Arrange (Prepara)
- Act     (Executa)
- Assert  (Verifica)

### Nomenclatura BDD

> Behaviour Driven Development

- Given
- When
- Then

É uma boa prática seguir esse modelo ao nomear um test unitário

### Design Pattern Object Mother

> Design muito utilizado em testes

#### Ferramentas de análise de cobertura

- Intellij
- Jaccoco (Java Code Coverage Library)

![img](../../../../files/imgs/analise-teste-unit.png)
![img](../../../../files/imgs/metricas-relatorios-unit.png)

### AssertJ

- Melhora a legibilidade do código de teste
- Forcene um diverso conjunto de asserções
- Mensagens de erro mais detalhadas e customizáveis

#### Módulos

1. Core
2. Guava
3. Joda Time
4. Neo4j
5. Database
6. Swing

### TDD (Test Driven Development)
![tdd](../../../../files/imgs/tdd-cycle.png)

