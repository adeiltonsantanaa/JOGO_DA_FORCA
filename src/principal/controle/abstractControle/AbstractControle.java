package principal.controle.abstractControle;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import principal.controle.TelaInicialControle;
import principal.enums.ConfiguracaoEnum;
import principal.visao.abstractVisao.AbstractVisao;

import java.util.prefs.Preferences;

public abstract class AbstractControle {
    
    private static final Integer WIDTH_PADRAO_TELA = 800;
    private static final Integer HEIGHT_PADRAO_TELA = 600;
    private static Preferences preferencias;
    private static Stage stage;

    public static void inicializarJogo(Stage primaryStage) {
        stage = primaryStage;
        new TelaInicialControle();
    }

    protected static void salvarConfiguracao(String chave, String valor) {
        getPreferencias().put(chave, valor);
    }

    protected static String getConfiguracao(String chave, String valor) {
        return getPreferencias().get(chave, valor);
    }

    protected static void resetarConfiguracao() {
        try {
            getPreferencias().clear();
        } catch (Exception e) {
            preferencias = Preferences.userNodeForPackage(AbstractControle.class);
        } finally {
            salvarConfiguracao(ConfiguracaoEnum.QTD_TENTATIVAS.getChave(), ConfiguracaoEnum.QTD_TENTATIVAS.getValorPadrao());
            salvarConfiguracao(ConfiguracaoEnum.DIFICULDADE.getChave(), ConfiguracaoEnum.DIFICULDADE.getValorPadrao());
        }
    }

    private static Preferences getPreferencias() {
        if (preferencias == null) {
            preferencias = Preferences.userNodeForPackage(AbstractControle.class);
        }
        return preferencias;
    }

    protected abstract void init();

    protected abstract void criarCena();

    protected void atualizarPaginaAtual(AbstractVisao telaAtual) {
        stage.setTitle(telaAtual.getTituloPagina());
        stage.setScene(new Scene(telaAtual.getGridPane(), WIDTH_PADRAO_TELA, HEIGHT_PADRAO_TELA));
        stage.show();
    }
    
    protected void mostrarNotificacao(String titulo, String mensagem, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}
