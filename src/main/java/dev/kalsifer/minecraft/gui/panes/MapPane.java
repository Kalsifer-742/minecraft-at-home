package dev.kalsifer.minecraft.gui.panes;

import dev.kalsifer.minecraft.blocks.interfaces.Block;
import dev.kalsifer.minecraft.gui.controllers.MainController;
import dev.kalsifer.minecraft.gui.event_handlers.MapBlockClickedEventHandler;
import dev.kalsifer.minecraft.map.Coordinate;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class MapPane extends GridPane {
    public MapPane(MapBlockClickedEventHandler mapBlockClickedEventHandler) {
        super();

        this.setOnMouseClicked(mapBlockClickedEventHandler);
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
