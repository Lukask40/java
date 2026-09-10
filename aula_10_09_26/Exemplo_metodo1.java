public class Exemplo_metodo1 {

    public static void mensagem() {
        System.out.println("Seja bem vindo");
    }
        public static void mostrarNome(String nome) {
            System.out.println("O nome informado é: " + nome);
        }

        public static int obterNumero() {
            return 10;
        }
        public static int somar(int n1, int n2) {
            return n1 + n2;
        }
        public static void main(String[] args) {
            mensagem();
            mostrarNome("João");
            int numero = obterNumero();
            System.out.println("O número obtido é: " + numero);
            int resultado = somar(5, 7);
            System.out.println("A soma é: " + resultado);
        }
    
    }
