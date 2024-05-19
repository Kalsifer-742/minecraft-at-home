package dev.kalsifer.minecraft.blocks.interfaces;

import dev.kalsifer.minecraft.tools.AbstractTool;

public interface Block {
    boolean doBlocksFallThrough();
    boolean doFallsWithGravity();
    boolean isPickable();
}
