package unitn.minecraft.inventory;

import unitn.minecraft.blocks.*;
import unitn.minecraft.blocks.interfaces.Block;
import unitn.minecraft.blocks.interfaces.IronBlockInterface;

import java.util.Comparator;

public class BlockComparator implements Comparator<Block> {

    @Override
    public int compare(Block block, Block t1) {
        return Integer.compare(blockValue(block), blockValue(t1));
    }

    private int blockValue(Block b) {
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
            return 4;
        }
        if (b instanceof GlassBlock){
            return 5;
        }
        if (b instanceof RawIronBlock){
            return 6;
        }
        if (b instanceof IronBlockInterface){
            return 7;
        }
        return -1;
    }
}
