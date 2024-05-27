package dev.kalsifer.minecraft.model.clipboard.exceptions;

public class ClipBoardIsEmptyException extends Exception {
    private static final String defaultMessage = "Clipboard is empty";

    public ClipBoardIsEmptyException() {
        super(defaultMessage);
    }

    public ClipBoardIsEmptyException(String message) {
        super(message);
    }
}
