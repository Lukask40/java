import java.util.InputMismatchException;
import java.util.Scanner;

public class Diversao{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Digite o valor do pagamento: ");
            double valor = scanner.nextDouble();

            System.out.print("Digite a quantidade de parcelas: ");
            int parcelas = scanner.nextInt();

            if (valor < 0 || parcelas < 0) {
                throw new IllegalArgumentException("Valores não podem ser negativos.");
            }

            if (parcelas == 0) {
                throw new ArithmeticException("Não é possível dividir por zero.");
            }

            double valorParcela = valor / parcelas;

            System.out.printf("Valor de cada parcela: R$ %.2f%n", valorParcela);

        } catch (InputMismatchException e) {
            System.out.println("Erro: digite valores numéricos válidos.");
        } catch (ArithmeticException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            System.out.println("Operação encerrada.");
            scanner.close();
        }
    }
}