package dev.kalsifer.minecraft.inventory;

import dev.kalsifer.minecraft.blocks.*;
import dev.kalsifer.minecraft.blocks.interfaces.Block;
import dev.kalsifer.minecraft.blocks.interfaces.IronBlockInterface;

import java.util.Comparator;

public class BlockComparator implements Comparator<Block> {

    @Override
    public int compare(Block block, Block t1) {
        return Integer.compare(blockValue(block), blockValue(t1));
    }

    public static int blockValue(Block b) {
        if (b instanceof NullBlock){
            return 0;
        }
        if (b instanceof AirBlock){
            return 1;
        }
        if (b instanceof WaterBlock){
            return 2;
        }
        if (b instanceof SandBlock){
            return 3;
        }
        if (b instanceof GlassBlock){
            return 4;
        }
        if (b instanceof RawIronBlock){
            return 5;
        }
        if (b instanceof IronBlockInterface){
            return 6;
        }
        return -1;
    }
}
