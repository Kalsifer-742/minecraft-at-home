package dev.kalsifer.minecraft.view;

import dev.kalsifer.minecraft.model.blocks.*;
import dev.kalsifer.minecraft.model.blocks.interfaces.Block;
import javafx.scene.image.Image;

public class Texture {
    private static final Image airBlockTexture = new Image("file:assets/light_blue_concrete.png");
    private static final Image waterBlockTexture = new Image("file:assets/underwater.png");
    private static final Image sandBlockTexture = new Image("file:assets/sand.png");
    private static final Image rawIronBlockTexture = new Image("file:assets/raw_iron_block.png");
    private static final Image glassBlockTexture = new Image("file:assets/glass.png");
    private static final Image ironBlockTexture = new Image("file:assets/iron_block.png");
    private static final Image nullBlockTexture = new Image("file:assets/empty_slot_ingot.png");

    public static Image getBlockTexture(Block block) {
        if (block instanceof AirBlock) {
            return airBlockTexture;
        } else if (block instanceof WaterBlock) {
            return waterBlockTexture;
        } else if (block instanceof SandBlock) {
            return sandBlockTexture;
        } else if (block instanceof RawIronBlock) {
            return rawIronBlockTexture;
        } else if (block instanceof GlassBlock) {
            return glassBlockTexture;
        } else if (block instanceof IronBlockInterface) {
            return ironBlockTexture;
        } else if (block instanceof NullBlock){
            return nullBlockTexture;
        }

        return null;
    }
}
