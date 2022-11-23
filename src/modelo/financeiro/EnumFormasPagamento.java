package modelo.financeiro;

public enum EnumFormasPagamento {
    CREDITO(1,"CREDITO"),
    DEBITO(2, "DEBITO"),
    PIX(3,"PIX"),
    DEPOSITO(4,"DEPOSITO");

    private int numero;
    private String palavra;

    private EnumFormasPagamento(int numero, String palavra){
        this.numero = numero;
        this.palavra = palavra;
    }

    public static EnumFormasPagamento getByNum(int numero){
        for(EnumFormasPagamento i: EnumFormasPagamento.values()){
            if(i.getNumero() == numero){
                return i;
            }
        } return CREDITO;
    }

    public int getNumero() { return numero; }
    public String getFormaPagamento() { return palavra; }

}
