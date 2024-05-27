package dev.kalsifer.minecraft.model.blocks;

public class AirBlock extends AbstractBlock {
    public AirBlock() {
        super();
        blockName = "Air";
        fallsWithGravity = false;
        blocksFallThrough = true;
    }
}
