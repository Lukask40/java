

public class Cliente  {

    private String nome;

    public Cliente(String nome) {
        this.nome = nome;
    }
    
    public void mostrarDados() {
        System.out.println("Cliente: " + nome);
    }

    public void comprar(String produto) {
        System.out.println("Comprou o produto: " + produto);
    }

    public void comprar(String produto, int quantidade) {
        System.out.println("Comprou o produto: " + produto
                + " | Quantidade: " + quantidade);
    }

    public void comprar(String produto, int quantidade, double valor) {
        System.out.println("Produto: " + produto);
        System.out.println("Quantidade: " + quantidade);
        System.out.println("Valor unitário: R$ " + valor);
        System.out.println("Total: R$ " + (quantidade * valor));
    }

    public void pagar(double valor) {
        System.out.println("Pagamento: R$ " + valor);
    }
}
