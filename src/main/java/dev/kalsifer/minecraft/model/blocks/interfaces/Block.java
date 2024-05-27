package dev.kalsifer.minecraft.model.blocks.interfaces;

public interface Block {
    boolean doBlocksFallThrough();
    boolean doFallsWithGravity();
    boolean isPickable();
}
