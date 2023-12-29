package principal;

import principal.controle.abstractControle.AbstractControle;
import javafx.application.Application;
import javafx.stage.Stage;

public class JogoDaForcaJavaFX extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        AbstractControle.inicializarJogo(primaryStage);
    }
}
