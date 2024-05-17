package dev.kalsifer.minecraft.gui;

import dev.kalsifer.minecraft.gui.controllers.MainController;
import dev.kalsifer.minecraft.gui.panes.ActionsPane;
import dev.kalsifer.minecraft.gui.panes.FurnacePane;
import dev.kalsifer.minecraft.gui.panes.InventoryPane;
import dev.kalsifer.minecraft.gui.panes.MapPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class GUI extends Pane {
    final MapPane mapPane;
    final FurnacePane furnacePane;
    final InventoryPane inventoryPane;
    final ActionsPane actionsPane;

    public GUI(MainController mainController) {
        super();

        mapPane = new MapPane();
        furnacePane = new FurnacePane();
        inventoryPane = new InventoryPane();
        actionsPane = new ActionsPane(mainController);

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

    public void draw() {
        VBox ui = new VBox();
        ui.getChildren().addAll(furnacePane, inventoryPane);

        HBox map_ui = new HBox();
        map_ui.getChildren().addAll(mapPane, ui);

        VBox root = new VBox();
        root.getChildren().addAll(map_ui, actionsPane);

        getChildren().add(root);
    }
}
