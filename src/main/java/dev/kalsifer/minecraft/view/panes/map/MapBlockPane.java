package dev.kalsifer.minecraft.view.panes.map;

import dev.kalsifer.minecraft.controller.Controller;
import dev.kalsifer.minecraft.model.blocks.interfaces.Block;
import dev.kalsifer.minecraft.model.map.Coordinate;
import dev.kalsifer.minecraft.view.panes.BlockPane;

public class MapBlockPane extends BlockPane {
    public MapBlockPane(Block block, int x, int y, Controller controller) {
        super(block);

        this.setOnMouseClicked(event -> {
            if (controller.getClipboardModifier()) {
                controller.placeBlockFromClipboard(new Coordinate(x, y));
            } else {
                controller.mineBlockAtCoord(new Coordinate(x, y));
            }
        });
    }
}