import java.util.Scanner;

public class Ex_array6 {
    public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    System.out.println("Digite a quantidade de pessoas: ");
    int quantidade = sc.nextInt();
    sc.nextLine(); // limpa o Enter

    String[] nomes = new String[quantidade];
    int[] idades = new int[quantidade];

    for (int i = 0; i < quantidade; i++) {

        System.out.println("Digite o nome: ");
        nomes[i] = sc.nextLine();

        System.out.println("Digite a idade: ");
        idades[i] = sc.nextInt();
        sc.nextLine(); // limpa o Enter
    }

    for (int i = 0; i < quantidade; i++) {
        System.out.println("Nome: " + nomes[i]);
        System.out.println("Idade: " + idades[i] + " anos");
    }

    sc.close();
}


}
