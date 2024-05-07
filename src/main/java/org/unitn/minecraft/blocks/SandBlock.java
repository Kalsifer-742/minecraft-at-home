package unitn.minecraft.blocks;

import unitn.minecraft.blocks.interfaces.Block;
import unitn.minecraft.blocks.interfaces.SmeltableBlock;

public class SandBlock extends AbstractBlock implements SmeltableBlock {
    public SandBlock() {
        this.blockName = "Sand";
        this.content = 's';
        this.fallsWithGravity = true;
        this.blocksFallThrough = false;
        this.pickable = true;
    }

    @Override
    public Block smelt() {
        return BlockFactory.glassBlock();
    }
}
