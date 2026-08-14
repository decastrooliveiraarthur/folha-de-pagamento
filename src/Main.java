import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static List<Funcionario> funcionarioList = new ArrayList<>();

    public static void main(String[] args) {

        boolean continuar = true;

        Menu menu = new Menu();

        while (continuar) {

            menu.validarOpcao();

            switch (menu.opcao) {
                case 1:

                    Funcionario funcionario = new Funcionario();

                    funcionario.validarNome();
                    funcionario.validarMatricula();
                    funcionario.calcularSalario();
                    funcionarioList.add(funcionario);
                    System.out.println("Funcionário cadastrado");

                    break;
                case 2:

                    Comissionado comissionado = new Comissionado();

                    comissionado.validarNome();
                    comissionado.validarMatricula();
                    comissionado.validarVendas();
                    comissionado.validarPercentual();
                    comissionado.calcularSalario();
                    funcionarioList.add(comissionado);
                    System.out.println("Funcionário cadastrado");

                    break;
                case 3:

                    Producao producao = new Producao();

                    producao.validarNome();
                    producao.validarMatricula();
                    producao.validarQuantidadeProduzida();
                    producao.validarValorPorPeca();
                    producao.calcularSalario();
                    funcionarioList.add(producao);
                    System.out.println("Funcionário cadastrado");

                    break;
                case 4:

                    if (!funcionarioList.isEmpty()) {

                        System.out.println("\nExibindo Folha de Pagamento");
                        System.out.println("-------------------------------------------------------------");

                        for (Funcionario f : funcionarioList) {

                            System.out.println("Nome: " + f.getNome());
                            System.out.println("Matrícula: " + f.getMatricula());

                            if (f instanceof Comissionado c) {

                                System.out.println("Valor total das vendas: R$" + c.getVendas());
                                System.out.println("Percentual de comissão: " + c.getPercentual() + "%");
                                System.out.println("Salário base: R$" + c.getSalarioBase());
                                System.out.println("Comissão: R$" + c.getComissao());
                                System.out.println("Salário final:  R$" + c.getSalarioFinal());

                            } else if (f instanceof Producao p) {

                                System.out.println("Quantidade de peças produzidas: " + p.getQuantidadeProduzida());
                                System.out.println("Valor de cada peça produzida: R$" + p.getValorPorPeca());
                                System.out.println("Salário base: R$" + p.getSalarioBase());
                                System.out.println("Bônus: R$" + p.getBonus());
                                System.out.println("Salário final:  R$" + p.getSalarioFinal());

                            } else {

                                System.out.println("Salário base: R$" + f.getSalarioBase());
                                System.out.println("Salário final:  R$" + f.getSalarioFinal());
                            }

                            System.out.println("-------------------------------------------------------------");
                        }

                        double somaSalario = 0;

                        for (Funcionario f : funcionarioList) {
                            somaSalario += f.getSalarioFinal();
                        }

                        System.out.println("Total de funcionários cadastrados: " + funcionarioList.size());
                        System.out.println("Soma total dos salários finais de todos os funcionários: R$" + somaSalario);
                        System.out.println("-------------------------------------------------------------");

                    } else {

                        System.out.println("Nenhum funcionário cadastrado");

                    }

                    break;
                case 0:

                    continuar = false;

                    break;
                default:

                    System.out.println("Opção inválida. Digite um número entre 0 e 4");

                    break;
            }
        }

        System.out.println("Sistema Encerrado");
    }

    public static class Funcionario {

        protected static final int SALARIO_BASE = 2000;
        private static final String REGEX_NOME = "^[\\p{L} ]+$";
        protected double salarioFinal = 0;
        private String nome = "";
        private int matricula = 0;

        public void validarNome() {
            while (true) {
                System.out.println("Digite o nome do funcionário:");
                this.nome = sc.nextLine().trim();
                if ((this.nome.isEmpty()) || (!this.nome.matches(REGEX_NOME))) {
                    System.out.println("Nome inválido. Tente novamente usando apenas letras");
                } else {
                    break;
                }
            }
        }

        public void validarMatricula() {
            while (true) {
                boolean matriculaExiste = false;
                System.out.println("Digite a matrícula do funcionário:");
                if (sc.hasNextInt()) {
                    this.matricula = sc.nextInt();
                    sc.nextLine();
                    for (Funcionario f : funcionarioList) {
                        if (this.matricula == f.getMatricula()) {
                            matriculaExiste = true;
                            break;
                        }
                    }
                    if ((this.matricula <= 0) || (matriculaExiste)) {
                        System.out.println("Matricula inválida ou repetida. Tente novamente usando apenas um número inteiro positivo");
                    } else {
                        break;
                    }
                } else {
                    System.out.println("Matricula inválida ou repetida. Tente novamente usando apenas um número inteiro positivo");
                    sc.next();
                    sc.nextLine();
                }
            }
        }

        public void calcularSalario() {
            this.salarioFinal = SALARIO_BASE;
        }

        public String getNome() {
            return nome;
        }

        public int getMatricula() {
            return matricula;
        }

        public double getSalarioFinal() {
            return salarioFinal;
        }

        public int getSalarioBase() {
            return SALARIO_BASE;
        }
    }

    public static class Comissionado extends Funcionario {

        private double vendas = 0;
        private double percentual = 0;
        private double comissao = 0;

        public void validarVendas() {
            while (true) {
                System.out.println("Digite o valor total das vendas do funcionário:");
                if (sc.hasNextDouble()) {
                    this.vendas = sc.nextDouble();
                    sc.nextLine();
                    if (this.vendas < 0) {
                        System.out.println("Valor total das vendas inválido. Tente novamente usando apenas um número positivo");
                    } else {
                        break;
                    }
                } else {
                    System.out.println("Valor total das vendas inválido. Tente novamente usando apenas um número positivo");
                    sc.next();
                    sc.nextLine();
                }
            }
        }

        public void validarPercentual() {
            while (true) {
                System.out.println("Digite o percentual de comissão do funcionário:");
                if (sc.hasNextDouble()) {
                    this.percentual = sc.nextDouble();
                    sc.nextLine();
                    if ((this.percentual < 0) || (this.percentual > 100)) {
                        System.out.println("Percentual de comissão inválido. Tente novamente usando apenas um número positivo de 0 até 100");
                    } else {
                        break;
                    }
                } else {
                    System.out.println("Percentual de comissão inválido. Tente novamente usando apenas um número positivo de 0 até 100");
                    sc.next();
                    sc.nextLine();
                }
            }
        }

        @Override
        public void calcularSalario() {
            this.comissao = (this.vendas * this.percentual / 100);
            this.salarioFinal = SALARIO_BASE + this.comissao;
        }

        public double getVendas() {
            return vendas;
        }

        public double getPercentual() {
            return percentual;
        }

        public double getComissao() {
            return comissao;
        }
    }

    public static class Producao extends Funcionario {

        private int quantidadeProduzida = 0;
        private double valorPorPeca = 0;
        private double bonus = 0;

        public void validarQuantidadeProduzida() {
            while (true) {
                System.out.println("Digite a quantidade de peças produzidas pelo funcionário:");
                if (sc.hasNextInt()) {
                    this.quantidadeProduzida = sc.nextInt();
                    sc.nextLine();
                    if (this.quantidadeProduzida < 0) {
                        System.out.println("Quantidade de peças produzidas inválida. Tente novamente usando apenas um número inteiro positivo");
                    } else {
                        break;
                    }
                } else {
                    System.out.println("Quantidade de peças produzidas inválida. Tente novamente usando apenas um número inteiro positivo");
                    sc.next();
                    sc.nextLine();
                }
            }
        }

        public void validarValorPorPeca() {
            while (true) {
                System.out.println("Digite o valor de cada peça produzida pelo funcionário:");
                if (sc.hasNextDouble()) {
                    this.valorPorPeca = sc.nextDouble();
                    sc.nextLine();
                    if (this.valorPorPeca < 0) {
                        System.out.println("Valor de cada peça produzida inválido. Tente novamente usando apenas um número positivo");
                    } else {
                        break;
                    }
                } else {
                    System.out.println("Valor de cada peça produzida inválido. Tente novamente usando apenas um número positivo");
                    sc.next();
                    sc.nextLine();
                }
            }
        }

        @Override
        public void calcularSalario() {
            this.bonus = (this.valorPorPeca * this.quantidadeProduzida);
            this.salarioFinal = (SALARIO_BASE + this.bonus);
        }

        public int getQuantidadeProduzida() {
            return quantidadeProduzida;
        }

        public double getValorPorPeca() {
            return valorPorPeca;
        }

        public double getBonus() {
            return bonus;
        }
    }

    public static class Menu {

        private int opcao = 0;

        public void validarOpcao() {
            while (true) {
                System.out.println("\n==================MENU==================");
                System.out.println("1 - Cadastrar Funcionário Padrão");
                System.out.println("2 - Cadastrar Funcionário Comissionado");
                System.out.println("3 - Cadastrar Funcionário de Produção");
                System.out.println("4 - Gerar Folha de Pagamento");
                System.out.println("0 - Sair do Programa");
                System.out.println("========================================");
                if (sc.hasNextInt()) {
                    this.opcao = sc.nextInt();
                    sc.nextLine();
                    if ((this.opcao < 0) || (this.opcao > 4)) {
                        System.out.println("Opção inválida. Digite um número entre 0 e 4");
                    } else {
                        break;
                    }
                } else {
                    System.out.println("Opção inválida. Digite um número entre 0 e 4");
                    sc.next();
                    sc.nextLine();
                }
            }
        }
    }
}
