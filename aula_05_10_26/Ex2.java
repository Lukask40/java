import java.io.FileWriter;
import java.io.IOException;

public class Ex2 {
    public static void main(String[] args) {

        try {
            FileWriter escritor = new FileWriter("exemplo.txt", true);
            escritor.write("Primeira linha!");
            escritor.write("Segunda linha!");
            escritor.write("Terceira linha!");

            escritor.close();
            System.out.println("Escrita realizada com sucesso!");

        }catch(IOException e){
            System.out.println("Erro ao escrever arquivo!");
            e.printStackTrace();
        }
    
}
}
