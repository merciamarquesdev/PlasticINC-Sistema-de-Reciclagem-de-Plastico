package modelo.financeiro;

import modelo.empresas.PostoDeColeta;
import modelo.empresas.Processador;

import java.math.BigDecimal;

public class Compra<T> implements Transacao<T> {

    private int numRegPostoDeColeta;
    private int numRegProcessador;
    private String cnpjPostoDeColeta;
    private String cnpjProcessador;
    private String razaoSocialPostoDeColeta;
    private String razaoSocialProcessador;
    private EnumFormasPagamento formaPagamento;
    private double valorPago;
    private BigDecimal pesoPlasticoAdquirido;

    public Compra(PostoDeColeta postoDeColeta, Processador processador, EnumFormasPagamento formaPagamento, double valorPago) {
        this.numRegPostoDeColeta = postoDeColeta.getNumRegistro();
        this.numRegProcessador = processador.getNumRegistro();
        this.valorPago = valorPago;
        this.pesoPlasticoAdquirido = totalTransacao(processador, valorPago);
        this.cnpjPostoDeColeta = postoDeColeta.getCNPJ();
        this.cnpjProcessador = processador.getCNPJ();
        this.razaoSocialPostoDeColeta = postoDeColeta.getRazaoSocial();
        this.razaoSocialProcessador = processador.getRazaoSocial();
        this.formaPagamento = formaPagamento;
    }

    public int getNumReg(){return numRegPostoDeColeta;}

    public String codigoTransacao() {
        String codigo = String.valueOf(numRegProcessador) + String.valueOf((int) valorPago) + String.valueOf(numRegPostoDeColeta);
        return codigo;
    }

    public BigDecimal totalTransacao(Processador processador, double valor) {
        BigDecimal precoPagoKg = processador.getPrecoPagoKg();
        BigDecimal totalCompra = BigDecimal.valueOf(valor).divide(precoPagoKg,2);
        return totalCompra;
    }

    public String toString() {
        System.out.println();
        return ("\n---------- Nota Fiscal " + codigoTransacao() + " ----------" +
                "\nTipo de Transação: Compra" +
                "\nCNPJ Posto de Coleta: " + cnpjPostoDeColeta +
                "\nCNPJ Processador: " + cnpjProcessador +
                "\nRazão Social do Ponto de Coleta: " + razaoSocialPostoDeColeta +
                "\nRazão Social do Processador: " + razaoSocialProcessador +
                "\nCodigo do Processador: " + String.valueOf(numRegProcessador) +
                "\nValor Pago: R$" + String.valueOf(valorPago) +
                "\nPlastico Adquirido: " + String.valueOf(pesoPlasticoAdquirido.floatValue()) + " Kgs" +
                "\nForma de Pagamento: " + formaPagamento.getFormaPagamento());
    }

}
