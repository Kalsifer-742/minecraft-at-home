package dev.kalsifer.minecraft.model.map.exceptions;

public class CoordinateOutOfBoundException extends Exception{
    private static final String defaultMessage = "Coordinates are out of bound";

    public CoordinateOutOfBoundException() {
        super(defaultMessage);
    }

    public CoordinateOutOfBoundException(String message) {
        super(message);
    }
}
