package dev.kalsifer.minecraft.blocks;

import dev.kalsifer.minecraft.blocks.interfaces.Block;
import dev.kalsifer.minecraft.blocks.interfaces.SmeltableBlock;

public class RawIronBlock extends AbstractSolidBlock implements SmeltableBlock {

    public RawIronBlock() {
        super();
        this.blockName = "Raw Iron Block";
    }

    @Override
    public Block smelt() {
        return new IronBlock();
    }
}
