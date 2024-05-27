package dev.kalsifer.minecraft.model.furnace.exceptions;

public class InputIsNotEmptyException extends Exception {
    private static final String defaultMessage = "Input is not empty";

    public InputIsNotEmptyException() {
        super(defaultMessage);
    }

    public InputIsNotEmptyException(String message) {
        super(message);
    }
}
