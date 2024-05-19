package dev.kalsifer.minecraft.blocks;

import dev.kalsifer.minecraft.blocks.interfaces.Block;
import dev.kalsifer.minecraft.tools.AbstractTool;

public class AbstractBlock implements Block {
    protected String blockName;
    protected boolean fallsWithGravity;
    protected boolean blocksFallThrough;
    protected boolean pickable;
    protected double hardness;
    protected double life;

    public AbstractBlock() {
        pickable = false;
        hardness = 0;
        life = 0;
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
