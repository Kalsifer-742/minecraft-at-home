package dev.kalsifer.minecraft.model.blocks;

import dev.kalsifer.minecraft.model.blocks.interfaces.Block;
import dev.kalsifer.minecraft.model.blocks.interfaces.SmeltableBlock;

public class NullBlock extends AbstractSolidBlock implements SmeltableBlock {
    public NullBlock() {
        super();
        this.blockName = "NullBlock";
        this.pickable = false;
    }

    @Override
    public Block smelt() {
        return BlockFactory.nullBlock();
    }
}
