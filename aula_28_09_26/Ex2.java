public class Ex2 {

    public static void main(String[] args) {
        int [] numeros = {10, 20, 30};

        try {
            System.out.println(numeros[2]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Erro: Indice fora do limite");
        } finally {
            System.err.println("Finalizando");
        }


    
}
}
