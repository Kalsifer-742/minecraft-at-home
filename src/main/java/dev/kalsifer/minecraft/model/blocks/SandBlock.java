package dev.kalsifer.minecraft.model.blocks;

import dev.kalsifer.minecraft.model.blocks.interfaces.Block;
import dev.kalsifer.minecraft.model.blocks.interfaces.SmeltableBlock;

public class SandBlock extends AbstractBlock implements SmeltableBlock {
    public SandBlock() {
        this.blockName = "Sand";
        this.fallsWithGravity = true;
        this.blocksFallThrough = false;
        this.pickable = true;
    }

    @Override
    public Block smelt() {
        return BlockFactory.glassBlock();
    }
}
