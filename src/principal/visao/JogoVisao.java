package principal.visao;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import principal.visao.abstractVisao.AbstractVisao;

public class JogoVisao extends AbstractVisao {

    private Label labelPalavraSecreta;
    private Label labelTentativas;
    private Label labelLetrasJaFaladas;
    private TextField textFieldCharTentativa;
    private Button botaoReiniciarJogo;
    private Button botaoTelaInicial;
    private GridPane gridPane;

    public JogoVisao() {
        init();
    }
    
    @Override
    public GridPane getGridPane() {
        return this.gridPane;
    }

    public void init() {
        this.gridPane = super.iniciarGridPaneELabelErro();
        
        this.labelPalavraSecreta = new Label();
        this.labelTentativas = new Label();
        this.labelLetrasJaFaladas = new Label();
        this.textFieldCharTentativa = new TextField();

        this.botaoReiniciarJogo = new Button("Reiniciar");
        this.botaoReiniciarJogo.setStyle("-fx-min-width: 10em; -fx-min-height: 2em");
        this.botaoTelaInicial = new Button("Tela Inicial");
        this.botaoTelaInicial.setStyle("-fx-min-width: 10em; -fx-min-height: 2em");

        VBox vertical = new VBox(getLabelPalavraSecreta(), getLabelTentativas());
        vertical.setAlignment(Pos.CENTER);
        HBox horizontal = new HBox(vertical);
        horizontal.setAlignment(Pos.CENTER);

        getGridPane().add(horizontal, 0, 0, 2, 1);
        getGridPane().add(getLabelLetrasJaFaladas(), 0, 4);
        getGridPane().add(getTextFieldCharTentativa(), 0, 5, 2, 1);
        getGridPane().add(getBotaoReiniciarJogo(), 0, 6);
        getGridPane().add(getBotaoTelaInicial(), 1, 6);
    }

    public Label getLabelPalavraSecreta() {
        return labelPalavraSecreta;
    }

    public Label getLabelTentativas() {
        return labelTentativas;
    }

    public Label getLabelLetrasJaFaladas() {
        return labelLetrasJaFaladas;
    }

    public TextField getTextFieldCharTentativa() {
        return textFieldCharTentativa;
    }

    public Button getBotaoReiniciarJogo() {
        return botaoReiniciarJogo;
    }

    public Button getBotaoTelaInicial() {
        return botaoTelaInicial;
    }
}
