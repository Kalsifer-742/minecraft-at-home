package dev.kalsifer.minecraft.furnace;

public class InputIsNotEmptyException extends Exception {
    private static final String defaultMessage = "Input is not empty";

    public InputIsNotEmptyException() {
        super(defaultMessage);
    }

    public InputIsNotEmptyException(String message) {
        super(message);
    }
}
