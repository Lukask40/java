
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Ex6 {
    public static void main(String[] args) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("dado.txt", true));
            bw.write("Primeira linha!/n");
            bw.write("Segunda linha!/n");
            bw.write("Terceira linha!/n");
            bw.newLine();
            bw.write("Quarta linha");
            bw.close();
            System.out.println("Dado escrito com sucesso!");

            
        }catch(IOException e){
            e.printStackTrace();
        }
    


    }
}
