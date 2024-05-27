package dev.kalsifer.minecraft.model.clipboard.exceptions;

public class ClipBoardIsNotEmptyException extends Exception {
    private static final String defaultMessage = "Clipboard is not empty";

    public ClipBoardIsNotEmptyException() {
        super(defaultMessage);
    }

    public ClipBoardIsNotEmptyException(String message) {
        super(message);
    }
}
