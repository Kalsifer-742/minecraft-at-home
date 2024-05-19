package dev.kalsifer.minecraft.furnace;

public class OutputIsNotEmptyException extends Exception {
    private static final String defaultMessage = "Output is not empty";

    public OutputIsNotEmptyException() {
        super(defaultMessage);
    }

    public OutputIsNotEmptyException(String message) {
        super(message);
    }
}
