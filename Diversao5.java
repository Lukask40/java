import java.util.Scanner;

public class Diversao5 {
    public static void main(String[] args) {
    Scanner sc =new Scanner(System.in);

        

        System.out.println("Informe a senha: ");
        String senha=sc.nextLine();

        if (senha.equals("LG1234")){
            System.out.println("Porta Aberta.");
        }else{
            System.out.println("Senha não confere.");
        }

        
        sc.close();
    
        }
    }

    

