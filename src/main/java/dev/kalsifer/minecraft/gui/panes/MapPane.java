package dev.kalsifer.minecraft.gui.panes;

import dev.kalsifer.minecraft.blocks.interfaces.Block;
import dev.kalsifer.minecraft.gui.controllers.MainController;
import dev.kalsifer.minecraft.map.Coordinate;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class MapPane extends GridPane {
    public MapPane(MainController mainController) {
        super();

        this.setOnMouseClicked(event -> {
            int x = Math.ceilDiv((int) event.getX(), 64) - 1;
            int y = 7 - (Math.ceilDiv((int) event.getY(), 64) - 1);

            if (mainController.isPPressed()) {
                mainController.placeBlockFromClipboard(new Coordinate(x, y));
            } else {
                mainController.pickUpBlock(new Coordinate(x, y));
            }
        });
    }

    public void draw(int size, Block[][] blocks) {
        setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, null)));

        for (int y = size - 1; y > -1 ; y--) {
            for (int x = 0; x < size; x++) {
                add(new BlockPane(blocks[x][y]), x, size - y);
            }
        }
    }
}
