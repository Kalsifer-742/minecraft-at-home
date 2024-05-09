package dev.kalsifer.minecraft.gui;

import dev.kalsifer.minecraft.map.Map;
import dev.kalsifer.minecraft.furnace.Furnace;
import dev.kalsifer.minecraft.inventory.Inventory;

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
