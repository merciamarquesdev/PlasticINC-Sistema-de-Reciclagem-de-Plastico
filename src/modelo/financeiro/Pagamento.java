package modelo.financeiro;

import modelo.financeiro.enumeracoes.EnumFormasPagamento;

public class Pagamento {
    private EnumFormasPagamento formaPagamento;

    public EnumFormasPagamento getFormasPagamento() {
        return formaPagamento;
    }

    public void setTipoPagamento(EnumFormasPagamento tipoPagamento) {
        this.formaPagamento = formaPagamento;
    }

}
