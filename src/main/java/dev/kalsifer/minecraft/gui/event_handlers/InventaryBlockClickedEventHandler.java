package dev.kalsifer.minecraft.gui.event_handlers;

import dev.kalsifer.minecraft.gui.controllers.MainController;
import dev.kalsifer.minecraft.map.Coordinate;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class InventaryBlockClickedEventHandler implements EventHandler<MouseEvent> {
    MainController mainController;

    public InventaryBlockClickedEventHandler(MainController mainController) {
        this.mainController = mainController;
    }

    @Override
    public void handle(MouseEvent event) {
        int x = Math.ceilDiv((int) event.getX(), 64) - 1;
        int y = Math.ceilDiv((int) event.getY(), 64) - 1;

        System.out.println(x + y);

        System.out.println(event.getY());

        //mainController.moveFromInventoryToFurnace(index);
    }
}
