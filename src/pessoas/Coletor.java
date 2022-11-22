package pessoas;

import modelo.empresas.Endereco;

public class Coletor extends PessoaFisica  {
    public Coletor(String nome, String CPF, String conta, Endereco endereco) {
        super(nome, CPF, conta, endereco);
    }

    /**
    private int numRegistro;
    private PessoaFisica pessoaFisica;
    private double pesoTotalVenda;
    private FormasPagamento formaPagamento;
    private static int sequence = 1;


    public Coletor(int numRegistro, String nome, String CPF,
                   double pesoTotalVenda, FormasPagamento formaPagamento, Endereco endereco) {
        super(nome, CPF, pesoTotalVenda, formaPagamento, endereco);
        this.numRegistro = numRegistro;
        this.pessoaFisica = pessoaFisica;
    }

    public int getNumRegistro() {
        return numRegistro;
    }

    public void setNumRegistro(int numRegistro) {
        this.numRegistro = numRegistro;
    }

    public PessoaFisica getPessoaFisica() {
        return pessoaFisica;
    }

    public void setPessoaFisica(PessoaFisica pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
    }

    @Override
    public String toString() {
        System.out.println();
        return ("\n-------------- Informa��es do Coletor --------------" +
                "\nN�mero de registro: " + numRegistro +
                "\nDados pessoais do Coletor:" + super.toString());
    }

    @Override
    public int codigoTransacao(Object objeto) {
        PostoDeColeta postoDeColeta = (PostoDeColeta) objeto;
        postoDeColeta.setNumRegistro(sequence);
        sequence++;
        return numRegistro;
    }

    @Override
    public Plastico tipoPlastico(Plastico tipoPlastico) {
        return tipoPlastico;
    }

    @Override
    public BigDecimal totalTransacao(double pesoKg) {
        return null;
    }

    @Override
    public BigDecimal totalTransacao(double pesoKg) {
        public BigDecimal totalTransacao(double pesoKg) {
            if (pesoKg >= 1.0){
                precoPagoKg = getPrecoPagoKg();
                BigDecimal totalCompra = precoPagoKg.multiply(BigDecimal.valueOf(pesoKg));
                return totalCompra;
            }
            else{

                System.out.println("Peso insuficiente! N�o foi poss�vel efetuar a venda." +
                    "\nPostos de Coleta s� compram de Coletores a partir de 1 kg de pl�stico recicl�vel.");
            return 0;
        }
    }*/

}