package principal.visao.abstractVisao;

import javafx.scene.layout.GridPane;

public abstract class AbstractVisao {
    
    private final String tituloPagina;

    public AbstractVisao(String tituloPagina) {
        this.tituloPagina = tituloPagina;
    }

    public AbstractVisao() {
        this.tituloPagina = "Jogo da Forca";
    }
    
    public GridPane iniciarGridPaneELabelErro() {
        GridPane grid = new GridPane();
        grid.setAlignment(javafx.geometry.Pos.CENTER);
        grid.setHgap(5);
        grid.setVgap(5);
        return grid;
    }

    public abstract GridPane getGridPane();

    public String getTituloPagina() {
        return tituloPagina;
    }
    
}
