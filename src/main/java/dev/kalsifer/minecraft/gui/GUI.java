package dev.kalsifer.minecraft.gui;

import dev.kalsifer.minecraft.gui.event_handlers.InventaryBlockClickedEventHandler;
import dev.kalsifer.minecraft.gui.event_handlers.MapBlockClickedEventHandler;
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

    public GUI(MapBlockClickedEventHandler mapBlockClickedEventHandler, InventaryBlockClickedEventHandler inventaryBlockClickedEventHandler) {
        super();

        mapPane = new MapPane(mapBlockClickedEventHandler);
        furnacePane = new FurnacePane();
        inventoryPane = new InventoryPane(inventaryBlockClickedEventHandler);

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
        ui.setMaxWidth(128);
        ui.setSpacing(32);
        ui.getChildren().addAll(furnacePane, inventoryPane);

        HBox map_ui = new HBox();
        map_ui.setSpacing(32);
        map_ui.getChildren().addAll(mapPane, ui);

        getChildren().add(map_ui);
    }
}
