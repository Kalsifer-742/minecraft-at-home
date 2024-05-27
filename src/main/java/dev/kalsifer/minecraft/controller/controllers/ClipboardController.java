package dev.kalsifer.minecraft.controller.controllers;

import dev.kalsifer.minecraft.model.blocks.interfaces.Block;
import dev.kalsifer.minecraft.view.panes.ClipboardPane;

public class ClipboardController implements SimpleController {
    Block clipboard;
    final ClipboardPane clipboardPane;

    public ClipboardController(Block clipboard, ClipboardPane clipboardPane) {
        this.clipboard = clipboard;
        this.clipboardPane = clipboardPane;

        redraw();
    }

    public void updateClipboardView(Block clipboard) {
        this.clipboard = clipboard;
    }

    @Override
    public void redraw() {
        clipboardPane.getChildren().clear();
        clipboardPane.draw(clipboard);
    }
}
