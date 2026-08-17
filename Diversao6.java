import java.util.Scanner;

public class Diversao6 {
    
    public static void main(String[] args) {
    Scanner sc =new Scanner(System.in);

    System.out.println("Digite o operador (+, -, *, /): ");
    String operador=sc.nextLine();
    System.out.println("Digite o OPERANDO1: ");
    double operando1=sc.nextDouble();
    System.out.println("Digite o OPERANDO2: ");
    double operando2=sc.nextDouble();

    double resultado = 0;



    if (operador.equals("+")){
        resultado = operando1 + operando2;

    } else if ( operador.equals("-")){
        resultado = operando1 - operando2;

    }else if (operador.equals("*")){
        resultado = operando1 * operando2;

    }else if (operador.equals("/")){
        resultado = operando1 / operando2;
    }else{
        System.out.println( "Erro: operador inválido!");
}
        System.out.printf("O resultado é: %.2f",resultado);
        

        
        sc.close();
    
        }
    }

