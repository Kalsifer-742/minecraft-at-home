package unitn.minecraft.blocks;

public class WaterBlock extends AbstractBlock{
    public WaterBlock() {
        this.blockName = "Water";
        this.content = 'w';
        this.fallsWithGravity = true;
        this.blocksFallThrough = true;
    }
}
