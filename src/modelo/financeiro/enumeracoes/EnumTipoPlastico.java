package modelo.financeiro.enumeracoes;

public enum EnumTipoPlastico {
    PET,
    PEAD,
    PVC,
    PEBD,
    PP,
    PS,
    OUTROS;

    public static EnumTipoPlastico getPlasticoNome(String nome){
        for (EnumTipoPlastico plasticoEnum: EnumTipoPlastico.values()) {
            if (plasticoEnum.name().equals(nome)){
                return plasticoEnum;
            }
        }
        return OUTROS;
    }
}
