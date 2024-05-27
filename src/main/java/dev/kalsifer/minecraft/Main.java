package dev.kalsifer.minecraft;

import dev.kalsifer.minecraft.model.Model;
import dev.kalsifer.minecraft.view.View;
import dev.kalsifer.minecraft.controller.Controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Controller mainController = new Controller(new Model());
        View layout = mainController.getView();

        Scene scene = new Scene(layout);

        stage.setScene(scene);
        stage.setTitle("Minecraft at home");
        stage.setResizable(false);
        stage.show();
    }
}