package principal.controle.abstractControle;

import principal.enums.ConfiguracaoEnum;
import principal.excecoes.PalavraNaoEncontradaException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public abstract class AbstractArquivoControle extends AbstractControle {

    private static final String CAMINHO_ARQUIVO_PALAVRAS;
    private static final Pattern REGEX_FACIL = Pattern.compile("\\b[a-zA-Z]{1,4}\\b");
    private static final Pattern REGEX_MEDIO = Pattern.compile("\\b[a-zA-Z]{11,}\\b");
    private static final Pattern REGEX_DIFICIL = Pattern.compile("\\b\\p{L}{11,}\\b");

    static {
        CAMINHO_ARQUIVO_PALAVRAS = Files.isReadable(Paths.get("recursos/palavras.txt")) ? "recursos/palavras.txt" : "src/recursos/palavras.txt";
    }

    protected static String buscarPalavra() throws PalavraNaoEncontradaException {
        return buscarPalavra(lerArquivo());
    }

    private static List<String> lerArquivo() {
        try (BufferedReader br = new BufferedReader(new FileReader(CAMINHO_ARQUIVO_PALAVRAS))) {
            List<String> palavras = new ArrayList<>();
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] palavrasDivididas = linha.split(",");
                for (String palavra : palavrasDivididas) {
                    palavras.add(palavra.trim());
                }
            }
            return palavras;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    private static String buscarPalavra(List<String> palavras) throws PalavraNaoEncontradaException {
        if (palavras.isEmpty()) {
            throw new PalavraNaoEncontradaException("Nenhuma Palavra Encontrada, Verifique o Arquivo de Palavras!");
        }
        return realizarFiltroListaPalavrasConsiderandoDificuldade(palavras);
    }

    private static String realizarFiltroListaPalavrasConsiderandoDificuldade(List<String> palavras) throws PalavraNaoEncontradaException {
        String dificuldade = getConfiguracao(ConfiguracaoEnum.DIFICULDADE.getChave(), ConfiguracaoEnum.DIFICULDADE.getValorPadrao());
        List<String> palavrasFiltradas = new ArrayList<>();
        
        if (dificuldade.equals("Fácil")) {
            palavrasFiltradas = realizarFiltroListaPalavras(palavras, REGEX_FACIL);
        }
        if (dificuldade.equals("Médio")) {
            palavrasFiltradas = realizarFiltroListaPalavras(palavras, REGEX_MEDIO);
        }
        if (dificuldade.equals("Difícil")) {
            palavrasFiltradas = realizarFiltroListaPalavras(palavras, REGEX_DIFICIL);
        }
        
        return realizarBuscaPalavraFiltradaPorDificuldade(palavrasFiltradas, dificuldade);
    }
    
    private static String realizarBuscaPalavraFiltradaPorDificuldade(List<String> palavras, String dificuldade) throws PalavraNaoEncontradaException {
        if (palavras.isEmpty()) {
            throw new PalavraNaoEncontradaException("Nenhuma Palavra Encontrada para o Nível "+dificuldade+", Adicione Novas Palavras!");
        }
        return palavras.get(new Random().nextInt(palavras.size()));
    }
    
    private static List<String> realizarFiltroListaPalavras(List<String> palavras, Pattern regex) {
        return palavras.stream().filter(p -> regex.matcher(p).matches()).collect(Collectors.toList());
    }

    private static String verificarExistenciaPalavraSelecionada(List<String> palavras, String palavraBusca) {
        return palavras.stream().filter(p -> p.equals(palavraBusca)).findFirst().orElseGet(() -> adicionarNovaPalavra(palavraBusca));
    }

    protected static String adicionarNovaPalavra(String novaPalavra) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CAMINHO_ARQUIVO_PALAVRAS, true))) {
            String sb = ", " + novaPalavra;
            writer.write(sb);
            return sb.replaceAll("[,\\s]+", "");
        } catch (Exception e) {
            return "";
        }
    }
}
