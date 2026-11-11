public class Producao extends Funcionario {

    private final int quantidadeProduzida;
    private final double valorPorPeca;

    public Producao(
            String nome,
            int matricula,
            int quantidadeProduzida,
            double valorPorPeca
    ) {
        super(nome, matricula);
        this.quantidadeProduzida = quantidadeProduzida;
        this.valorPorPeca = valorPorPeca;
    }

    private double getBonus() {
        return this.valorPorPeca * this.quantidadeProduzida;
    }

    @Override
    public double calcularSalario() {
        return getSalarioBase() + getBonus();
    }

    @Override
    public String toString() {
        return "Producao:" +
                "\nNome: " + getNome() +
                "\nMatrícula: " + getMatricula() +
                "\nQuantidade de peças produzidas: " + quantidadeProduzida +
                "\nValor de cada peça produzida: R$" + valorPorPeca +
                "\nBônus: R$" + getBonus() +
                "\nSalário final: R$" + calcularSalario();
    }
}