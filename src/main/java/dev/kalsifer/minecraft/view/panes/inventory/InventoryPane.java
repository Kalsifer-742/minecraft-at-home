package dev.kalsifer.minecraft.view.panes.inventory;

import dev.kalsifer.minecraft.model.blocks.interfaces.Block;
import dev.kalsifer.minecraft.controller.Controller;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.Iterator;

public class InventoryPane extends VBox {
    final Controller controller;

    public InventoryPane(Controller mainController) {
        super();

        this.controller = mainController;
    }

    public void draw(Iterator<Block> blocksIterator) {
        setBackground(new Background(new BackgroundImage(new Image("file:assets/bamboo_block.png"), null, null, null, null)));
        setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, null)));
        setSpacing(16);
        setAlignment(Pos.TOP_CENTER);

        Label title = new Label("Inventory");

        TilePane blocks = new TilePane();
        blocks.setHgap(16);
        blocks.setVgap(16);
        setMargin(blocks, new Insets(8));

        int index = 0;
        while (blocksIterator.hasNext()) {
            blocks.getChildren().add(new InventoryBlockPane(blocksIterator.next(), index, controller));
            index++;
        }

        super.getChildren().addAll(title, blocks);
    }
}
