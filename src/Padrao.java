public class Padrao extends Funcionario {

    public Padrao(String nome, int matricula) {
        super(nome, matricula);
    }

    @Override
    public double calcularSalario() {
        return getSalarioBase();
    }

    @Override
    public String toString() {
        return "Padrao:" +
                "\nNome: " + getNome() +
                "\nMatrícula: " + getMatricula() +
                "\nSalário Final: R$" + calcularSalario();
    }
}
