package dev.kalsifer.minecraft.gui.controllers;

import dev.kalsifer.minecraft.gui.panes.InventoryPane;
import dev.kalsifer.minecraft.inventory.Inventory;

public class InventoryController implements SimpleController {
    Inventory inventory;
    InventoryPane inventoryPane;

    public InventoryController(Inventory inventory, InventoryPane inventoryPane) {
        this.inventory = inventory;
        this.inventoryPane = inventoryPane;

        redraw();
    }

    @Override
    public void redraw() {
        inventoryPane.getChildren().removeAll();
        inventoryPane.draw(this.inventory.getBlocksIterator());
    }
}
