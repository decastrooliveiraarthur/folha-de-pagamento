import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Menu {

    private static final String REGEX_NOME = "^[\\p{L} ]+$";
    private final Scanner scanner = new Scanner(System.in);

    public Menu() {
        scanner.useLocale(Locale.forLanguageTag("pt-BR"));
    }

    public int lerOpcao() {
        while (true) {
            System.out.println("\n==================MENU==================");
            System.out.println("1 - Cadastrar Funcionário Padrão");
            System.out.println("2 - Cadastrar Funcionário Comissionado");
            System.out.println("3 - Cadastrar Funcionário de Produção");
            System.out.println("4 - Gerar Folha de Pagamento");
            System.out.println("0 - Sair do Programa");
            System.out.println("========================================");
            if (scanner.hasNextInt()) {
                int opcao = scanner.nextInt();
                scanner.nextLine();
                if ((opcao < 0) || (opcao > 4)) {
                    System.out.println("Opção inválida. Digite um número entre 0 e 4");
                } else {
                    return opcao;
                }
            } else {
                System.out.println("Opção inválida. Digite um número entre 0 e 4");
                scanner.next();
                scanner.nextLine();
            }
        }
    }


    public String lerNome() {
        while (true) {
            System.out.println("Digite o nome do funcionário:");
            String nome = scanner.nextLine().trim();
            if ((nome.isEmpty()) || (!nome.matches(REGEX_NOME))) {
                System.out.println("Nome inválido. Tente novamente usando apenas letras");
            } else {
                return nome;
            }
        }
    }

    public int lerMatricula(List<Funcionario> funcionarioList) {
        while (true) {
            boolean matriculaExiste = false;
            System.out.println("Digite a matrícula do funcionário:");
            if (scanner.hasNextInt()) {
                int matricula = scanner.nextInt();
                scanner.nextLine();
                for (Funcionario funcionario : funcionarioList) {
                    if (matricula == funcionario.getMatricula()) {
                        matriculaExiste = true;
                        break;
                    }
                }
                if ((matricula <= 0) || (matriculaExiste)) {
                    System.out.println("Matricula inválida ou repetida. Tente novamente usando apenas um número inteiro positivo");
                } else {
                    return matricula;
                }
            } else {
                System.out.println("Matricula inválida ou repetida. Tente novamente usando apenas um número inteiro positivo");
                scanner.next();
                scanner.nextLine();
            }
        }
    }

    public double lerDouble(String prompt, int max) {

        while (true) {

            System.out.println("Digite o/a " + prompt + ":");
            if (scanner.hasNextDouble()) {

                double doubleNum = scanner.nextDouble();
                scanner.nextLine();
                if ((doubleNum < 0) || (max != 0 && doubleNum > max)) {

                    System.out.println(prompt + " inválido/a. Tente novamente usando apenas um número >= 0");
                } else {
                    return doubleNum;
                }
            } else {

                System.out.println(prompt + " inválido/a. Tente novamente usando apenas um número >= 0");
                scanner.next();
                scanner.nextLine();
            }
        }
    }


    public int lerInt(String prompt) {

        while (true) {

            System.out.println("Digite o/a " + prompt + ":");
            if (scanner.hasNextInt()) {

                int intNum = scanner.nextInt();
                scanner.nextLine();
                if (intNum < 0) {

                    System.out.println(prompt + " inválido/a. Tente novamente usando apenas um número >= 0");
                } else {
                    return intNum;
                }
            } else {

                System.out.println(prompt + " inválido/a. Tente novamente usando apenas um número >= 0");
                scanner.next();
                scanner.nextLine();
            }
        }
    }
}
