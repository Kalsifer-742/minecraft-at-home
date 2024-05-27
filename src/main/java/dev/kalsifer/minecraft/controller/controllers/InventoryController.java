package dev.kalsifer.minecraft.controller.controllers;

import dev.kalsifer.minecraft.view.panes.inventory.InventoryPane;
import dev.kalsifer.minecraft.model.inventory.Inventory;

public class InventoryController implements SimpleController {
    final Inventory inventory;
    final InventoryPane inventoryPane;

    public InventoryController(Inventory inventory, InventoryPane inventoryPane) {
        this.inventory = inventory;
        this.inventoryPane = inventoryPane;

        redraw();
    }

    @Override
    public void redraw() {
        inventoryPane.getChildren().clear();
        inventoryPane.draw(inventory.getBlocksIterator());
    }
}
