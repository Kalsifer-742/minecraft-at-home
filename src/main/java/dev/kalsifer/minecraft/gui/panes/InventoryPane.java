package dev.kalsifer.minecraft.gui.panes;

import dev.kalsifer.minecraft.blocks.interfaces.Block;
import dev.kalsifer.minecraft.gui.controllers.MainController;
import dev.kalsifer.minecraft.map.Coordinate;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.Iterator;

public class InventoryPane extends VBox {
    MainController mainController;

    public InventoryPane(MainController mainController) {
        super();

        this.mainController = mainController;
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
        blocks.setOnMouseClicked(event -> {
            blocks.requestFocus();

            int x = Math.ceilDiv((int) event.getX(), 64) - 1;
            x = Math.ceilDiv((int) event.getX() - (16 * x), 64) - 1;
            int y = Math.ceilDiv((int) event.getY(), 64) - 1;
            y = Math.ceilDiv((int) event.getY() - (16 * y), 64) - 1;

            int index = y * 2 + x;

            if (mainController.isFPressed()) {
                mainController.moveFromInventoryToFurnace(index);
            } else if (mainController.isPPressed()) {
                mainController.moveBlockFromInventoryToClipboard(index);
            }
        });

        while (blocksIterator.hasNext()) {
            blocks.getChildren().add(new BlockPane(blocksIterator.next()));
        }

        super.getChildren().addAll(title, blocks);
    }
}
