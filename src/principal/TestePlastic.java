package principal;

import modelo.empresas.Endereco;
import modelo.empresas.Processador;
import modelo.empresas.PostoDeColeta;
import modelo.financeiro.EnumFormasPagamento;
import modelo.repositorio.Relatorio;
import modelo.repositorio.Repository;
import modelo.financeiro.Venda;
import modelo.financeiro.Compra;

import java.util.Scanner;

public class TestePlastic {

    public static void main(String[] args) {

        Repository repository = new Repository();
        Relatorio relatorio = new Relatorio();

        final int FINALIZAR = 8;
        int opcaoSelecionada = 0;

        do{

            System.out.println("Seleciona a opção desejada: ");
            System.out.println("Digite 1 para Cadastrar Posto de Coleta");
            System.out.println("Digite 2 para Remover Posto de Coleta");
            System.out.println("Digite 3 para Listar Postos de Coleta");
            System.out.println("Digite 4 para Listar Processadores Conveniados");
            System.out.println("Digite 5 para Efetuar uma Venda");
            System.out.println("Digite 6 para Efetuar uma Compra");
            System.out.println("Digite 7 para Imprimir Histórico de Transações");
            System.out.println("Digite 8 para Finalizar");
            System.out.print("Opção: ");

            Scanner scanner = new Scanner(System.in);
            opcaoSelecionada = scanner.nextInt();

            switch (opcaoSelecionada){
                case 1:
                    System.out.println("\n------------ Cadastro de Posto de Coleta ------------");
                    cadastra(scanner, repository);
                    System.out.println("\n------ Posto Cadastrado Com Sucesso -------");
                    break;
                case 2:
                    System.out.println("\n------------ Remoção do Posto de Coleta ------------");
                    System.out.print("\nSelecione o Posto de Coleta: ");
                    int numReg = scanner.nextInt();
                    if (repository.getPostoCadastrado(numReg) != null){
                        repository.removeCadastro(numReg);
                        System.out.println("\n--------- Cadastro Removido Com Sucesso -----------");
                    } break;
                case 3:
                    System.out.print("\n------------ Imprimindo Postos de Coleta Cadastrados ------------");
                    relatorio.imprimeRelatorioColetivo(repository.getPostosDeColetaCadastrados());
                    System.out.println("\n------------------ Fim da Impressão --------------------");
                    break;
                case 4:
                    System.out.print("\n------------ Imprimindo Processadores Conveniados ------------");
                    relatorio.imprimeRelatorioColetivo(repository.getProcessadoresCadastrados());
                    System.out.println("\n------------------ Fim da Impressão ----------------------");
                    break;
                case 5:
                    System.out.println("\n------------ Efetuando Venda ------------");
                    if (vende(scanner, repository)) System.out.println("\n-------- Venda Efetuada Com Sucesso --------");
                    break;
                case 6:
                    System.out.println("\n------------ Efetuando Compra ------------");
                    if (compra(scanner, repository)) System.out.println("\n-------- Compra Efetuada Com Sucesso --------");
                    break;
                case 7:
                    System.out.println("\n------------ Imprimindo Notas Fiscais ------------");
                    System.out.print("\nSelecione o Posto de Coleta: ");
                    int numRegTemp = scanner.nextInt();
                    if (repository.getPostoCadastrado(numRegTemp) != null){
                        relatorio.imprimeRelatorioColetivo(repository.getTransacoesEfetuadas(numRegTemp));
                        System.out.print("\n---------------- Fim da Impressão --------------------");
                    } System.out.println(""); break;
                case 8:
                    System.out.println("\n------ Finalizando Sistema -------");
                    break;
                default:
                    System.out.println("\nErro: Opção inválida");
            }

            if (opcaoSelecionada != FINALIZAR) System.out.println("\n---- Retornando ao Menu ----\n");

        } while (opcaoSelecionada != FINALIZAR);

    }

    private static void cadastra(Scanner scanner, Repository repository){

        System.out.println("----- Informe os dados da empresa: ");
        System.out.print("Digite o CNPJ: ");
        String CNPJ= scanner.next();
        System.out.print("Digite a Razão Social: ");
        String razaoSocial = scanner.next();
        System.out.println("\n----- Informe os dados do seu endereço: ");
        System.out.print("Digite sua rua: ");
        String rua = scanner.next();
        System.out.print("Digite o número: ");
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

        System.out.print("\nDigite o Peso em Kg: ");
        double pesoKg = scanner.nextDouble();
        if (pesoKg < 1000) {
            System.out.println("\nPeso insuficiente! Não foi possível efetuar a compra.");
            System.out.println("Postos de Coleta só compram a partir de 1 kg de plástico reciclável.");
            return false;
        }

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

        System.out.print("\nDigite o valor a ser pago: ");
        double valor = scanner.nextDouble();
        if (valor < 0) {
            System.out.println("\nErro: Valor Inválido");
            return false;
        }

        System.out.println("\nCrédito (1) | Débito (2) | Pix (3) | Depósito (4)");
        System.out.print("Digite a Forma de Pagamento: ");
        int tipoPagamento = scanner.nextInt();
        if (tipoPagamento <= 0 || tipoPagamento > 4){
            System.out.println("\nErro: Forma de pagamento Inválida");
            return false;
        } EnumFormasPagamento pagamento = EnumFormasPagamento.getByNum(tipoPagamento-1);

        Compra novaCompra = new Compra(posto, processador, pagamento, valor);
        repository.cadastra(novaCompra, 1);
        return true;

    }

}
