package dev.kalsifer.minecraft.map;

public class CoordinateOutOfBoundException extends Exception{
    private static final String defaultMessage = "Coordinates are out of bound";

    public CoordinateOutOfBoundException() {
        super(defaultMessage);
    }

    public CoordinateOutOfBoundException(String message) {
        super(message);
    }
}
