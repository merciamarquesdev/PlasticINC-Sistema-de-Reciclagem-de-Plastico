package modelo.empresas;

import java.math.BigDecimal;

public class PostoDeColeta extends PessoaJuridica {
    private int numRegistro;

    public PostoDeColeta(String razaoSocial, String CNPJ, Endereco endereco) {
        super(razaoSocial, CNPJ, endereco);
    }

    public int getNumRegistro() {
        return numRegistro;
    }
    public void setNumRegistro(int numRegistro) {
        this.numRegistro = numRegistro;
    }

    public String toString() {
        System.out.println();
        return ("\n---------- Informações do Posto de Coleta ----------" +
                "\nNúmero de registro: " + numRegistro +
                "\nDados da Empresa Coletora de Plásticos Recicláveis:" + super.toString());
    }

}
