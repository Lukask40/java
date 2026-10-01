public class Conta {

    private String nomeTitular;
    private String numeroConta;
    private double saldo;

    public Conta(String numeroConta, String nomeTitular, double saldo)
            throws ExcecaoDadoInvalido {

        setNumeroConta(numeroConta);
        setNomeTitular(nomeTitular);
        setSaldo(saldo);
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setNomeTitular(String nomeTitular)
            throws ExcecaoDadoInvalido {

        if (nomeTitular == null || nomeTitular.trim().isEmpty()) {
            throw new ExcecaoDadoInvalido(
                    "O nome do titular não pode ser vazio."
            );
        }

        this.nomeTitular = nomeTitular.trim();
    }

    public void setNumeroConta(String numeroConta)
            throws ExcecaoDadoInvalido {

        if (numeroConta == null || numeroConta.trim().isEmpty()) {
            throw new ExcecaoDadoInvalido(
                    "O número da conta não pode ser vazio."
            );
        }

        this.numeroConta = numeroConta.trim();
    }

    public void setSaldo(double saldo)
            throws ExcecaoDadoInvalido {

        if (saldo < 0) {
            throw new ExcecaoDadoInvalido(
                    "O saldo inicial não pode ser negativo."
            );
        }

        this.saldo = saldo;
    }
}
