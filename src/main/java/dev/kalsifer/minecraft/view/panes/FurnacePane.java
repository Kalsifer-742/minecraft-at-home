package dev.kalsifer.minecraft.view.panes;

import dev.kalsifer.minecraft.model.blocks.interfaces.Block;
import dev.kalsifer.minecraft.model.blocks.interfaces.SmeltableBlock;
import dev.kalsifer.minecraft.controller.Controller;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class FurnacePane extends VBox {
    final Controller mainController;

    public FurnacePane(Controller mainController) {
        super();

        this.mainController = mainController;
    }

    public void draw(SmeltableBlock input, Block output) {
        setBackground(new Background(new BackgroundImage(new Image("file:assets/furnace.png"), null, null, null, null)));
        setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, null)));
        setSpacing(16);
        setAlignment(Pos.TOP_CENTER);

        Label title = new Label("Furnace");

        BlockPane inputBlock = new BlockPane(input);
        inputBlock.setOnMouseClicked(event -> {
            mainController.moveInputFromFurnaceToInventory();
        });
        BlockPane outputBlock = new BlockPane(output);
        outputBlock.setOnMouseClicked(event -> {
            mainController.moveOutputFromFurnaceToInventory();
        });

        HBox items = new HBox();
        items.setSpacing(32);
        items.getChildren().addAll(inputBlock, outputBlock);

        Button smeltButton = new Button("Smelt");
        smeltButton.setOnMouseClicked(event -> {
            mainController.smelt();
        });

        getChildren().addAll(title, items, smeltButton);
    }
}
