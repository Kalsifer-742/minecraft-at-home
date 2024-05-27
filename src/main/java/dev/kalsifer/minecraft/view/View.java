package dev.kalsifer.minecraft.view;

import dev.kalsifer.minecraft.controller.Controller;
import dev.kalsifer.minecraft.view.panes.*;
import dev.kalsifer.minecraft.view.panes.inventory.InventoryPane;
import dev.kalsifer.minecraft.view.panes.map.MapPane;
import javafx.geometry.Insets;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

public class View extends BorderPane {
    final MapPane mapPane;
    final FurnacePane furnacePane;
    final InventoryPane inventoryPane;
    final ClipboardPane clipboardPane;

    public View(Controller controller) {
        super();

        mapPane = new MapPane(controller);
        furnacePane = new FurnacePane(controller);
        inventoryPane = new InventoryPane(controller);
        clipboardPane = new ClipboardPane();

        this.setOnKeyPressed(keyPressed -> {
            if (keyPressed.getCode() == KeyCode.C) {
                controller.setClipboardModifier(true);
            }
        });

        this.setOnKeyReleased(keyReleased -> {
            if (keyReleased.getCode() == KeyCode.C) {
                controller.setClipboardModifier(false);
            }
        });

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

    private void draw() {
//        mapPane.

        VBox ui = new VBox();
        ui.setMaxWidth(128);
        ui.setSpacing(16);
        ui.getChildren().addAll(furnacePane, inventoryPane);
        setMargin(ui, new Insets(16));

        VBox commands = new VBox();
        commands.getChildren().addAll(
                new Text("Modifiers:"),
                new Text("C: put items from inventory to clipboard"),
                new Text("C: place block from clipboard")
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
