package dev.kalsifer.minecraft.view.panes.inventory;

import dev.kalsifer.minecraft.controller.Controller;
import dev.kalsifer.minecraft.model.blocks.interfaces.Block;
import dev.kalsifer.minecraft.view.panes.BlockPane;

public class InventoryBlockPane extends BlockPane {
    public InventoryBlockPane(Block block, int index, Controller controller) {
        super(block);

        this.setOnMouseClicked(event -> {
            if (controller.getClipboardModifier()) {
                controller.moveBlockFromInventoryToClipboard(index);
            } else {
                controller.moveFromInventoryToFurnace(index);
            }
        });
    }
}
