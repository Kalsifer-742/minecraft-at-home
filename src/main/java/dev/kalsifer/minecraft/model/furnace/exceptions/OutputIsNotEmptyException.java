package dev.kalsifer.minecraft.model.furnace.exceptions;

public class OutputIsNotEmptyException extends Exception {
    private static final String defaultMessage = "Output is not empty";

    public OutputIsNotEmptyException() {
        super(defaultMessage);
    }

    public OutputIsNotEmptyException(String message) {
        super(message);
    }
}
