

public class CalcApp {
    public static void main(String[] args) {
        Calculadora calc = new Calculadora();
        System.out.println("Soma de 2 números: " + calc.somar(10, 20));
        System.out.println("Soma de 3 números: " + calc.somar(10, 20, 30));
        System.out.println("Soma de 2 números decimais: " + calc.somar(10.5, 20.3));
    }
    
}
