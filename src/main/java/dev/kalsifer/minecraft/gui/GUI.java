package dev.kalsifer.minecraft.gui;

import dev.kalsifer.minecraft.gui.controllers.MainController;
import dev.kalsifer.minecraft.gui.panes.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

public class GUI extends BorderPane {
    final MapPane mapPane;
    final FurnacePane furnacePane;
    final InventoryPane inventoryPane;
    ClipboardPane clipboardPane;

    public GUI(MainController mainController) {
        super();

        mapPane = new MapPane(mainController);
        furnacePane = new FurnacePane(mainController);
        inventoryPane = new InventoryPane(mainController);
        clipboardPane = new ClipboardPane();

        draw();
    }

    public MapPane getMapPane() {
        return mapPane;
    }

    public FurnacePane getFurnacePane() {
        return furnacePane;
    }

    public InventoryPane getInventoryPane() {
        return inventoryPane;
    }

    public ClipboardPane getClipboardPane() { return clipboardPane; }

    public void draw() {
        VBox ui = new VBox();
        ui.setMaxWidth(128);
        ui.setSpacing(16);
        ui.getChildren().addAll(furnacePane, inventoryPane);
        setMargin(ui, new Insets(16));

        VBox commands = new VBox();
        commands.getChildren().addAll(
                new Text("Modifiers:"),
                new Text("F: put items from inventory to furnace"),
                new Text("P: put items from inventory to clipboard"),
                new Text("P: place block from clipboard")
        );

        HBox footer = new HBox();
        footer.setSpacing(32);
        footer.getChildren().addAll(commands, clipboardPane);
        setMargin(footer, new Insets(16));

        setCenter(mapPane);
        setRight(ui);
        setBottom(footer);
    }
}
