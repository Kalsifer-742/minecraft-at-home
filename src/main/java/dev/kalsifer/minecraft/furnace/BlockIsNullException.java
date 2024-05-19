package dev.kalsifer.minecraft.furnace;

public class BlockIsNullException extends Exception{
    private static final String defaultMessage = "Block is null";

    public BlockIsNullException() {
        super(defaultMessage);
    }

    public BlockIsNullException(String message) {
        super(message);
    }
}
