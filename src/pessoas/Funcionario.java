package pessoas;

import modelo.empresas.Endereco;

public class Funcionario extends PessoaFisica{
    private String matricula;
    private PessoaFisica pessoaFisica;

    public Funcionario(String matricula, String nome, String CPF, String conta, Endereco endereco, PessoaFisica pessoaFisica) {
        super(nome, CPF, conta, endereco);
        this.matricula = matricula;
        this.pessoaFisica = pessoaFisica;
    }

    /**public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public PessoaFisica getPessoaFisica() {
        return pessoaFisica;
    }

    public void setPessoaFisica(PessoaFisica pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
    }

    @Override
    public String toString() {
        return ("\n-------------- Informações do Funcionário --------------" +
                "\nMatrícula: " + matricula +
                "\nDados Pessoais: " + super.toString());
    }
    */
}
