package modelo.repositorio;

import java.util.List;

public class Relatorio <T>{

    public void imprimeRelatorioIndividual(T t){
        System.out.println("\n\n------------------------------- Relat�rio Individual -------------------------------");
        System.out.println(t);
    }

    public void imprimeRelatorioColetivo(List<T> lista){
        for(T t:lista){
            System.out.println(t);
        }
    }

}
