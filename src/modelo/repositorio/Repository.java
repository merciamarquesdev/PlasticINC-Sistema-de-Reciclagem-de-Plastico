package modelo.repositorio;

import modelo.empresas.PessoaJuridica;
import modelo.empresas.PostoDeColeta;
import modelo.empresas.Processador;
import modelo.empresas.Endereco;
import modelo.financeiro.Venda;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Repository <T>{
    private static int sequence = 1;
    List<Venda> vendasCadastradas = new ArrayList<>();
    List<PostoDeColeta> postosCadastrados = new ArrayList<>();
    public void cadastra(T t, int type){
        switch (type){
            case 1:
                Venda venda = (Venda) t;
                vendasCadastradas.add(venda);
                break;
            case 2:
                PostoDeColeta posto = (PostoDeColeta) t;
                posto.setNumRegistro(sequence++);
                postosCadastrados.add(posto);
                break;
            default:
                System.out.println("\n Erro: Tipo Inválido");
                break;
        } System.out.println("\n------ Posto Cadastrado Com Sucesso -------");
    }
    public void removeCadastro(int numReg){
        for (PostoDeColeta i : postosCadastrados){
            if (i.getNumRegistro() == numReg){
                postosCadastrados.remove(i);
                break;
            }
        } System.out.println("\n--------- Cadastro Removido Com Sucesso -----------");
    }
    public List getProcessadoresCadastrados(){
        Endereco endereco1 = new Endereco("Av. Brasil","1500","11111-11","Amarelo","RJ","RJ");
        Processador processador1 = new Processador(123,"Posto da Guanabara","1000000002000",new BigDecimal(3.00),endereco1);
        Endereco endereco2 = new Endereco("Av. Brasil","1500","11111-11","Amarelo","RJ","RJ");
        Processador processador2 = new Processador(123,"Posto da Guanabara","1000000002000",new BigDecimal(2.50),endereco2);
        Endereco endereco3 = new Endereco("Av. Brasil","1500","11111-11","Amarelo","SP","RJ");
        Processador processador3 = new Processador(123,"Posto da Guanabara","1000000002000",new BigDecimal(3.70),endereco3);
        Endereco endereco4 = new Endereco("Av. Brasil","1500","11111-11","Amarelo","SP","RJ");
        Processador processador4 = new Processador(123,"Posto da Guanabara","1000000002000",new BigDecimal(2.75),endereco4);
        Endereco endereco5 = new Endereco("Av. Brasil","1500","11111-11","Amarelo","RJ","RJ");
        Processador processador5 = new Processador(123,"Posto da Guanabara","1000000002000",new BigDecimal(3.10),endereco5);
        List<Processador> processadoresCadastrados = List.of(processador1, processador2, processador3, processador4, processador5);
        return processadoresCadastrados;
    }
    public List getPostosDeColetaCadastrados(){return postosCadastrados;}
    public List getVendasEfetuadas(int numRegistro){
        List<Venda> vendasPosto = new ArrayList<>();
        for (Venda i : vendasCadastradas){
            if (i.getNumRegPostoDeColeta() == numRegistro){
                vendasPosto.add(i);
            }
        } return vendasPosto;
    }
    public int getPostoCadastrado(int numRegistro){
        for (PostoDeColeta i : postosCadastrados){
            if (i.getNumRegistro() == numRegistro){
                return i.getNumRegistro();
            }
        }
        System.out.println("\nErro: Não existe um Posto cadastrado com essa Número de Registro");
        return 0;
    }

}
