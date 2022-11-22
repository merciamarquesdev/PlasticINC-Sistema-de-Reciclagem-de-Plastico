package modelo.financeiro;

import modelo.empresas.PostoDeColeta;
import modelo.financeiro.enumeracoes.EnumTipoPlastico;
import modelo.empresas.Processador;

import java.math.BigDecimal;

public class Venda<T> implements Transacao<T> {
    private int numRegPostoDeColeta;
    private int numRegProcessador;
    private BigDecimal valorPago;

    public Venda(PostoDeColeta postoDeColeta, Processador processador, double pesoKg) {
        this.numRegPostoDeColeta = postoDeColeta.getNumRegistro();
        this.numRegProcessador = processador.getNumRegistro();
        this.valorPago = totalTransacao(processador, pesoKg);
    }
    public int getNumRegPostoDeColeta(){return numRegPostoDeColeta;}
    public String codigoTransacao() {
        String codigo = String.valueOf(numRegPostoDeColeta) + String.valueOf(valorPago) + String.valueOf(numRegProcessador);
        return codigo;
    }

    public BigDecimal totalTransacao(Processador processador, double pesoKg) {
        BigDecimal totalCompra = new BigDecimal(0.0);
        if (pesoKg >= 1000.0) {
            BigDecimal precoPagoKg = processador.getPrecoPagoKg();
            totalCompra = precoPagoKg.multiply(BigDecimal.valueOf(pesoKg));
            return totalCompra;
        } else {
            System.out.println("Peso insuficiente! Não foi possível efetuar a compra." +
            "\nPostos de Coleta só compram a partir de 1 kg de plástico reciclável.");
        } return totalCompra;
    }

    //public EnumTipoPlastico tipoPlastico(EnumTipoPlastico tipoPlastico) {
    //    return tipoPlastico;
    //}

    public String toString() {
        System.out.println();
        return ("\n---------- Nota Fiscal " + codigoTransacao() + "----------" +
                "\nCodigo do Processador: " + String.valueOf(numRegProcessador) +
                "\nValor Pago: " + String.valueOf(valorPago));
    }

}
