public class ClientePJ extends Cliente {
    private String cnpj;

    public ClientePJ(String nome, String endereco, String cnpj) {
        super(nome, endereco);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public void ExibirDados() {
        super.ExibirDados();
        System.out.println("CNPJ: " + cnpj);
    }
    
}
