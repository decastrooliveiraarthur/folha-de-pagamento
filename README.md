# Sistema de Folha de Pagamento (Java)

Aplicação de console em Java para cadastrar funcionários de três tipos diferentes e gerar a folha de pagamento com o
salário final de cada um e o total geral.

Projeto desenvolvido na faculdade, focado em **Programação Orientada a Objetos**: herança, polimorfismo, encapsulamento
e separação de responsabilidades.

## Funcionalidades

- Cadastro de funcionário **Padrão**, **Comissionado** e de **Produção**
- Validação de todas as entradas do usuário, com nova tentativa em caso de erro
- Matrícula única: não é possível cadastrar duas matrículas iguais
- Geração da folha de pagamento com os dados de cada funcionário, a quantidade cadastrada e a soma total dos salários

## Regras de cálculo

Todos os funcionários partem de um **salário base de R$ 2.000**.

| Tipo         | Fórmula do salário final                                |
|--------------|---------------------------------------------------------|
| Padrão       | `salário base`                                          |
| Comissionado | `salário base + (total de vendas × percentual / 100)`   |
| Produção     | `salário base + (quantidade de peças × valor por peça)` |

## Regras de validação

| Campo                  | Regra                                   |
|------------------------|-----------------------------------------|
| Opção do menu          | Inteiro de 0 a 4                        |
| Nome                   | Apenas letras e espaços, não vazio      |
| Matrícula              | Inteiro positivo e ainda não cadastrado |
| Total de vendas        | Inteiro maior ou igual a 0              |
| Percentual de comissão | Número de 0 a 100                       |
| Quantidade de peças    | Inteiro maior ou igual a 0              |
| Valor por peça         | Número maior ou igual a 0               |

> Os números decimais devem ser digitados com **vírgula** (ex.: `2,5`), pois a leitura usa o padrão brasileiro
> (`pt-BR`).

## Como executar

Requisito: **JDK 8 ou superior**.

**Pelo terminal:**

```bash
# clonar o repositório
git clone https://github.com/decastrooliveiraarthur/folha-de-pagamento.git
cd folha-de-pagamento

# compilar
javac -encoding UTF-8 -d out src/*.java

# executar
java -cp out Main
```

Se os acentos aparecerem errados no terminal (comum no Windows), execute com `java -Dfile.encoding=UTF-8 -cp out Main`.

**Pelo IntelliJ IDEA:**

1. Abra a pasta do projeto no IntelliJ IDEA.
2. Execute a classe `Main.java`.
3. Siga o menu no console.

## Exemplo de uso

Entradas: cadastro de um funcionário de cada tipo, geração da folha e saída.

```text
==================MENU==================
1 - Cadastrar Funcionário Padrão
2 - Cadastrar Funcionário Comissionado
3 - Cadastrar Funcionário de Produção
4 - Gerar Folha de Pagamento
0 - Sair do Programa
========================================
```

Folha gerada com três funcionários:

```text
Exibindo Folha de Pagamento
-------------------------------------------------------------
Padrao:
Nome: Ana Silva
Matrícula: 1
Salário Final: R$2000.0
-------------------------------------------------------------
Comissionado:
Nome: Bruno
Matrícula: 2
Valor total das vendas: R$10000
Percentual de comissão: 5.0%
Comissão: R$500.0
Salário final: R$2500.0
-------------------------------------------------------------
Producao:
Nome: Carla
Matrícula: 3
Quantidade de peças produzidas: 100
Valor de cada peça produzida: R$2.5
Bônus: R$250.0
Salário final: R$2250.0
-------------------------------------------------------------
Total de funcionários cadastrados: 3
Soma total dos salários finais de todos os funcionários: R$6750.0
-------------------------------------------------------------
```

## Estrutura do projeto

```text
src/
├── Main.java          # Ponto de entrada
├── Menu.java          # Entrada e saída: exibe o menu, lê e valida os dados digitados
├── Folha.java         # Controla o fluxo do programa, guarda os funcionários e gera a folha
├── Funcionario.java   # Classe abstrata base (nome, matrícula, salário base)
├── Padrao.java        # Funcionário com salário fixo
├── Comissionado.java  # Funcionário com comissão sobre vendas
└── Producao.java      # Funcionário pago por peças produzidas
```

## Conceitos aplicados

- **Classe abstrata e herança:** `Funcionario` define o contrato (`calcularSalario()`), e cada tipo de funcionário o
  implementa à sua maneira.
- **Polimorfismo:** a folha trabalha com uma `List<Funcionario>` e calcula o salário de qualquer tipo sem precisar saber
  qual é.
- **Encapsulamento:** atributos `private final` (objetos imutáveis após a criação) e valores como comissão e bônus
  calculados sob demanda, sem estado redundante.
- **Separação de responsabilidades:** `Menu` cuida da interação com o usuário, `Folha` das regras do fluxo e as classes
  de funcionário do modelo de dados.
- **Tratamento de entrada:** validação com `Scanner`, laços de repetição até o dado ser válido e configuração explícita
  de `Locale`.

## Possíveis melhorias

- Usar `BigDecimal` para valores monetários, evitando imprecisão de ponto flutuante, e formatar a saída como moeda
  (`R$ 2.000,00`)
- Aceitar centavos no total de vendas (hoje é um inteiro)
- Mover as validações de domínio também para os construtores das classes
- Tratar o fim da entrada padrão (Ctrl+D) sem encerrar com exceção
- Persistir os funcionários em arquivo ou banco de dados
- Adicionar testes automatizados com JUnit

## Autor

Arthur de Castro Oliveira
