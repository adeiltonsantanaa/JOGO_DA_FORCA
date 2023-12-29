package principal.controle;

import javafx.scene.control.Alert;
import principal.controle.abstractControle.AbstractArquivoControle;
import principal.enums.ConfiguracaoEnum;
import principal.visao.JogoVisao;

import principal.modelo.JogoModelo;

public class JogoControle extends AbstractArquivoControle {

    private JogoVisao visao;
    private JogoModelo modelo;

    public JogoControle() {
        init();
        criarCena();
    }

    @Override
    protected void init() {
        try {
            Integer qtdTentativas = Integer.parseInt(getConfiguracao(ConfiguracaoEnum.QTD_TENTATIVAS.getChave(), "6"));
            modelo = new JogoModelo(buscarPalavra(), qtdTentativas);
            visao = new JogoVisao();
            visao.getLabelPalavraSecreta().setText(modelo.getPalavraSecretaMascarada());
            visao.getLabelTentativas().setText(modelo.getQuantidadeRestanteTentativas().toString());
            visao.getTextFieldCharTentativa().setOnAction(event -> verificarTentativa());
            visao.getBotaoReiniciarJogo().setOnAction(event -> reiniciarJogo());
            visao.getBotaoTelaInicial().setOnAction(event -> iniciarControleTelaInicial());
        } catch (Exception e) {
            mostrarNotificacao("Erro", e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @Override
    protected void criarCena() {
        atualizarPaginaAtual(visao);
    }

    private void verificarTentativa() {
        char chute = visao.getTextFieldCharTentativa().getText().toLowerCase().charAt(0);
        boolean letraAdivinhada = false;
        for (int i = 0; i < modelo.getPalavraSecreta().length(); i++) {
            if (modelo.getPalavraSecreta().charAt(i) == chute) {
                atualizarCaracteresPalavraSecreta(i, chute, visao);
                letraAdivinhada = true;
            }
        }
        if (!letraAdivinhada) {
            modelo.reduzirTentativasRestantes();
        }
        modelo.addLetrasJaFaladas(chute);
        visao.getLabelLetrasJaFaladas().setText(modelo.getLetrasJaFaladas());
        visao.getLabelTentativas().setText("Tentativas restantes: " + modelo.getQuantidadeRestanteTentativas());
        visao.getTextFieldCharTentativa().clear();
        if (!visao.getLabelPalavraSecreta().getText().contains("_")) {
            finalizarJogo(true);
            
        } else if (modelo.getQuantidadeRestanteTentativas() == 0) {
            finalizarJogo(false);
        }
    }

    private void atualizarCaracteresPalavraSecreta(int indice, char letra, JogoVisao visao) {
        StringBuilder palavraEscondida = new StringBuilder(visao.getLabelPalavraSecreta().getText());
        palavraEscondida.setCharAt(indice * 2, letra);
        visao.getLabelPalavraSecreta().setText(palavraEscondida.toString());
    }

    private void finalizarJogo(Boolean isVitoria) {
        visao.getTextFieldCharTentativa().setDisable(true);
        if (isVitoria) {
            mostrarNotificacao("Parabéns", "Você adivinhou a palavra: " + modelo.getPalavraSecreta(), Alert.AlertType.INFORMATION);
        } else {
            mostrarNotificacao("Game over", "Você errou a palavra: " + modelo.getPalavraSecreta(), Alert.AlertType.INFORMATION);
        }
    }
    
    private void reiniciarJogo() {
        new JogoControle();
    }

    private void iniciarControleTelaInicial() {
        new TelaInicialControle();
    }
}
