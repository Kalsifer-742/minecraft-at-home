package dev.kalsifer.minecraft.inventory;

import dev.kalsifer.minecraft.blocks.BlockFactory;
import dev.kalsifer.minecraft.blocks.interfaces.Block;
import dev.kalsifer.minecraft.gui.BlockPane;
import javafx.geometry.Pos;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.util.ArrayList;

public class Inventory extends VBox {
    private final ArrayList<Block> blocks;

    public Inventory() {
        super();

        blocks = new ArrayList<>();

        this.draw();
    }

    public void draw() {
        super.setMinHeight(100);

        Text text = new Text("Inventory");

        TilePane blocks = new TilePane();

        for (Block block : this.blocks) {
            blocks.getChildren().add(new BlockPane(block));
        }

        super.getChildren().addAll(text, blocks);
    }

    public Block removeBlock(int index) throws IndexOutOfBoundsException {
        try {
            return this.blocks.remove(index);
        } catch ( IndexOutOfBoundsException e ) {
            throw new IndexOutOfBoundsException();
        }
    }

    public void addBlock(Block block) {
        this.blocks.add(block);
        this.blocks.sort(new AlphabeticalBlockComparator());
    }
}
