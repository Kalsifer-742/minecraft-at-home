package dev.kalsifer.minecraft.gui.controllers;

import dev.kalsifer.minecraft.blocks.BlockFactory;
import dev.kalsifer.minecraft.blocks.exceptions.BlockIsNotPickableException;
import dev.kalsifer.minecraft.blocks.exceptions.BlockIsNotSmeltableException;
import dev.kalsifer.minecraft.blocks.interfaces.Block;
import dev.kalsifer.minecraft.furnace.BlockIsNullException;
import dev.kalsifer.minecraft.furnace.InputIsNotEmptyException;
import dev.kalsifer.minecraft.furnace.OutputIsNotEmptyException;
import dev.kalsifer.minecraft.game.Game;
import dev.kalsifer.minecraft.gui.GUI;
import dev.kalsifer.minecraft.inventory.InventoryIsFullException;
import dev.kalsifer.minecraft.map.Coordinate;
import dev.kalsifer.minecraft.map.CoordinateOutOfBoundException;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyCode;

import java.util.ArrayList;

public class MainController implements SimpleController {
    final Game game;
    final GUI gui;
    final ArrayList<SimpleController> controllerList;
    final MapController mapController;
    final FurnaceController furnaceController;
    final InventoryController inventoryController;
    ClipboardController clipboardController;
    boolean isFPressed = false;
    boolean isPPressed = false;

    public MainController(Game game){
        this.game = game;
        gui = new GUI(this);
        gui.setOnKeyPressed(keyEvent -> {
            switch (keyEvent.getCode()){
                case KeyCode.F:
                    isFPressed = true;
                    break;
                case KeyCode.P:
                    isPPressed = true;
                    break;
            }
        });
        gui.setOnKeyReleased(keyEvent -> {
            switch (keyEvent.getCode()){
                case KeyCode.F:
                    isFPressed = false;
                    break;
                case KeyCode.P:
                    isPPressed = false;
                    break;
            }
        });
        controllerList = new ArrayList<>();
        mapController = new MapController(game.getMap(), gui.getMapPane());
        furnaceController = new FurnaceController(game.getFurnace(), gui.getFurnacePane());
        inventoryController = new InventoryController(game.getInventory(), gui.getInventoryPane());
        clipboardController = new ClipboardController(game.getClipboard(), gui.getClipboardPane());
        controllerList.add(mapController);
        controllerList.add(furnaceController);
        controllerList.add(inventoryController);
        controllerList.add(clipboardController);
    }

    public GUI getGui() {
        return gui;
    }

    public boolean isFPressed() {
        return isFPressed;
    }

    public boolean isPPressed() {
        return isPPressed;
    }

    @Override
    public void redraw() {
        for (SimpleController controller: controllerList) {
            controller.redraw();
        }
    }

    public void moveFromInventoryToFurnace(int index) {
        try {
            game.moveFromInventoryToFurnace(index);
        } catch (BlockIsNotSmeltableException | InputIsNotEmptyException e) {
            new Alert(Alert.AlertType.WARNING, e.getMessage()).show();
        }

        redraw();
    }

    public void smelt() {
        try {
            game.smelt();
        } catch (BlockIsNullException | OutputIsNotEmptyException e) {
            new Alert(Alert.AlertType.WARNING, e.getMessage()).show();
        }

        redraw();
    }

    public void moveInputFromFurnaceToInventory() {
        try {
            game.moveInputFromFurnaceToInventory();
        } catch (InventoryIsFullException | BlockIsNullException e) {
            new Alert(Alert.AlertType.WARNING, e.getMessage()).show();
        }

        redraw();
    }

    public void moveOutputFromFurnaceToInventory() {
        try {
            game.moveOutputFromFurnaceToInventory();
        } catch (InventoryIsFullException | BlockIsNullException e) {
            new Alert(Alert.AlertType.WARNING, e.getMessage()).show();
        }

        redraw();
    }

    public void moveBlockFromInventoryToClipboard(int index) {
        try {
            game.moveBlockFromInventoryToClipboard(index);
        } catch (IndexOutOfBoundsException e) {
            new Alert(Alert.AlertType.WARNING, e.getMessage()).show();
        }
        clipboardController.updateClipboard(game.getClipboard());

        redraw();
    }

    public void placeBlockFromClipboard(Coordinate coord) {
        try {
            game.placeBlockFromClipboard(coord);
        } catch (IndexOutOfBoundsException | CoordinateOutOfBoundException e) {
            new Alert(Alert.AlertType.WARNING, e.getMessage()).show();
        }
        clipboardController.updateClipboard(game.getClipboard());

        redraw();
    }

    public void pickUpBlock(Coordinate coord) {
        try {
            game.pickUpBlock(coord);
        } catch (CoordinateOutOfBoundException | BlockIsNotPickableException | InventoryIsFullException e) {
            new Alert(Alert.AlertType.WARNING, e.getMessage()).show();
        }

        redraw();
    }
}
