

import java.io.*;
import java.nio.file.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

public class GerenciadorArquivos {

    private static final Path DIRETORIO = Paths.get("LABORATORIO");

    public static void main(String[] args) {
        try {
            Files.createDirectories(DIRETORIO);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao criar o diretório LABORATORIO.");
            return;
        }

        while (true) {
            String opcao = JOptionPane.showInputDialog(
                    null,
                    "GERENCIADOR DE ARQUIVOS\n\n"
                    + "1 - Criar arquivo\n"
                    + "2 - Escrever no arquivo\n"
                    + "3 - Ler arquivo\n"
                    + "4 - Renomear arquivo\n"
                    + "5 - Excluir arquivo\n"
                    + "6 - Mostrar informações do arquivo\n"
                    + "7 - Tornar arquivo somente leitura\n"
                    + "8 - Sair\n\n"
                    + "Escolha uma opção:"
            );

            if (opcao == null) continue;

            switch (opcao) {
                case "1" -> criarArquivo();
                case "2" -> escreverArquivo();
                case "3" -> lerArquivo();
                case "4" -> renomearArquivo();
                case "5" -> excluirArquivo();
                case "6" -> mostrarInformacoes();
                case "7" -> somenteLeitura();
                case "8" -> {
                    JOptionPane.showMessageDialog(null, "Sistema encerrado.");
                    return;
                }
                default -> JOptionPane.showMessageDialog(null, "Opção inválida.");
            }
        }
    }

    private static Path obterArquivo(String mensagem) {
        String nome = JOptionPane.showInputDialog(null, mensagem);

        if (nome == null) return null;

        nome = nome.trim();

        if (nome.isEmpty()) {
            JOptionPane.showMessageDialog(null, "O nome não pode ser vazio.");
            return null;
        }

        if (nome.contains("/") || nome.contains("\\") || nome.equals(".") || nome.equals("..")) {
            JOptionPane.showMessageDialog(null, "Nome de arquivo inválido.");
            return null;
        }

        return DIRETORIO.resolve(nome).normalize();
    }

    private static void criarArquivo() {
        Path arquivo = obterArquivo("Digite o nome do arquivo com extensão:");

        if (arquivo == null) return;

        try {
            if (Files.exists(arquivo)) {
                JOptionPane.showMessageDialog(null, "O arquivo já existe.");
                return;
            }

            Files.createFile(arquivo);
            JOptionPane.showMessageDialog(null, "Arquivo criado com sucesso.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao criar o arquivo.");
        }
    }

    private static void escreverArquivo() {
        Path arquivo = obterArquivo("Digite o nome do arquivo:");

        if (arquivo == null) return;

        if (!Files.isRegularFile(arquivo)) {
            JOptionPane.showMessageDialog(null, "Arquivo não encontrado.");
            return;
        }

        String texto = JOptionPane.showInputDialog(null, "Digite o texto:");

        if (texto == null) return;

        try {
            Files.writeString(
                    arquivo,
                    texto,
                    StandardOpenOption.TRUNCATE_EXISTING,
                    StandardOpenOption.WRITE
            );

            JOptionPane.showMessageDialog(null, "Conteúdo gravado com sucesso.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Não foi possível gravar no arquivo."
            );
        }
    }

    private static void lerArquivo() {
        Path arquivo = obterArquivo("Digite o nome do arquivo:");

        if (arquivo == null) return;

        if (!Files.isRegularFile(arquivo)) {
            JOptionPane.showMessageDialog(null, "Arquivo não encontrado.");
            return;
        }

        try {
            String conteudo = Files.readString(arquivo);

            JOptionPane.showMessageDialog(
                    null,
                    conteudo.isEmpty() ? "(Arquivo vazio)" : conteudo,
                    "Conteúdo do arquivo",
                    JOptionPane.INFORMATION_MESSAGE
            );
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao ler o arquivo.");
        }
    }

    private static void renomearArquivo() {
        Path atual = obterArquivo("Digite o nome atual do arquivo:");

        if (atual == null) return;

        if (!Files.isRegularFile(atual)) {
            JOptionPane.showMessageDialog(null, "Arquivo não encontrado.");
            return;
        }

        Path novo = obterArquivo("Digite o novo nome do arquivo:");

        if (novo == null) return;

        if (Files.exists(novo)) {
            JOptionPane.showMessageDialog(null, "O novo nome já está disponível em outro arquivo.");
            return;
        }

        try {
            Files.move(atual, novo);
            JOptionPane.showMessageDialog(null, "Arquivo renomeado com sucesso.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao renomear o arquivo.");
        }
    }

    private static void excluirArquivo() {
        Path arquivo = obterArquivo("Digite o nome do arquivo:");

        if (arquivo == null) return;

        if (!Files.isRegularFile(arquivo)) {
            JOptionPane.showMessageDialog(null, "Arquivo não encontrado.");
            return;
        }

        int confirmacao = JOptionPane.showConfirmDialog(
                null,
                "Deseja realmente excluir o arquivo?\n" + arquivo.getFileName(),
                "Confirmar exclusão",
                JOptionPane.YES_NO_OPTION
        );

        if (confirmacao != JOptionPane.YES_OPTION) return;

        try {
            Files.delete(arquivo);
            JOptionPane.showMessageDialog(null, "Arquivo excluído com sucesso.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir o arquivo.");
        }
    }

    private static void mostrarInformacoes() {
        Path arquivo = obterArquivo("Digite o nome do arquivo:");

        if (arquivo == null) return;

        if (!Files.isRegularFile(arquivo)) {
            JOptionPane.showMessageDialog(null, "Arquivo não encontrado.");
            return;
        }

        try {
            String nome = arquivo.getFileName().toString();
            String extensao = obterExtensao(nome);
            long tamanho = Files.size(arquivo);
            String caminho = arquivo.toAbsolutePath().normalize().toString();
            boolean leitura = Files.isReadable(arquivo);
            boolean gravacao = Files.isWritable(arquivo);
            boolean execucao = Files.isExecutable(arquivo);
            String modificacao = new SimpleDateFormat(
                    "dd/MM/yyyy HH:mm:ss"
            ).format(new Date(Files.getLastModifiedTime(arquivo).toMillis()));

            String informacoes =
                    "Nome: " + nome
                    + "\nExtensão: " + (extensao.isEmpty() ? "Sem extensão" : extensao)
                    + "\nTamanho: " + tamanho + " bytes"
                    + "\nCaminho completo: " + caminho
                    + "\nPermissão de leitura: " + (leitura ? "Sim" : "Não")
                    + "\nPermissão de gravação: " + (gravacao ? "Sim" : "Não")
                    + "\nPermissão de execução: " + (execucao ? "Sim" : "Não")
                    + "\nÚltima modificação: " + modificacao;

            JOptionPane.showMessageDialog(
                    null,
                    informacoes,
                    "Informações do arquivo",
                    JOptionPane.INFORMATION_MESSAGE
            );

        } catch (IOException e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Erro ao consultar as informações."
            );
        }
    }

    private static void somenteLeitura() {
        Path arquivo = obterArquivo("Digite o nome do arquivo:");

        if (arquivo == null) return;

        if (!Files.isRegularFile(arquivo)) {
            JOptionPane.showMessageDialog(null, "Arquivo não encontrado.");
            return;
        }

        try {
            boolean alterado = arquivo.toFile().setWritable(false);

            JOptionPane.showMessageDialog(
                    null,
                    alterado
                            ? "Arquivo configurado como somente leitura."
                            : "Não foi possível alterar a permissão do arquivo."
            );
        } catch (SecurityException e) {
            JOptionPane.showMessageDialog(
                    null,
                    "O sistema operacional não permitiu alterar a permissão."
            );
        }
    }

    private static String obterExtensao(String nome) {
        int ponto = nome.lastIndexOf('.');

        return ponto > 0 && ponto < nome.length() - 1
                ? nome.substring(ponto + 1)
                : "";
    }
}