package unitn.minecraft.blocks;

import unitn.minecraft.blocks.interfaces.Block;

public class AbstractBlock implements Block {
    protected String blockName;
    protected char content;
    protected boolean fallsWithGravity;
    protected boolean blocksFallThrough;
    protected boolean pickable;

    public AbstractBlock() {
        this.pickable = false;
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
    public char display() {
        return this.content;
    }

    @Override
    public String toString() {
        return this.blockName + " [" + this.content + "]";
    }

    @Override
    public String displayInInventory() {
        return "[" + this.content + "]";
    }
}
