package dev.kalsifer.minecraft.view.panes.map;

import dev.kalsifer.minecraft.model.blocks.interfaces.Block;
import dev.kalsifer.minecraft.controller.Controller;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class MapPane extends GridPane {
    final Controller controller;

    public MapPane(Controller controller) {
        super();

        this.controller = controller;
    }

    public void draw(int size, Block[][] blocks) {
        super.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, null)));

        for (int y = size - 1; y > -1 ; y--) {
            for (int x = 0; x < size; x++) {
                int corrected_y = size - y;
                super.add(new MapBlockPane(blocks[x][y], x, y, controller), x, corrected_y);
            }
        }
    }
}
