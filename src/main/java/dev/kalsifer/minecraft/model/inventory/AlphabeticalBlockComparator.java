package dev.kalsifer.minecraft.model.inventory;

import dev.kalsifer.minecraft.model.blocks.interfaces.Block;

import java.util.Comparator;

public class AlphabeticalBlockComparator implements Comparator<Block> {

    @Override
    public int compare(Block block, Block t1) {
        return block.toString().compareTo(t1.toString());
    }
}
