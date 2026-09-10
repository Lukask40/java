import java.util.Scanner;

public class ClienteApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int op;

        do {
            System.out.println("\nSistema de Cadastro de Clientes");
            System.out.println("1. Cadastrar Cliente PF");
            System.out.println("2. Cadastrar Cliente PJ");
            System.out.println("0. Sair");
            System.out.print("Digite a opção desejada: ");

            // Validação da entrada
            while (!sc.hasNextInt()) {
                System.out.println("Opção digitada não é válida. Digite um número inteiro.");
                sc.nextLine();
                System.out.print("Digite a opção desejada: ");
            }

            op = sc.nextInt();
            sc.nextLine(); // Limpa o buffer do Scanner

            switch (op) {

                case 1:
                    System.out.print("Digite o nome do cliente PF: ");
                    String nomePF = sc.nextLine();

                    System.out.print("Digite o endereço do cliente PF: ");
                    String enderecoPF = sc.nextLine();

                    System.out.print("Digite o CPF do cliente PF: ");
                    String cpf = sc.nextLine();

                    ClientePF pf = new ClientePF(nomePF, enderecoPF, cpf);

                    System.out.println("\nCliente PF cadastrado com sucesso!");
                    pf.ExibirDados();

                    break;

                case 2:
                    System.out.print("Digite o nome do cliente PJ: ");
                    String nomePJ = sc.nextLine();

                    System.out.print("Digite o endereço do cliente PJ: ");
                    String enderecoPJ = sc.nextLine();

                    System.out.print("Digite o CNPJ do cliente PJ: ");
                    String cnpj = sc.nextLine();

                    ClientePJ pj = new ClientePJ(nomePJ, enderecoPJ, cnpj);

                    System.out.println("\nCliente PJ cadastrado com sucesso!");
                    pj.ExibirDados();

                    break;

                case 0:
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida. Digite novamente.");
                    break;
            }

        } while (op != 0);

        sc.close();
    }
}
