public abstract class Funcionario {

    private static final int SALARIO_BASE = 2000;
    private final String nome;
    private final int matricula;

    public Funcionario(String nome, int matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }

    public static int getSalarioBase() {
        return SALARIO_BASE;
    }

    public String getNome() {
        return this.nome;
    }

    public int getMatricula() {
        return this.matricula;
    }

    public abstract double calcularSalario();
}
