package principal;

import modelo.empresas.Endereco;
import modelo.empresas.Processador;
import modelo.empresas.PostoDeColeta;
import modelo.financeiro.EnumFormasPagamento;
import modelo.financeiro.Relatorio;
import modelo.repositorio.Repository;
import modelo.financeiro.Venda;
import modelo.financeiro.Compra;

import java.math.BigDecimal;
import java.util.Scanner;

public class TestePlastic {

    public static void main(String[] args) {

        Repository repository = new Repository();
        Relatorio relatorio = new Relatorio();

        System.out.println("\n _____________________________________________________________________________________");
        System.out.println("|                         Boas vindas ao Sistema Plastic INC!                         |");
        System.out.println("|-------------------------------------------------------------------------------------|");
        System.out.println("|                                                                                     |");
        System.out.println("|   Nosso sistema possui diversos Processadores de Plástico Reciclável conveniados,   |" +
                "         \n|   contribuindo com um mundo mais ecológico, seguro e sustentável.                   |");
        System.out.println("|_____________________________________________________________________________________|");
        System.out.println("|                                                                                     |");
        System.out.println("|       Processadores conveniados podem buscar Postos de Coleta cadastrados           |" +
                         "\n|       com a garantia da compra de plástico reciclável de origem segura!             |");
        System.out.println("|                                                                                     |");
        System.out.println("|       Postos de Coleta cadastrados podem buscar Processadores conveniados,          |" +
                         "\n|       facilitando a venda de plástico reciclável de forma eficiente!                |");
        System.out.println("|                                                                                     |");
        System.out.println("|       Cadastre seu Posto de Coleta no menu abaixo e confira já!                     |");
        System.out.println("|                                                                                     |");
        System.out.println(" __________________________________________*__________________________________________\n\n");

        final int FINALIZAR = 8;
        int opcaoSelecionada = 0;

        do{

            System.out.println("Selecione a opção desejada: ");
            System.out.println("Digite 1 para Cadastrar Posto de Coleta");
            System.out.println("Digite 2 para Remover Posto de Coleta");
            System.out.println("Digite 3 para Exibir Postos de Coleta Cadastrados");
            System.out.println("Digite 4 para Exibir Processadores Conveniados");
            System.out.println("Digite 5 para um Posto de Coleta efetuar uma Venda");
            System.out.println("Digite 6 para um Processador efetuar uma Compra");
            System.out.println("Digite 7 para Imprimir Histórico de Transações");
            System.out.println("Digite 8 para Finalizar");
            System.out.println("Opção: ");

            Scanner scanner = new Scanner(System.in);
            opcaoSelecionada = scanner.nextInt();

            switch (opcaoSelecionada){
                case 1:
                    System.out.println("\n------------------------- Cadastro de Posto de Coleta -------------------------");
                    cadastra(scanner, repository);
                    System.out.println("\n------------------------- Posto Cadastrado Com Sucesso -------------------------");
                    break;
                case 2:
                    System.out.println("\n-------------------------- Remoção do Posto de Coleta --------------------------");
                    System.out.print("\nDigite o número de registro do Posto de Coleta que deseja remover: ");
                    int numReg = scanner.nextInt();
                    if (repository.getPostoCadastrado(numReg) != null){
                        repository.removeCadastro(numReg);
                        System.out.println("\n------------------------- Cadastro Removido Com Sucesso ------------------------");
                    } break;
                case 3:
                    System.out.println("\n-------------------- Imprimindo Postos de Coleta Cadastrados -------------------");
                    if(repository.getPostosDeColetaCadastrados().isEmpty()){
                        System.out.println("\n Ainda não há Postos de Coleta Cadastrados!");
                    }
                    else {
                        relatorio.imprimeRelatorioColetivo(repository.getPostosDeColetaCadastrados());
                    }
                    System.out.println("\n------------------------------- Fim da Impressão -------------------------------");
                    break;
                case 4:
                    System.out.println("\n---------------------- Imprimindo Processadores Conveniados --------------------");
                    relatorio.imprimeRelatorioColetivo(repository.getProcessadoresCadastrados());
                    System.out.println("\n-------------------------------- Fim da Impressão ------------------------------");
                    break;
                case 5:
                    System.out.println("\n-------------------------------- Efetuando Venda -------------------------------");
                    if (vende(scanner, repository)) System.out.println("\n-------------------------- Venda Efetuada Com Sucesso --------------------------");
                    break;
                case 6:
                    System.out.println("\n-------------------------------- Efetuando Compra -------------------------------");
                    if (compra(scanner, repository)) System.out.println("\n------------------------- Compra Efetuada Com Sucesso --------------------------");
                    break;
                case 7:
                    System.out.println("\n----------------------------- Imprimindo Nota Fiscal -----------------------------");
                    System.out.println("\nSelecione o Posto de Coleta: ");
                    int numRegTemp = scanner.nextInt();
                    if (repository.getPostoCadastrado(numRegTemp) != null){
                        relatorio.imprimeRelatorioColetivo(repository.getTransacoesEfetuadas(numRegTemp));
                        System.out.println("\n-------------------------------- Fim da Impressão --------------------------------");
                    }
                    System.out.println("");
                    break;
                case 8:
                    System.out.println("\n------------------------------- Finalizando Sistema -------------------------------");
                    break;
                default:
                    System.out.println("\nErro: Opção inválida");
            }

            if (opcaoSelecionada != FINALIZAR) System.out.println("\n------------------------------ Retornando ao Menu ------------------------------\n");

        } while (opcaoSelecionada != FINALIZAR);

    }

    private static void cadastra(Scanner scanner, Repository repository){

        System.out.println("----- Informe os dados da empresa: ");
        scanner.nextLine();
        System.out.println("Digite o CNPJ: ");
        String CNPJ= scanner.nextLine();
        System.out.println("Digite a Razão Social: ");
        String razaoSocial = scanner.nextLine();
        System.out.println("\n----- Informe os dados do seu endereço: ");
        System.out.println("Digite sua rua: ");
        String rua = scanner.nextLine();
        System.out.println("Digite o número: ");
        String numero = scanner.nextLine();
        System.out.println("Digite o cep: ");
        String cep = scanner.nextLine();
        System.out.println("Digite o bairro: ");
        String bairro = scanner.nextLine();
        System.out.println("Digite a cidade: ");
        String cidade = scanner.nextLine();
        System.out.println("Digite o estado: ");
        String estado = scanner.nextLine();

        Endereco endereco = new Endereco(rua,numero,cep,bairro,cidade,estado);
        PostoDeColeta postoTemp = new PostoDeColeta(razaoSocial, CNPJ, endereco);
        repository.cadastra(postoTemp, 2);

        System.out.println("\n-------------------------------- Cadastro Finalizado --------------------------------");
        System.out.print("\nSeu número de registro é: ");
        System.out.println(postoTemp.getNumRegistro());

    }

    private static boolean vende(Scanner scanner, Repository repository){

        System.out.print("\nDigite o Número de Registro do Posto de Coleta: ");
        int numPosto = scanner.nextInt();
        PostoDeColeta posto = repository.getPostoCadastrado(numPosto);
        if (posto == null) { return false; }

        System.out.print("\nDigite o Número de Registro do Processador: ");
        int numProcessador = scanner.nextInt();
        if (numProcessador > 5 || numProcessador <= 0) {
            System.out.println("\nErro: Não existe um Processador cadastrado com esse Número de Registro");
            return false;
        } Processador processador = (Processador) repository.getProcessadoresCadastrados().get(numProcessador-1);

        System.out.print("\nDigite o Peso em Kg de Plástico Reciclável: ");
        double pesoKg = scanner.nextDouble();
        if (pesoKg < 1000) {
            System.out.println("\nPeso insuficiente! Não foi possível efetuar a venda.");
            System.out.println("Processadores só compram a partir de 1000 kg de plástico reciclável.");
            return false;
        }

        System.out.println("Valor da venda: R$ " + String.valueOf(processador.getPrecoPagoKg().multiply(BigDecimal.valueOf(pesoKg))));

        System.out.println("\nCrédito (1) | Débito (2) | Pix (3) | Depósito (4)");
        System.out.print("Digite a Forma de Pagamento: ");
        int tipoPagamento = scanner.nextInt();
        if (tipoPagamento <= 0 || tipoPagamento > 4){
            System.out.println("\nErro: Forma de pagamento Inválida");
            return false;
        } EnumFormasPagamento pagamento = EnumFormasPagamento.getByNum(tipoPagamento-1);

        Venda novaVenda = new Venda(posto, processador, pagamento, pesoKg);
        repository.cadastra(novaVenda, 1);
        return true;

    }

    private static boolean compra(Scanner scanner, Repository repository){

        System.out.print("\nDigite o Número de Registro do Processador: ");
        int numProcessador = scanner.nextInt();
        if (numProcessador > 5 || numProcessador <= 0) {
            System.out.println("\nErro: Não existe um Processador cadastrado com esse Número de Registro");
            return false;
        } Processador processador = (Processador) repository.getProcessadoresCadastrados().get(numProcessador-1);

        System.out.print("\nDigite o Número de Registro do Posto de Coleta: ");
        int numPosto = scanner.nextInt();
        PostoDeColeta posto = repository.getPostoCadastrado(numPosto);
        if (posto == null) { return false; }

        System.out.print("\nDigite o Peso em Kg de Plástico Reciclável: ");
        double pesoKg = scanner.nextDouble();
        if (pesoKg < 1000) {
            System.out.println("\nPeso insuficiente! Não foi possível efetuar a compra.");
            System.out.println("Só é possível efetuar compras a partir de 1000 kg de plástico reciclável.");
            return false;
        }

        System.out.println("Valor da compra: R$ " + String.valueOf(processador.getPrecoPagoKg().multiply(BigDecimal.valueOf(pesoKg))));

        System.out.println("\nCrédito (1) | Débito (2) | Pix (3) | Depósito (4)");
        System.out.print("Digite a Forma de Pagamento: ");
        int tipoPagamento = scanner.nextInt();
        if (tipoPagamento <= 0 || tipoPagamento > 4){
            System.out.println("\nErro: Forma de pagamento Inválida");
            return false;
        } EnumFormasPagamento pagamento = EnumFormasPagamento.getByNum(tipoPagamento-1);

        Compra novaCompra = new Compra(posto, processador, pagamento, pesoKg);
        repository.cadastra(novaCompra, 1);
        return true;

    }

}
