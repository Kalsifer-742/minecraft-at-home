package dev.kalsifer.minecraft.gui.controllers;

import dev.kalsifer.minecraft.furnace.Furnace;
import dev.kalsifer.minecraft.gui.panes.FurnacePane;

public class FurnaceController implements SimpleController {
    Furnace furnace;
    FurnacePane furnacePane;

    public FurnaceController(Furnace furnace, FurnacePane furnacePane) {
        this.furnace = furnace;
        this.furnacePane = furnacePane;

        redraw();
    }

    @Override
    public void redraw() {
        furnacePane.getChildren().removeAll();
        furnacePane.draw(this.furnace.getInput(), this.furnace.getOutput());
    }
}
