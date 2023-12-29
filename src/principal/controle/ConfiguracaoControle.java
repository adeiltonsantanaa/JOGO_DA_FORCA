package principal.controle;

import principal.controle.abstractControle.AbstractControle;
import principal.enums.ConfiguracaoEnum;
import principal.visao.ConfiguracaoVisao;

public class ConfiguracaoControle extends AbstractControle {

    private ConfiguracaoVisao visao;

    public ConfiguracaoControle() {
        init();
        criarCena();
    }

    @Override
    protected void init() {
        visao = new ConfiguracaoVisao("Configuração");
        visao.getBotaoGravar().setOnAction(event -> gravarInformacoesConfiguracao());
        visao.getBotaoTelaInicial().setOnAction(event -> iniciarControleTelaInicial());
        visao.getBotaoResetarConfiguracao().setOnAction(event -> resetarConfiguracaoParaPadrao());
        iniciarConfiguracao();
    }

    private void iniciarConfiguracao() {
        visao.getTextFieldQuantidadeTentativas().setText(getConfiguracao(ConfiguracaoEnum.QTD_TENTATIVAS.getChave(), ConfiguracaoEnum.QTD_TENTATIVAS.getValorPadrao()));
        visao.getComboBoxDificuldade().setValue(getConfiguracao(ConfiguracaoEnum.DIFICULDADE.getChave(), ConfiguracaoEnum.DIFICULDADE.getValorPadrao()));
    }

    @Override
    protected void criarCena() {
        atualizarPaginaAtual(visao);
    }


    private void iniciarControleTelaInicial() {
        new TelaInicialControle();
    }

    private void gravarInformacoesConfiguracao() {
        salvarConfiguracao(ConfiguracaoEnum.QTD_TENTATIVAS.getChave(), visao.getTextFieldQuantidadeTentativas().getText());
        salvarConfiguracao(ConfiguracaoEnum.DIFICULDADE.getChave(), visao.getComboBoxDificuldade().getValue());
    }

    private void resetarConfiguracaoParaPadrao() {
        resetarConfiguracao();
        new ConfiguracaoControle();
    }

}
