
import java.io.FileWriter;
import java.io.IOException;


public class Ex4 {
        public static void main(String[] args) {

            try {
                FileWriter fw = new FileWriter("dado.txt");

                fw.write("Primeira linha!/n");
                fw.write("Segunda linha!/n");
                fw.write("Terceira linha!/n");
                fw.close();
                System.out.println("Dado escrito com sucesso!");
            }catch(IOException e){
            e.printStackTrace();
        }
    
}
}