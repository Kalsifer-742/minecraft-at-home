package dev.kalsifer.minecraft;

import dev.kalsifer.minecraft.blocks.BlockFactory;
import dev.kalsifer.minecraft.gui.BlockPane;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();
        root.getChildren().add(new BlockPane(BlockFactory.airBlock()));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setTitle("Minecraft at home");
        stage.setMinWidth(800);
        stage.setMinHeight(600);
        stage.show();
    }
}