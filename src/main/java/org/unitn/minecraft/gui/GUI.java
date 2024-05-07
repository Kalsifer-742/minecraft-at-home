package unitn.minecraft.gui;

import unitn.minecraft.furnace.Furnace;
import unitn.minecraft.inventory.Inventory;
import unitn.minecraft.map.Map;

public class GUI {
    Map map;
    Furnace furnace;
    Inventory inventory;

    public GUI(Map map, Furnace furnace, Inventory inventory) {
        this.map = map;
        this.furnace = furnace;
        this.inventory = inventory;
    }

    public void display() {
        printLine();
        this.map.displayOnOut();
        printLine();
        this.furnace.displayOnOut();
        this.inventory.displayOnOut();
        printLine();
    }

    private void printLine() {
        for (int i = 0; i < this.map.getSize() * 3; i++) {
            System.out.print("=");
        }
        System.out.println();
    }
}
