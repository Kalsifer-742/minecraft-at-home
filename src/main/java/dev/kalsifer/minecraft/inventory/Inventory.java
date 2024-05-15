package dev.kalsifer.minecraft.inventory;

import dev.kalsifer.minecraft.blocks.interfaces.Block;
import dev.kalsifer.minecraft.gui.panes.BlockPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Iterator;

public class Inventory {
    private final ArrayList<Block> blocks;

    public Inventory() {
        blocks = new ArrayList<>();
    }

    public Iterator<Block> getBlocksIterator() {
        return this.blocks.iterator();
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
