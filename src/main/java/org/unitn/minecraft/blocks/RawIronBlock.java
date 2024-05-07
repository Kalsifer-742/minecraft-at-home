package unitn.minecraft.blocks;

import unitn.minecraft.blocks.interfaces.Block;
import unitn.minecraft.blocks.interfaces.SmeltableBlock;

public class RawIronBlock extends AbstractSolidBlock implements SmeltableBlock {

    public RawIronBlock() {
        super();
        this.blockName = "Raw Iron Block";
        this.content = 'I';
    }

    @Override
    public Block smelt() {
        return new IronBlock();
    }
}
