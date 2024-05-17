package dev.kalsifer.minecraft.gui.panes;

import dev.kalsifer.minecraft.gui.controllers.MainController;
import dev.kalsifer.minecraft.map.Coordinate;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class ActionsPane extends GridPane {
    final MainController mainController;

    public ActionsPane(MainController mainController) {
        super();

        this.mainController = mainController;

        draw();
    }

    private void draw() {
        TextField xField = new TextField();
        TextField yField = new TextField();
        Button pickButton = new Button("Pick block");

        pickButton.setOnMouseClicked((event -> mainController.pickUpBlock(new Coordinate(Integer.parseInt(xField.getText()), Integer.parseInt(yField.getText())))));

        TextField itemField = new TextField();
        Button inventoryToFurnaceButton = new Button("Move item to furnace");
        inventoryToFurnaceButton.setOnMouseClicked((event -> mainController.moveFromInventoryToFurnace(Integer.parseInt(itemField.getText()))));

        Button smeltButton = new Button("Smelt");
        smeltButton.setOnMouseClicked(event -> mainController.smelt());

        Button furnaceToInventoryButton = new Button("Take item from furnace");
        furnaceToInventoryButton.setOnMouseClicked(event -> mainController.moveFromFurnaceToInventory());

        this.addRow(0, xField, yField, pickButton);
        this.addRow(1, itemField, inventoryToFurnaceButton);
        this.addRow(2, smeltButton);
        this.addRow(3, furnaceToInventoryButton);
    }
}
