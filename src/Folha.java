import java.util.ArrayList;
import java.util.List;

public class Folha {

    private final List<Funcionario> funcionarioList = new ArrayList<>();
    private final Menu menu;

    public Folha(Menu menu) {

        this.menu = menu;

        int opcao;
        do {
            opcao = menu.lerOpcao();
            switch (opcao) {
                case 1:
                    cadastrarPadrao();
                    break;
                case 2:
                    cadastrarComissionado();
                    break;
                case 3:
                    cadastrarProducao();
                    break;
                case 4:
                    exibirFolha();
                    break;
            }
        } while (opcao != 0);
    }

    private void cadastrarPadrao() {

        Padrao padrao = new Padrao(
                menu.lerNome(),
                menu.lerMatricula(this.funcionarioList)
        );

        this.funcionarioList.add(padrao);
        System.out.println("Funcionário cadastrado");
    }

    private void cadastrarComissionado() {

        Comissionado comissionado = new Comissionado(
                menu.lerNome(),
                menu.lerMatricula(this.funcionarioList),
                menu.lerInt("valor total das vendas"),
                menu.lerDouble("percentual de comissao", 100)
        );

        this.funcionarioList.add(comissionado);
        System.out.println("Funcionário cadastrado");
    }

    private void cadastrarProducao() {

        Producao producao = new Producao(
                menu.lerNome(),
                menu.lerMatricula(this.funcionarioList),
                menu.lerInt("quantidade de peças produzidas"),
                menu.lerDouble("valor de cada peça produzida", 0)
        );

        this.funcionarioList.add(producao);
        System.out.println("Funcionário cadastrado");
    }

    private void exibirFolha() {

        if (!this.funcionarioList.isEmpty()) {

            System.out.println("\nExibindo Folha de Pagamento");
            System.out.println("-------------------------------------------------------------");

            for (Funcionario funcionario : this.funcionarioList) {

                System.out.println(funcionario.toString());
                System.out.println("-------------------------------------------------------------");
            }

            double somaSalario = 0;

            for (Funcionario funcionario : this.funcionarioList) {
                somaSalario += funcionario.calcularSalario();
            }

            System.out.println("Total de funcionários cadastrados: " + this.funcionarioList.size());
            System.out.println("Soma total dos salários finais de todos os funcionários: R$" + somaSalario);
            System.out.println("-------------------------------------------------------------");
        } else {

            System.out.println("Nenhum funcionário cadastrado");
        }
    }
}
