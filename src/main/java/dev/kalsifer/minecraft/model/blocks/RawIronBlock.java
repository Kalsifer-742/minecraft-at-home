package dev.kalsifer.minecraft.model.blocks;

import dev.kalsifer.minecraft.model.blocks.interfaces.Block;
import dev.kalsifer.minecraft.model.blocks.interfaces.SmeltableBlock;

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
