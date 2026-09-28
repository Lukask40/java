public class Ex1 {
    public static void main(String[] args) {
        int a = 10;
        int b = 4;

        try {
            int resultado = a / b;
            System.out.println("Resultado: " + resultado);
        } catch (ArithmeticException e) {
            System.out.println("Erro: Não é possivel dividir por zero");
        }
        finally {
            System.out.println("Finalizando");
        }









}
}
