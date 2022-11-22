package principal;

import modelo.empresas.Endereco;
import modelo.empresas.PostoDeColeta;
import modelo.repositorio.Relatorio;
import modelo.repositorio.Repository;

import java.math.BigDecimal;
import java.util.Scanner;

public class TestePlastic {

    public static void main(String[] args) {

        Repository repository = new Repository();
        Relatorio relatorio = new Relatorio();

        final int FINALIZAR = 7;
        int opcaoSelecionada = 0;

        do{
            System.out.println("Seleciona a opção desejada: ");
            System.out.println("Digite 1 para Cadastrar Posto de Coleta");
            System.out.println("Digite 2 para Remover Posto de Coleta");
            System.out.println("Digite 3 para Listar Postos de Coleta");
            System.out.println("Digite 4 para Listar Processadores Conveniados");
            System.out.println("Digite 5 para Efetuar uma Venda");
            System.out.println("Digite 6 para Imprimir Histórico de Transações");
            System.out.println("Digite 7 para Finalizar");
            System.out.print("Opção: ");

            Scanner scanner = new Scanner(System.in);
            opcaoSelecionada = scanner.nextInt();

            switch (opcaoSelecionada){
                case 1:
                    System.out.println("\n------------ Cadastro de Posto de Coleta ------------");
                    cadastra(scanner, repository);
                    break;
                case 2:
                    System.out.println("\n------------ Remoção do Posto de Coleta ------------");
                    System.out.print("\nSelecione o Posto de Coleta: ");
                    int numReg = scanner.nextInt();
                    if (repository.getPostoCadastrado(numReg) != 0){
                        repository.removeCadastro(numReg);
                    } break;
                case 3:
                    System.out.println("\n------------ Imprimindo Postos de Coleta Cadastrados ------------");
                    relatorio.imprimeRelatorioColetivo(repository.getPostosDeColetaCadastrados());
                    System.out.println("\n------------------ Fim da Impressão --------------------");
                    break;
                case 4:
                    System.out.println("\n------------ Imprimindo Processadores Conveniados ------------");
                    relatorio.imprimeRelatorioColetivo(repository.getProcessadoresCadastrados());
                    System.out.println("\n------------------ Fim da Impressão ----------------------");
                    break;
                case 5:
                    System.out.println("\n------------ Efetuando Venda ------------");
                    //CODIGO DE EFETUAR VENDA
                    break;
                case 6:
                    System.out.println("\n------------ Imprimindo Notas Fiscais ------------");
                    System.out.print("\nSelecione o Posto de Coleta: ");
                    int numRegTemp = scanner.nextInt();
                    if (repository.getPostoCadastrado(numRegTemp) != 0){
                        relatorio.imprimeRelatorioColetivo(repository.getVendasEfetuadas(numRegTemp));
                        System.out.println("\n---------------- Fim da Lista --------------------");
                    }
                    break;
                case 7:
                    System.out.println("\n------ Finalizando Sistema -------");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
            if (opcaoSelecionada != 7) System.out.println("\n---- Retornando ao Menu ----\n");
        } while (opcaoSelecionada != FINALIZAR);

    }
    private static void cadastra(Scanner scanner, Repository repository){
        System.out.println("----- Informe os dados da empresa: ");
        System.out.print("Digite o CNPJ: ");
        String CNPJ= scanner.next();
        System.out.print("Digite a Razão Social: ");
        String razaoSocial = scanner.next();
        System.out.print("Digite o Preço Pago por Kg: ");
        BigDecimal precoPagoKg = scanner.nextBigDecimal();
        System.out.println("\n----- Informe os dados do seu endereço: ");
        System.out.print("Digite sua rua: ");
        String rua = scanner.next();
        System.out.print("Digite o numero: ");
        String numero = scanner.next();
        System.out.print("Digite o cep: ");
        String cep = scanner.next();
        System.out.print("Digite o bairro: ");
        String bairro = scanner.next();
        System.out.print("Digite o estado: ");
        String estado = scanner.next();
        System.out.print("Digite a cidade: ");
        String cidade = scanner.next();

        Endereco endereco = new Endereco(rua,numero,cep,bairro,estado,cidade);
        PostoDeColeta postoTemp = new PostoDeColeta(razaoSocial, CNPJ, endereco);
        repository.cadastra(postoTemp, 2);

        System.out.println("\n----- Cadastro Finalizado -----");
        System.out.print("\n----- Seu número de registro é: ");
        System.out.print(postoTemp.getNumRegistro());
        System.out.println(" -----");
    }
}
