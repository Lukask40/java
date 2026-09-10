public class PessoaApp {
    public static void main(String[] args) {
        // Criando um objeto da classe Pessoa
        Pessoa p1 = new Pessoa(1, "Maria");
        Pessoa p2 = new Pessoa(2, "João");

        // Exibindo informações da pessoa1
        System.out.println("Pessoa 1 - Código: " + p1.getCodigo() + ", Nome: " + p1.getNome());

        // Alterando o nome da pessoa1
        p1.setNome("Ana");
        System.out.println("Pessoa 1 após alteração - Código: " + p1.getCodigo() + ", Nome: " + p1.getNome());
    }
    
}
