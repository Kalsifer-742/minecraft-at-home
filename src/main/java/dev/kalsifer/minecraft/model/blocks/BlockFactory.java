package dev.kalsifer.minecraft.model.blocks;

import dev.kalsifer.minecraft.model.furnace.Furnace;

public class BlockFactory {

    public static NullBlock nullBlock() {
        return new NullBlock();
    }

    public static AirBlock airBlock() {
        return new AirBlock();
    }

    public static SandBlock sandBlock() {
        return new SandBlock();
    }

    public static WaterBlock waterBlock() {
        return new WaterBlock();
    }

    public static GlassBlock glassBlock() {
        return new GlassBlock();
    }

    public static RawIronBlock rawIronBlock() {
        return new RawIronBlock();
    }

    public static Furnace furnaceBlock() {
        return new Furnace();
    }
}
