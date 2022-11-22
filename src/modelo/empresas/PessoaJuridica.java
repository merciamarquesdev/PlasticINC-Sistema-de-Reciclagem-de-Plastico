package modelo.empresas;

import java.math.BigDecimal;

public class PessoaJuridica extends Endereco {
    private String razaoSocial;
    private String CNPJ;
    private Endereco endereco;

    public PessoaJuridica(String razaoSocial, String CNPJ, Endereco endereco) {
        super(endereco.getRua(), endereco.getNumero(), endereco.getCep(), endereco.getBairro(), endereco.getCidade(), endereco.getEstado());
        this.razaoSocial = razaoSocial;
        this.CNPJ = CNPJ;
        this.endereco = endereco;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }
    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCNPJ() {
        return CNPJ;
    }
    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }


    public Endereco getEndereco() {
        return endereco;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String toString() {
        return ("\nRazão Social: " + razaoSocial +
                "\nCNPJ: " + CNPJ +
                "\nEndereco: " + super.toString());
    }

}
