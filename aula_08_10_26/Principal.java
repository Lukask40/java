import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Principal {

    public static void main(String[] args) {

        ArrayList<Carro> carros = new ArrayList<>();

        int opcao;

        do {
            String menu = """
                    SISTEMA DE CADASTRO DE CARROS
                    
                    1 - Cadastrar Carro
                    2 - Listar Carros
                    3 - Detalhar Carro
                    4 - Alterar Carro
                    5 - Remover Carro
                    6 - Gravar Informações em Arquivo
                    7 - Sair
                    
                    Escolha uma opção:
                    """;

            try {
                opcao = Integer.parseInt(
                        JOptionPane.showInputDialog(menu)
                );
            } catch (Exception e) {
                opcao = 0;
            }

            switch (opcao) {

                case 1:
                    String marca = JOptionPane.showInputDialog(
                            "Digite a marca do carro:"
                    );

                    String modelo = JOptionPane.showInputDialog(
                            "Digite o modelo do carro:"
                    );

                    int ano = Integer.parseInt(
                            JOptionPane.showInputDialog(
                                    "Digite o ano do carro:"
                            )
                    );

                    Carro carro = new Carro(marca, modelo, ano);
                    carros.add(carro);

                    JOptionPane.showMessageDialog(
                            null,
                            "Carro cadastrado com sucesso!"
                    );
                    break;

                case 2:
                    if (carros.isEmpty()) {
                        JOptionPane.showMessageDialog(
                                null,
                                "Nenhum carro cadastrado."
                        );
                    } else {
                        String lista = "CARROS CADASTRADOS\n\n";

                        for (int i = 0; i < carros.size(); i++) {
                            lista += (i + 1) + " - "
                                    + carros.get(i).getMarca()
                                    + " - "
                                    + carros.get(i).getModelo()
                                    + "\n";
                        }

                        JOptionPane.showMessageDialog(
                                null,
                                lista
                        );
                    }
                    break;

                case 3:
                    if (carros.isEmpty()) {
                        JOptionPane.showMessageDialog(
                                null,
                                "Nenhum carro cadastrado."
                        );
                    } else {
                        String lista = "Escolha o número do carro:\n\n";

                        for (int i = 0; i < carros.size(); i++) {
                            lista += (i + 1) + " - "
                                    + carros.get(i).getMarca()
                                    + " - "
                                    + carros.get(i).getModelo()
                                    + "\n";
                        }

                        try {
                            int numero = Integer.parseInt(
                                    JOptionPane.showInputDialog(lista)
                            );

                            if (numero >= 1 && numero <= carros.size()) {
                                JOptionPane.showMessageDialog(
                                        null,
                                        carros.get(numero - 1).exibirDetalhes()
                                );
                            } else {
                                JOptionPane.showMessageDialog(
                                        null,
                                        "Número inválido."
                                );
                            }

                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(
                                    null,
                                    "Valor inválido."
                            );
                        }
                    }
                    break;

                case 4:
                    if (carros.isEmpty()) {
                        JOptionPane.showMessageDialog(
                                null,
                                "Nenhum carro cadastrado."
                        );
                    } else {
                        String lista = "Escolha o carro que deseja alterar:\n\n";

                        for (int i = 0; i < carros.size(); i++) {
                            lista += (i + 1) + " - "
                                    + carros.get(i).getMarca()
                                    + " - "
                                    + carros.get(i).getModelo()
                                    + "\n";
                        }

                        try {
                            int numero = Integer.parseInt(
                                    JOptionPane.showInputDialog(lista)
                            );

                            if (numero >= 1 && numero <= carros.size()) {

                                String novaMarca = JOptionPane.showInputDialog(
                                        "Digite a nova marca:"
                                );

                                String novoModelo = JOptionPane.showInputDialog(
                                        "Digite o novo modelo:"
                                );

                                int novoAno = Integer.parseInt(
                                        JOptionPane.showInputDialog(
                                                "Digite o novo ano:"
                                        )
                                );

                                Carro novoCarro = new Carro(
                                        novaMarca,
                                        novoModelo,
                                        novoAno
                                );

                                carros.set(numero - 1, novoCarro);

                                JOptionPane.showMessageDialog(
                                        null,
                                        "Carro alterado com sucesso!"
                                );

                            } else {
                                JOptionPane.showMessageDialog(
                                        null,
                                        "Número inválido."
                                );
                            }

                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(
                                    null,
                                    "Valor inválido."
                            );
                        }
                    }
                    break;

                case 5:
                    if (carros.isEmpty()) {
                        JOptionPane.showMessageDialog(
                                null,
                                "Nenhum carro cadastrado."
                        );
                    } else {
                        String lista = "Escolha o carro que deseja remover:\n\n";

                        for (int i = 0; i < carros.size(); i++) {
                            lista += (i + 1) + " - "
                                    + carros.get(i).getMarca()
                                    + " - "
                                    + carros.get(i).getModelo()
                                    + "\n";
                        }

                        try {
                            int numero = Integer.parseInt(
                                    JOptionPane.showInputDialog(lista)
                            );

                            if (numero >= 1 && numero <= carros.size()) {

                                carros.remove(numero - 1);

                                JOptionPane.showMessageDialog(
                                        null,
                                        "Carro removido com sucesso!"
                                );

                            } else {
                                JOptionPane.showMessageDialog(
                                        null,
                                        "Número inválido."
                                );
                            }

                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(
                                    null,
                                    "Valor inválido."
                            );
                        }
                    }
                    break;

                case 6:
                    try {
                        FileWriter arquivo = new FileWriter("carros.txt");

                        for (Carro c : carros) {
                            arquivo.write(
                                    "Marca: " + c.getMarca() + "\n"
                                    + "Modelo: " + c.getModelo() + "\n"
                                    + "Ano: " + c.getAno() + "\n"
                                    + "-------------------------\n"
                            );
                        }

                        arquivo.close();

                        JOptionPane.showMessageDialog(
                                null,
                                "Informações gravadas em carros.txt"
                        );

                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(
                                null,
                                "Erro ao gravar o arquivo."
                        );
                    }
                    break;

                case 7:
                    JOptionPane.showMessageDialog(
                            null,
                            "Sistema encerrado."
                    );
                    break;

                default:
                    JOptionPane.showMessageDialog(
                            null,
                            "Opção inválida."
                    );
            }

        } while (opcao != 7);
    }
}