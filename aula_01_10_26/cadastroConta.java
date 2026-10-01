import java.util.ArrayList;

public class cadastroConta {

    private static final int LIMITE_CONTAS = 100;

    private ArrayList<Conta> contas;

    public cadastroConta() {
        contas = new ArrayList<>();
    }

    public void inserir(Conta conta)
            throws ExcecaoElementoJaExistente, ExcecaoRepositorio {

        if (conta == null) {
            throw new ExcecaoRepositorio(
                    "Não foi possível cadastrar a conta."
            );
        }

        if (contas.size() >= LIMITE_CONTAS) {
            throw new ExcecaoRepositorio(
                    "Limite máximo de 100 contas atingido."
            );
        }

        if (buscarSemExcecao(conta.getNumeroConta()) != null) {
            throw new ExcecaoElementoJaExistente(
                    "Já existe uma conta com esse número."
            );
        }

        contas.add(conta);
    }

    public Conta buscar(String numeroConta)
            throws ExcecaoElementoInexistente, ExcecaoDadoInvalido {

        if (numeroConta == null || numeroConta.trim().isEmpty()) {
            throw new ExcecaoDadoInvalido(
                    "O número da conta não pode ser vazio."
            );
        }

        Conta conta = buscarSemExcecao(numeroConta.trim());

        if (conta == null) {
            throw new ExcecaoElementoInexistente(
                    "Conta não encontrada."
            );
        }

        return conta;
    }

    public void remover(String numeroConta)
            throws ExcecaoElementoInexistente, ExcecaoDadoInvalido {

        Conta conta = buscar(numeroConta);
        contas.remove(conta);
    }

    private Conta buscarSemExcecao(String numeroConta) {

        for (Conta conta : contas) {
            if (conta.getNumeroConta().equals(numeroConta)) {
                return conta;
            }
        }

        return null;
    }
}
