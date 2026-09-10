public class Carro {
    private String marca;
    private String modelo;
    private int anofabricao;

    // Construtor
    public Carro(String marca, String modelo, int anofabricao) {
        this.marca = marca;
        this.modelo = modelo;
        this.anofabricao = anofabricao;
    }

    // Getters e Setters
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnoFabricacao() {
        return anofabricao;
    }

    public void setAnoFabricacao(int anofabricao) {
        this.anofabricao = anofabricao;
    }
}