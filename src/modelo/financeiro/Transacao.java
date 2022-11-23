package modelo.financeiro;

import modelo.empresas.Processador;

import java.math.BigDecimal;

public interface Transacao<T> {

    int getNumReg();

    String codigoTransacao();

    BigDecimal totalTransacao(Processador processador, double pesoKg);

}
