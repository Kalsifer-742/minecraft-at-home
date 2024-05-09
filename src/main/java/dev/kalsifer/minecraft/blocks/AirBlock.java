package dev.kalsifer.minecraft.blocks;

public class AirBlock extends AbstractBlock {
    public AirBlock() {
        this.blockName = "Air";
        this.content = '.';
        this.fallsWithGravity = false;
        this.blocksFallThrough = true;
    }
}
