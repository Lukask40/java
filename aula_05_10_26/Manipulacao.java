import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Manipulacao {

        public static void main(String[] args) {

            try {
                File arquivo = new File("arquivo.txt");
                if(arquivo.createNewFile()){
                    System.out.println("Arquivo criado com sucesso!"+ arquivo.getName());
                }
                else{
                    System.out.println("Arquivo já existe!");
                }
                }catch(IOException e){
            e.printStackTrace();
        }
    
        try {
            FileWriter writer = new FileWriter("arquivo.txt");
            writer.write("Olá, este é o conteúdo inicial/n");
            writer.write("Linha dois do arquivo/n");
            writer.close();
            System.out.println("Conteúdo escrito com sucesso!");

        }catch(IOException e){
            System.out.println("Erro ao escrever arquivo!"+e.getMessage());
            
        }
        try {
            BufferedReader reader = new BufferedReader(new FileReader("arquivo.txt"));
            String linha;
            System.out.println("(conteúdo do arquivo)");
            while((linha = reader.readLine()) != null){
                System.out.println(linha);

            }
            reader.close();
            }catch(IOException e){
            System.out.println("Erro ao ler arquivo!"+e.getMessage());
        }

        try {
            FileWriter fw = new FileWriter("arquivo.txt");
            fw.write("conteúdo alterado");
            fw.write("Nova informação no aquivo");
            fw.close();

            System.out.println("Conteúdo alterado com sucesso!");
            }catch(IOException e){
            System.out.println("Erro ao alterar o arquivo "+ e.getMessage());
        
        }
        try {
            BufferedReader br = new BufferedReader(new FileReader("arquivo.txt"));
            String linha;
            System.out.println("(conteúdo apos alteração)");
            while((linha = br.readLine()) != null){
                System.out.println(linha);
            
            }
            br.close();
            }catch(IOException e){
            System.out.println("Erro ao ler arquivo "+ e.getMessage());
        }

        File arquivo = new File("arquivo.txt");

        if(arquivo.delete()){
            System.out.println("Arquivo deletado com sucesso!");
        }
        else{
            System.out.println("Erro ao deletar arquivo!");
        }

}
}