package dev.kalsifer.minecraft.gui.panes;

import dev.kalsifer.minecraft.blocks.interfaces.Block;
import javafx.scene.layout.GridPane;

public class MapPane extends GridPane {
    public MapPane() {
        super();
    }

    public void draw(int size, Block[][] blocks) {
        for (int y = size - 1; y > -1 ; y--) {
            for (int x = 0; x < size; x++) {
                super.add(new BlockPane(blocks[x][y]), x, size - y);
            }
        }
    }
}
