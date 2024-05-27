package dev.kalsifer.minecraft.model.map.exceptions;

public class BlockIsNotPickableException extends Exception{
    private static final String defaultMessage = "Block is not Pickable";

    public BlockIsNotPickableException() {
        super(defaultMessage);
    }

    public BlockIsNotPickableException(String message) {
        super(message);
    }
}
