package br.com.example.view;
import java.util.ArrayList;
import java.util.Scanner;

import br.com.example.controle.ProdutoControle;
import br.com.example.modelo.Produto;



public class ProdutoView {
    private Scanner sc = new Scanner(System.in);
    private ProdutoControle controle = new ProdutoControle();

    public void menu() {
        int opcao;
        do {
            System.out.println("Menu de Produtos");
            System.out.println("1. Cadastrar Produto");
            System.out.println("2. Listar Produtos");
            System.out.println("3. Buscar Produtos");
            System.out.println("4. alterar Produtos");
            System.out.println("5. remover Produtos");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    cadastrar();
                    break;
                case 2:
                    listar();
                    break;
                case 3:
                    buscar();
                    break;
                case 4:
                    alterar();
                    break;
                case 5:
                    remover();
                    break;
                case 0:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
        sc.close();
    }
    private  void cadastrar() {
        System.out.println("Cadastro de Produto");
        System.out.print("Digite o código do produto: ");
        int codigo = sc.nextInt();
        sc.nextLine();

        System.out.print("Digite o nome do produto: ");
        String nome = sc.nextLine();
        System.out.print("Digite o preço do produto: ");
        double preco = sc.nextDouble();
        sc.nextLine();

        if (controle.cadastrar(codigo, nome, preco)) {
            System.out.println("Produto cadastrado com sucesso!");
        } else {
            System.out.println("Erro ao cadastrar produto. ");
        }
    }
    private void listar() {
        System.out.println("Lista de Produtos");
        ArrayList <Produto> produtos = controle.listar();
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            for (Produto produto : produtos) {
                System.out.println("Código: " + produto.getCodigo() + ", Nome: " + produto.getNome() + ", Preço: " + produto.getPreco());
                System.out.println("---------------------------");
            }
    }

}
    private void buscar() {
        System.out.println("Buscar Produto");
        System.out.print("Digite o código do produto: ");
        int codigo = sc.nextInt();
        sc.nextLine();

        Produto produto = controle.buscar(codigo);
        if (produto != null) {
            System.out.println("Produto encontrado:");
            System.out.println("Código: " + produto.getCodigo() + ", Nome: " + produto.getNome() + ", Preço: " + produto.getPreco());
        } else {
            System.out.println("Produto não encontrado.");
        }
    }
    private void alterar() {
        System.out.println("Alterar Produto");
        int codigo = sc.nextInt();
        sc.nextLine();
        Produto produto = controle.buscar(codigo);

        if (produto == null) {
            System.out.println("Produto não encontrado.");
            return;
        }
        System.out.print("Digite o novo nome do produto: ");
        String nome = sc.nextLine();
        System.out.print("Digite o novo preço do produto: ");
        double preco = sc.nextDouble();
        sc.nextLine();

        if (controle.alterar(codigo, nome, preco)) {
            System.out.println("Produto alterado com sucesso!");
        } else {
            System.out.println("Erro ao alterar produto.");
        }
}
        private void remover() {
        System.out.println("Remover Produto");
        System.out.print("Digite o código do produto: ");
        int codigo = sc.nextInt();
        sc.nextLine();
        if (controle.remover(codigo)) {
            System.out.println("Produto removido com sucesso!");
        } else {
            System.out.println("Produto não encontrado.");
}
        }
}
