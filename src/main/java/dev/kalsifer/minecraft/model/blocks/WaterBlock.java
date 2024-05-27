package dev.kalsifer.minecraft.model.blocks;

public class WaterBlock extends AbstractBlock{
    public WaterBlock() {
        this.blockName = "Water";
        this.fallsWithGravity = true;
        this.blocksFallThrough = true;
    }
}
