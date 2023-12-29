package principal.visao;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import principal.visao.abstractVisao.AbstractVisao;

public class TelaInicialVisao extends AbstractVisao {

    private Button botaoIniciarJogo;
    private Button botaoConfiguracao;
    private GridPane gridPane;

    public TelaInicialVisao(String tituloPagina) {
        super(tituloPagina);
        init();
    }

    @Override
    public GridPane getGridPane() {
        return this.gridPane;
    }


    public void init() {
        this.gridPane = super.iniciarGridPaneELabelErro();

        this.botaoIniciarJogo = new Button("Iniciar Jogo");
        this.botaoIniciarJogo.setStyle("-fx-min-width: 10em; -fx-min-height: 2em");

        this.botaoConfiguracao = new Button("Configurações");
        this.botaoConfiguracao.setStyle("-fx-min-width: 10em; -fx-min-height: 2em");

        getGridPane().add(getBotaoIniciarJogo(), 0, 1);
        getGridPane().add(getBotaoConfiguracao(), 1, 1);
    }

    public Button getBotaoIniciarJogo() {
        return botaoIniciarJogo;
    }
    
    public Button getBotaoConfiguracao() {
        return botaoConfiguracao;
    }
}
