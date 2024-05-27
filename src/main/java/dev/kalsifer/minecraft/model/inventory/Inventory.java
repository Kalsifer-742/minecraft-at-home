package dev.kalsifer.minecraft.model.inventory;

import dev.kalsifer.minecraft.model.blocks.interfaces.Block;
import dev.kalsifer.minecraft.model.inventory.exceptions.InventoryIsFullException;

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

    public int getSize() {
        return blocks.size();
    }

    public Block getBlock(int index) {
        try {
            return this.blocks.get(index);
        } catch ( IndexOutOfBoundsException e ) {
            throw new IndexOutOfBoundsException();
        }
    }

    public Block removeBlock(int index) throws IndexOutOfBoundsException {
        try {
            return this.blocks.remove(index);
        } catch ( IndexOutOfBoundsException e ) {
            throw new IndexOutOfBoundsException();
        }
    }

    public void addBlock(Block block) throws InventoryIsFullException {
        if (blocks.size() >= 8) {
            throw new InventoryIsFullException();
        }
        blocks.add(block);
        blocks.sort(new AlphabeticalBlockComparator());
    }
}
