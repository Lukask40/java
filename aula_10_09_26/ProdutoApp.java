
import java.util.Scanner;

public class ProdutoApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Produto p = new Produto(null, 0.0, 0);

        System.out.println("Digite o nome do produto: ");
        p.setNome(sc.nextLine());

        System.out.println("Digite o preço do produto: ");
        p.setPreco(sc.nextDouble());

        System.out.println("Digite a quantidade do produto: ");
        p.setQuantidade(sc.nextInt());

        System.out.println("Produto cadastrado: " + p.getNome() + ", Preço: " + p.getPreco() + ", Quantidade: " + p.getQuantidade());



    sc.close();
}
}
