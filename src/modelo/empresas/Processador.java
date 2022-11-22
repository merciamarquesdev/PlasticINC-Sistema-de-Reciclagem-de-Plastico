package modelo.empresas;

import java.math.BigDecimal;

public class Processador extends PessoaJuridica {
    private int numRegistro;
    private BigDecimal precoPagoKg;
    public Processador(int numRegistro, String razaoSocial, String CNPJ, BigDecimal precoPagoKg, Endereco endereco) {
        super(razaoSocial, CNPJ, endereco);
        this.numRegistro = numRegistro;
        this.precoPagoKg = precoPagoKg;
    }

    public int getNumRegistro() {
        return numRegistro;
    }
    public void setNumRegistro(int numRegistro) {
        this.numRegistro = numRegistro;
    }
    public BigDecimal getPrecoPagoKg() {
        return precoPagoKg;
    }
    public void setPrecoPagoKg(BigDecimal precoPagoKg) {
        this.precoPagoKg = precoPagoKg;
    }

    public String toString() {
        System.out.println();
        return ("\n---------- Informa��es do Processador ----------" +
                "\nN�mero de registro: " + numRegistro +
                "\nDados da Empresa Processadora de Pl�sticos Recicl�veis:" + super.toString());
    }

}
