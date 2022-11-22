package modelo.financeiro;

import modelo.empresas.Processador;
import modelo.financeiro.enumeracoes.EnumTipoPlastico;

import java.math.BigDecimal;

public interface Transacao<T> {

    String codigoTransacao();

    //EnumTipoPlastico tipoPlastico(EnumTipoPlastico tipoPlastico);

    BigDecimal totalTransacao(Processador processador, double pesoKg);

}
