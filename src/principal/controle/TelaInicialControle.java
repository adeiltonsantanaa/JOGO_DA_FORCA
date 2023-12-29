package principal.controle;

import principal.controle.abstractControle.AbstractControle;
import principal.visao.TelaInicialVisao;

public class TelaInicialControle extends AbstractControle {

    private TelaInicialVisao visao;

    public TelaInicialControle() {
        init();
        criarCena();
    }

    @Override
    protected void init() {
        visao = new TelaInicialVisao("Jogo da Forca");
        visao.getBotaoIniciarJogo().setOnAction(event -> iniciarControleJogo());
        visao.getBotaoConfiguracao().setOnAction(event -> iniciarControleConfiguracao());
    }

    @Override
    protected void criarCena() {
        atualizarPaginaAtual(visao);
    }

    private void iniciarControleJogo() {
        new JogoControle();
    }

    private void iniciarControleConfiguracao() {
        new ConfiguracaoControle();
    }

}
