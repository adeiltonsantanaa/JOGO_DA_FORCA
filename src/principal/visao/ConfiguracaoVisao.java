package principal.visao;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import principal.visao.abstractVisao.AbstractVisao;

public class ConfiguracaoVisao extends AbstractVisao {

    private Label labelQuantidadeTentativas;
    private Label labelDificuldade;
    private TextField textFieldQuantidadeTentativas;
    private ComboBox<String> comboBoxDificuldade;
    private Button botaoGravar;
    private Button botaoTelaInicial;
    private Button botaoResetarConfiguracao;
    private GridPane gridPane;

    public ConfiguracaoVisao(String tituloPagina) {
        super(tituloPagina);
        init();
    }

    @Override
    public GridPane getGridPane() {
        return this.gridPane;
    }

    private void init() {
        this.gridPane = super.iniciarGridPaneELabelErro();

        this.labelQuantidadeTentativas = new Label();
        this.labelQuantidadeTentativas.setText("Informe a Quantidade de Tentativas");

        this.textFieldQuantidadeTentativas = new TextField();

        this.labelDificuldade = new Label();
        this.labelDificuldade.setText("Informe a Dificuldade das Palavras");

        this.comboBoxDificuldade = new ComboBox<>();
        this.comboBoxDificuldade.getItems().addAll("Fácil", "Médio", "Difícil");
        this.comboBoxDificuldade.setStyle("-fx-min-width: 20.4em;");

        this.botaoGravar = new Button();
        this.botaoGravar.setText("Gravar");
        this.botaoGravar.setStyle("-fx-min-width: 10em; -fx-min-height: 2em");

        this.botaoTelaInicial = new Button();
        this.botaoTelaInicial.setText("Tela Inicial");
        this.botaoTelaInicial.setStyle("-fx-min-width: 10em; -fx-min-height: 2em");

        this.botaoResetarConfiguracao = new Button();
        this.botaoResetarConfiguracao.setText("Resetar Configuração");
        this.botaoResetarConfiguracao.setStyle("-fx-min-width: 20.4em;");

        getGridPane().add(getLabelQuantidadeTentativas(), 0, 1, 2, 1);
        getGridPane().add(getTextFieldQuantidadeTentativas(), 0, 2, 2, 1);
        getGridPane().add(getLabelDificuldade(), 0, 3, 2, 1);
        getGridPane().add(getComboBoxDificuldade(), 0, 4, 2, 1);
        getGridPane().add(getBotaoGravar(), 0, 5);
        getGridPane().add(getBotaoTelaInicial(), 1, 5);
        getGridPane().add(getBotaoResetarConfiguracao(), 0, 6, 2, 1);
    }

    public Label getLabelQuantidadeTentativas() {
        return labelQuantidadeTentativas;
    }

    public TextField getTextFieldQuantidadeTentativas() {
        return textFieldQuantidadeTentativas;
    }

    public Button getBotaoGravar() {
        return botaoGravar;
    }

    public Button getBotaoTelaInicial() {
        return botaoTelaInicial;
    }

    public Button getBotaoResetarConfiguracao() {
        return botaoResetarConfiguracao;
    }

    public Label getLabelDificuldade() {
        return labelDificuldade;
    }

    public ComboBox<String> getComboBoxDificuldade() {
        return comboBoxDificuldade;
    }
    
}
