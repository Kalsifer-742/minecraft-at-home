package unitn.minecraft.gui;

import javafx.scene.layout.StackPane;
import unitn.minecraft.blocks.interfaces.Block;

public class BlockPane extends StackPane {
    Block block;

    public BlockPane(Block block) {
        this.block = block;
    }
}
