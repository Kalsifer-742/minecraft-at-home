package dev.kalsifer.minecraft.gui.controllers;

import dev.kalsifer.minecraft.blocks.interfaces.Block;
import dev.kalsifer.minecraft.gui.panes.ClipboardPane;

public class ClipboardController implements SimpleController {
    Block clipboard;
    ClipboardPane clipboardPane;

    public ClipboardController(Block clipboard, ClipboardPane clipboardPane) {
        this.clipboard = clipboard;
        this.clipboardPane = clipboardPane;

        redraw();
    }

    public void updateClipboard(Block clipboard) {
        this.clipboard = clipboard;
    }

    @Override
    public void redraw() {
        clipboardPane.getChildren().clear();
        clipboardPane.draw(clipboard);
    }
}
