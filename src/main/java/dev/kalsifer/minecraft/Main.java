package dev.kalsifer.minecraft;

import dev.kalsifer.minecraft.game.Game;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Game game = new Game();

        Scene scene = new Scene(game);

        stage.setScene(scene);
        stage.setTitle("Minecraft at home");
        stage.setMinWidth(800);
        stage.setMinHeight(600);
        stage.show();
    }
}