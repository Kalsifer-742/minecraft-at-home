package dev.kalsifer.minecraft.blocks.exceptions;

public class BlockIsNotSmeltableException extends Exception {
    private static final String defaultMessage = "Block is not smeltable";

    public BlockIsNotSmeltableException() {
        super(defaultMessage);
    }

    public BlockIsNotSmeltableException(String message) {
        super(message);
    }
}
