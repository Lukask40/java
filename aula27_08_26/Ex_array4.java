import java.util.Scanner;

public class Ex_array4 {
    
    public static void main(String[] args) {
    String[] nomes = new String[3];
    Scanner sc = new Scanner(System.in);

    // Inserir os nomes
    for (int i = 0; i < nomes.length; i++) {
        System.out.println("Informe o nome: ");
        nomes[i] = sc.nextLine();
    }

    // Mostrar os nomes cadastrados
    System.out.println("Nomes cadastrados são:");

    for (String nome : nomes) {
        System.out.println(nome);
        
    } for (int i = 0; i < nomes.length; i++) {
    System.out.println((i + 1) + " - " + nomes[i]);
}


    sc.close();
}
}
    
