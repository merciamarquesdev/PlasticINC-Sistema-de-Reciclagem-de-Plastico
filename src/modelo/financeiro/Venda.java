package modelo.financeiro;

import modelo.empresas.PostoDeColeta;
import modelo.empresas.Processador;

import java.math.BigDecimal;

public class Venda<T> implements Transacao<T> {

    private int numRegPostoDeColeta;
    private int numRegProcessador;
    private String cnpjPostoDeColeta;
    private String cnpjProcessador;
    private String razaoSocialPostoDeColeta;
    private String razaoSocialProcessador;
    private EnumFormasPagamento formaPagamento;
    private BigDecimal valorPago;

    public Venda(PostoDeColeta postoDeColeta, Processador processador, EnumFormasPagamento formaPagamento, double pesoKg) {
        this.numRegPostoDeColeta = postoDeColeta.getNumRegistro();
        this.numRegProcessador = processador.getNumRegistro();
        this.valorPago = totalTransacao(processador, pesoKg);
        this.cnpjPostoDeColeta = postoDeColeta.getCNPJ();
        this.cnpjProcessador = processador.getCNPJ();
        this.razaoSocialPostoDeColeta = postoDeColeta.getRazaoSocial();
        this.razaoSocialProcessador = processador.getRazaoSocial();
        this.formaPagamento = formaPagamento;
    }

    public int getNumReg() { return numRegPostoDeColeta; }

    public String codigoTransacao() {
        String codigo = String.valueOf(numRegPostoDeColeta) + String.valueOf(valorPago.intValue()) + String.valueOf(numRegProcessador);
        return codigo;
    }

    public BigDecimal totalTransacao(Processador processador, double pesoKg) {
        BigDecimal precoPagoKg = processador.getPrecoPagoKg();
        BigDecimal totalCompra = precoPagoKg.multiply(BigDecimal.valueOf(pesoKg));
        return totalCompra;
    }

    public String toString() {
        System.out.println();
        return ("\n------------------------------ Nota Fiscal " + codigoTransacao() + " -----------------------------" +
                "\nTipo de Transação: Venda" +
                "\nCNPJ Posto de Coleta: " + cnpjPostoDeColeta +
                "\nCNPJ Processador: " + cnpjProcessador +
                "\nRazão Social do Ponto de Coleta: " + razaoSocialPostoDeColeta +
                "\nRazão Social do Processador: " + razaoSocialProcessador +
                "\nCodigo do Processador: " + String.valueOf(numRegProcessador) +
                "\nValor Recebido: R$ " + String.valueOf(valorPago.intValue()) +
                "\nForma de Pagamento: " + formaPagamento.getFormaPagamento());
    }

}
