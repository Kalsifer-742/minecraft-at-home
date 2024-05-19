package dev.kalsifer.minecraft.blocks;

public abstract class AbstractSolidBlock extends AbstractBlock {
    public AbstractSolidBlock(){
        super();
        fallsWithGravity = false;
        blocksFallThrough = false;
        pickable = true;
        hardness = 1;
        life = 2;
    }
}
