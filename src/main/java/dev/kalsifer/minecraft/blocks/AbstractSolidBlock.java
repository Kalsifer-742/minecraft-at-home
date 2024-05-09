package dev.kalsifer.minecraft.blocks;

public abstract class AbstractSolidBlock extends AbstractBlock {
    public AbstractSolidBlock(){
        super();
        this.fallsWithGravity = false;
        this.blocksFallThrough = false;
        this.pickable = true;
    }
}
