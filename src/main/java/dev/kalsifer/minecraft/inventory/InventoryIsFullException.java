package dev.kalsifer.minecraft.inventory;

public class InventoryIsFullException extends Exception{
    private static final String defaultMessage = "Inventory is full";

    public InventoryIsFullException() {
        super(defaultMessage);
    }

    public InventoryIsFullException(String message) {
        super(message);
    }
}
