package dev.kalsifer.minecraft.tools;

import dev.kalsifer.minecraft.blocks.interfaces.Block;

public abstract class AbstractTool implements Tool {
    public double miningSpeed;

    public AbstractTool() {
        miningSpeed = 1.25;
    }

//    @Override
//    public Block mine(Block block) {
//
//    }
}
