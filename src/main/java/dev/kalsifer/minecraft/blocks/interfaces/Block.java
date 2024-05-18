package dev.kalsifer.minecraft.blocks.interfaces;

public interface Block {
    boolean doBlocksFallThrough();
    boolean doFallsWithGravity();
    boolean isPickable();
}
