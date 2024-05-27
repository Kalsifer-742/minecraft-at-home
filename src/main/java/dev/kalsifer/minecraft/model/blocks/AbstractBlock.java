package dev.kalsifer.minecraft.model.blocks;

import dev.kalsifer.minecraft.model.blocks.interfaces.Block;

public class AbstractBlock implements Block {
    protected String blockName;
    protected boolean fallsWithGravity;
    protected boolean blocksFallThrough;
    protected boolean pickable;

    public AbstractBlock() {
        pickable = false;
    }

    @Override
    public boolean doBlocksFallThrough() {
        return this.blocksFallThrough;
    }

    @Override
    public boolean doFallsWithGravity() {
        return this.fallsWithGravity;
    }

    @Override
    public boolean isPickable() {
        return this.pickable;
    }

    @Override
    public String toString() {
        return this.blockName;
    }
}
