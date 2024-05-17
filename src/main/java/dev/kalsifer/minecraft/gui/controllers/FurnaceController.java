package dev.kalsifer.minecraft.gui.controllers;

import dev.kalsifer.minecraft.furnace.Furnace;
import dev.kalsifer.minecraft.gui.panes.FurnacePane;

public class FurnaceController implements SimpleController {
    final Furnace furnace;
    final FurnacePane furnacePane;

    public FurnaceController(Furnace furnace, FurnacePane furnacePane) {
        this.furnace = furnace;
        this.furnacePane = furnacePane;

        redraw();
    }

    @Override
    public void redraw() {
        furnacePane.getChildren().clear();
        furnacePane.draw(this.furnace.getInput(), this.furnace.getOutput());
    }
}
