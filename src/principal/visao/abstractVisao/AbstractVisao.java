package principal.visao.abstractVisao;

import javafx.scene.layout.GridPane;

public abstract class AbstractVisao {
    
    private static final Integer WIDTH_PADRAO_TELA = 800;
    private static final Integer HEIGHT_PADRAO_TELA = 600;
    private final Integer widthPadraoTela;
    private final Integer heightPadraoTela;
    private final String tituloPagina;

    public AbstractVisao(String tituloPagina) {
        this.tituloPagina = tituloPagina;
        this.widthPadraoTela = WIDTH_PADRAO_TELA;
        this.heightPadraoTela = HEIGHT_PADRAO_TELA;
    }

    public AbstractVisao() {
        this.tituloPagina = "Jogo da Forca";
        this.widthPadraoTela = WIDTH_PADRAO_TELA;
        this.heightPadraoTela = HEIGHT_PADRAO_TELA;
    }
    
    public AbstractVisao(Integer widthPadraoTela, Integer heightPadraoTela, String tituloPagina) {
        this.widthPadraoTela = widthPadraoTela;
        this.heightPadraoTela = heightPadraoTela;
        this.tituloPagina = tituloPagina;
    }

    public AbstractVisao(Integer widthPadraoTela, Integer heightPadraoTela) {
        this.widthPadraoTela = widthPadraoTela;
        this.heightPadraoTela = heightPadraoTela;
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
    
    public Integer getWidthPadraoTela() {
        return widthPadraoTela;
    }
    
    public Integer getHeightPadraoTela() {
        return heightPadraoTela;
    }
    
}
