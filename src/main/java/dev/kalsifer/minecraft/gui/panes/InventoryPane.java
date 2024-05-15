package dev.kalsifer.minecraft.gui.panes;

import dev.kalsifer.minecraft.blocks.interfaces.Block;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.Iterator;

public class InventoryPane extends VBox {
    public InventoryPane() {
        super();
    }

    public void draw(Iterator<Block> blocksIterator) {
        super.setMinHeight(100);

        Text text = new Text("Inventory");

        TilePane blocks = new TilePane();

        while (blocksIterator.hasNext()) {
            blocks.getChildren().add(new BlockPane(blocksIterator.next()));
        }

        super.getChildren().addAll(text, blocks);
    }
}
