package dev.kalsifer.minecraft.gui;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class Actions extends GridPane {
    public Actions() {
        super();

        this.draw();
    }

    private void draw() {
        TextField xField = new TextField();
        TextField yField = new TextField();
        Button pickButton = new Button("Pick block");

        TextField itemField = new TextField();
        Button inventoryToFurnaceButton = new Button("Move item to furnace");

        Button smeltButton = new Button("Smelt");

        Button furnaceToInventoryButton = new Button("Take item from furnace");

        this.addRow(0, xField, yField, pickButton);
        this.addRow(1, itemField, inventoryToFurnaceButton);
        this.addRow(2, smeltButton);
        this.addRow(3, furnaceToInventoryButton);
    }
}
