import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws ParseException {

        Scanner scanner = new Scanner(System.in);

        int opcao;
        Loja loja = null;

        do {
            System.out.println("Menu:");
            System.out.println("(1) Criar uma loja");
            System.out.println("(2) Criar um produto");
            System.out.println("(3) Sair");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> {
                    //loja
                    System.out.println("Digite o nome da loja: ");
                    String nome = scanner.nextLine();
                    scanner.nextLine();
                    System.out.println("Digite a quantidade de funcionários: ");
                    int quantidadeFuncionarios = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Digite o salário base dos funcionários: ");
                    double salarioBaseFuncionario = scanner.nextDouble();
                    scanner.nextLine();
                    //endereço
                    System.out.println("Digite a rua da loja: ");
                    String nomeDaRua = scanner.nextLine();
                    System.out.println("Digite a cidade da loja: ");
                    String cidade = scanner.nextLine();
                    System.out.println("Digite o estado da loja: ");
                    String estado = scanner.nextLine();
                    System.out.println("Digite o país da loja: ");
                    String pais = scanner.nextLine();
                    System.out.println("Digite o CEP da loja: ");
                    String cep = scanner.nextLine();
                    System.out.println("Digite o número da loja: ");
                    String numero = scanner.nextLine();
                    System.out.println("Digite o complemento da loja: ");
                    String complemento = scanner.nextLine();
                    Endereco endereco = new Endereco(nomeDaRua, cidade, estado, pais, cep, numero, complemento);
                    //fundação
                    System.out.println("Digite a data de fundação da loja: ");
                    String inputData = scanner.nextLine();
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    Date date = formatter.parse(inputData);
                    Calendar novaData = Calendar.getInstance();
                    novaData.setTime(date);
                    System.out.println("\n");

                    Data dataFund = new Data(novaData.get(Calendar.DAY_OF_MONTH), (novaData.get(Calendar.MONTH) + 1), novaData.get(Calendar.YEAR));
                    loja = new Loja(nome, quantidadeFuncionarios, salarioBaseFuncionario, endereco, dataFund, 5);
                    System.out.println("Loja criada com sucesso!");
                    System.out.printf("%s\n%s\nFundada em: %s\n", loja, endereco, dataFund);
                    loja.imprimeProdutos();
                }
                case 2 -> {
                    //produto
                    System.out.println("Digite o nome do produto: ");
                    String nome = scanner.next();
                    System.out.println("Digite o preço do produto: ");
                    double preco = scanner.nextDouble();
                    //validade
                    // Digite uma data usando o padrão DD/MM/AAAA -> EX: 30/04/2023 -> dia/mês/ano
                    System.out.println("Digite a data de vencimento do produto: (DD/MM/AAAA -> EX: 30/04/2023)");
                    System.out.println("\n");
                    String inputData = scanner.next();
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    Date date = formatter.parse(inputData);
                    Calendar novaData = Calendar.getInstance();
                    novaData.setTime(date);
                    System.out.println("\n");
                    Data validade = new Data(novaData.get(Calendar.DAY_OF_MONTH), (novaData.get(Calendar.MONTH) + 1), novaData.get(Calendar.YEAR));
                    Produto produto = new Produto(nome, preco, validade);
                    loja.insereProduto(produto);
                    System.out.println("Produto criado com sucesso!");
                    System.out.printf("%s\n%s\n", produto, validade);
                    loja.imprimeProdutos();
                    if (produto.estaVencido(validade)) {
                        System.out.println("PRODUTO VENCIDO");
                    } else {
                        System.out.println("PRODUTO NÃO VENCIDO");
                    }
                }
                case 3 -> scanner.close();
                default -> System.out.println("Opção inválida");
            }
        } while
        (opcao != 3);
    }
}