package dev.kalsifer.minecraft.inventory;

import dev.kalsifer.minecraft.blocks.interfaces.Block;

import java.util.ArrayList;

public class Inventory {
    private final ArrayList<Block> blocks;

    public Inventory() {
        blocks = new ArrayList<>();
    }

    public void displayOnOut() {
        System.out.print("I || ");
        for (Block block : this.blocks) {
            System.out.print(block.displayInInventory());
        }
        System.out.print(" ||");
        System.out.println();
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
