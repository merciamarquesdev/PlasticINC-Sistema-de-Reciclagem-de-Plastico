package modelo.repositorio;

import modelo.empresas.PostoDeColeta;
import modelo.empresas.Processador;
import modelo.empresas.Endereco;
import modelo.financeiro.Transacao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Repository <T>{

    private static int sequence = 1;
    List<Transacao> transacoesCadastradas = new ArrayList<>();
    List<PostoDeColeta> postosCadastrados = new ArrayList<>();

    public void cadastra(T t, int type){
        switch (type){
            case 1:
                Transacao transacao = (Transacao) t;
                transacoesCadastradas.add(transacao);
                break;
            case 2:
                PostoDeColeta posto = (PostoDeColeta) t;
                posto.setNumRegistro(sequence++);
                postosCadastrados.add(posto);
                break;
        }
    }
    public void removeCadastro(int numReg){
        for (PostoDeColeta i : postosCadastrados){
            if (i.getNumRegistro() == numReg){
                postosCadastrados.remove(i);
                break;
            }
        }
    }

    public List getPostosDeColetaCadastrados(){return postosCadastrados;}
    public List getProcessadoresCadastrados(){
        Endereco endereco1 = new Endereco("Av. Brasil","1500","50390-10","Amarelo","Rio de Janeiro","RJ");
        Processador processador1 = new Processador(1,"Posto da Guanabara","1000000002000",new BigDecimal(3),endereco1);
        Endereco endereco2 = new Endereco("Av. Paulista","1200","49930-20","Laranjeiras","São Paulo","SP");
        Processador processador2 = new Processador(2,"Posto Anil","1000000005670",new BigDecimal(2),endereco2);
        Endereco endereco3 = new Endereco("Av. das Américas","10500","13021-11","Azul","Belo Horizonte","MG");
        Processador processador3 = new Processador(3,"Posto da Paz","1000000002220",new BigDecimal(4),endereco3);
        Endereco endereco4 = new Endereco("Rua Bonita","100","10341-20","Verde","Rio de Janeiro","RJ");
        Processador processador4 = new Processador(4,"Posto Esperança","1000112202000",new BigDecimal(2),endereco4);
        Endereco endereco5 = new Endereco("Rua das Flores","450","11222-60","Rosa","São Paulo","SP");
        Processador processador5 = new Processador(5,"Posto Jardim","1000000512000",new BigDecimal(3),endereco5);
        List<Processador> processadoresCadastrados = List.of(processador1, processador2, processador3, processador4, processador5);
        return processadoresCadastrados;
    }
    public List getTransacoesEfetuadas(int numRegistro){
        List<Transacao> transacoesPosto = new ArrayList<>();
        for (Transacao i : transacoesCadastradas){
            if (i.getNumReg() == numRegistro) transacoesPosto.add(i);
        } return transacoesPosto;
    }
    public PostoDeColeta getPostoCadastrado(int numRegistro){
        for (PostoDeColeta i : postosCadastrados){
            if (i.getNumRegistro() == numRegistro) return i;
        } System.out.println("\nErro: Não existe um Posto cadastrado com esse Número de Registro");
        return null;
    }

}
