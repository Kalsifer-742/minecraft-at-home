package unitn.minecraft.blocks;

import unitn.minecraft.blocks.interfaces.Block;
import unitn.minecraft.blocks.interfaces.SmeltableBlock;

public class NullBlock extends AbstractSolidBlock implements SmeltableBlock {
    public NullBlock() {
        super();
        this.blockName = "NullBlock";
        this.content = 'n';
        this.pickable = false;
    }

    @Override
    public Block smelt() {
        return BlockFactory.nullBlock();
    }
}
