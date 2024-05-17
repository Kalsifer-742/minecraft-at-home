package dev.kalsifer.minecraft.gui.controllers;

import dev.kalsifer.minecraft.gui.panes.MapPane;
import dev.kalsifer.minecraft.map.Map;

public class MapController implements SimpleController {
    final Map map;
    final MapPane mapPane;

    public MapController(Map map, MapPane mapPane) {
        this.map = map;
        this.mapPane = mapPane;

        redraw();
    }

    @Override
    public void redraw() {
        mapPane.getChildren().clear();
        mapPane.draw(this.map.getSize(), this.map.getBlocks());
    }
}
