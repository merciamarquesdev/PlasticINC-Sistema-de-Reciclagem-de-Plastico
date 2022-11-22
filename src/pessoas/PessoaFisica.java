package pessoas;

import modelo.empresas.Endereco;

public class PessoaFisica extends Endereco {
    private String nome;
    private String CPF;
    private String conta;
    private Endereco endereco;

    public PessoaFisica(String nome, String CPF, String conta, Endereco endereco) {
        super(endereco.getRua(), endereco.getNumero(), endereco.getCep(), endereco.getBairro(), endereco.getEstado(), endereco.getCidade());
        this.nome = nome;
        this.CPF = CPF;
        this.conta = conta;
        this.endereco = endereco;
    }

    /**public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return ("\nNome: " + nome +
                "\nCPF: " + CPF +
                "\nConta: " + conta +
                "\nEndereco: " + super.toString());
    }*/
}
