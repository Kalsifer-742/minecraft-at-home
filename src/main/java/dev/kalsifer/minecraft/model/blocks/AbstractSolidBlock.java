package dev.kalsifer.minecraft.model.blocks;

public abstract class AbstractSolidBlock extends AbstractBlock {
    public AbstractSolidBlock(){
        super();
        fallsWithGravity = false;
        blocksFallThrough = false;
        pickable = true;
    }
}
