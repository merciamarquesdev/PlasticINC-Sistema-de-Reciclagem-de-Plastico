package modelo.financeiro;

import java.util.List;

public class Relatorio <T>{
    public void imprimeRelatorioColetivo(List<T> lista){
        for(T t:lista){
            System.out.println(t);
        }
    }

}
