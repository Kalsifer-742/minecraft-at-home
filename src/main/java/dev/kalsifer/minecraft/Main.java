package dev.kalsifer.minecraft;

import dev.kalsifer.minecraft.game.Game;
import dev.kalsifer.minecraft.gui.GUI;
import dev.kalsifer.minecraft.gui.controllers.MainController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        MainController mainController = new MainController(new Game());
        GUI layout = mainController.getGui();

        Scene scene = new Scene(layout);

        stage.setScene(scene);
        stage.setTitle("Minecraft at home");
        stage.show();
    }
}

/*
- gui interagibile tramite click e non tramite bottoni
- mining dei blocchi con cambio dell'opacità
- possibilità di usare il pugno o il piccone
- blocco torcia che funziona sulla sabbia
- iteratori
 */