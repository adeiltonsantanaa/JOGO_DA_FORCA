package principal.modelo;

import principal.util.Util;

public class JogoModelo {

    private final String palavraSecreta;
    private final String palavraSecretaMascarada;
    private final StringBuilder letrasJaFaladas;
    private Integer quantidadeRestanteTentativas;

    public JogoModelo(String palavraSecreta, Integer quantidadeRestanteTentativas) {
        this.palavraSecreta = palavraSecreta;
        this.palavraSecretaMascarada = Util.mascararPalavraSecreta(palavraSecreta);
        this.quantidadeRestanteTentativas = quantidadeRestanteTentativas;
        this.letrasJaFaladas = new StringBuilder();
    }

    public String getPalavraSecreta() {
        return palavraSecreta;
    }

    public Integer getQuantidadeRestanteTentativas() {
        return quantidadeRestanteTentativas;
    }

    public void reduzirTentativasRestantes() {
        this.quantidadeRestanteTentativas--;
    }

    public String getPalavraSecretaMascarada() {
        return palavraSecretaMascarada;
    }

    public String getLetrasJaFaladas() {
        return letrasJaFaladas.toString();
    }

    public void addLetrasJaFaladas(Character letrasJaFaladas) {
        if (!getLetrasJaFaladas().isEmpty()) {
            this.letrasJaFaladas.append(", ");
        }
        this.letrasJaFaladas.append(letrasJaFaladas);
    }
}
