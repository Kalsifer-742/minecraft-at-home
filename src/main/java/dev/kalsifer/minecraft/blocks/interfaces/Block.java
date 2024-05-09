package dev.kalsifer.minecraft.blocks.interfaces;

public interface Block extends InventoryBlock {
    boolean doBlocksFallThrough();
    boolean doFallsWithGravity();
    boolean isPickable();
    char display();
}
