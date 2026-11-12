public class Comissionado extends Funcionario {

    private final int vendas;
    private final double percentual;

    public Comissionado(
            String nome,
            int matricula,
            int vendas,
            double percentual
    ) {
        super(nome, matricula);
        this.vendas = vendas;
        this.percentual = percentual;
    }

    private double getComissao() {
        return this.vendas * this.percentual / 100;
    }

    @Override
    public double calcularSalario() {
        return getSalarioBase() + getComissao();
    }

    @Override
    public String toString() {
        return "Comissionado:" +
                "\nNome: " + getNome() +
                "\nMatrícula: " + getMatricula() +
                "\nValor total das vendas: R$" + vendas +
                "\nPercentual de comissão: " + percentual + "%" +
                "\nComissão: R$" + getComissao() +
                "\nSalário final: R$" + calcularSalario();
    }
}
