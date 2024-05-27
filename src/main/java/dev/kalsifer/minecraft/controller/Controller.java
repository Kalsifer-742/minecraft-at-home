package dev.kalsifer.minecraft.controller;

import dev.kalsifer.minecraft.controller.controllers.*;
import dev.kalsifer.minecraft.model.clipboard.exceptions.ClipBoardIsEmptyException;
import dev.kalsifer.minecraft.model.clipboard.exceptions.ClipBoardIsNotEmptyException;
import dev.kalsifer.minecraft.model.map.exceptions.BlockIsNotPickableException;
import dev.kalsifer.minecraft.model.furnace.exceptions.BlockIsNotSmeltableException;
import dev.kalsifer.minecraft.model.furnace.exceptions.BlockIsNullException;
import dev.kalsifer.minecraft.model.furnace.exceptions.InputIsNotEmptyException;
import dev.kalsifer.minecraft.model.furnace.exceptions.OutputIsNotEmptyException;
import dev.kalsifer.minecraft.model.Model;
import dev.kalsifer.minecraft.view.View;
import dev.kalsifer.minecraft.model.inventory.exceptions.InventoryIsFullException;
import dev.kalsifer.minecraft.model.map.Coordinate;
import dev.kalsifer.minecraft.model.map.exceptions.CoordinateOutOfBoundException;
import javafx.scene.control.Alert;

import java.util.ArrayList;

public class Controller implements SimpleController {
    final Model model;
    final View view;
    final ArrayList<SimpleController> controllerList;
    final MapController mapController;
    final FurnaceController furnaceController;
    final InventoryController inventoryController;
    final ClipboardController clipboardController;
    boolean clipboardModifier;

    public Controller(Model game){
        this.model = game;
        view = new View(this);
        clipboardModifier = false;

        controllerList = new ArrayList<>();
        mapController = new MapController(game.getMap(), view.getMapPane());
        furnaceController = new FurnaceController(game.getFurnace(), view.getFurnacePane());
        inventoryController = new InventoryController(game.getInventory(), view.getInventoryPane());
        clipboardController = new ClipboardController(game.getClipboard(), view.getClipboardPane());
        controllerList.add(mapController);
        controllerList.add(furnaceController);
        controllerList.add(inventoryController);
        controllerList.add(clipboardController);
    }

    public View getView() {
        return view;
    }

    public void setClipboardModifier(boolean status) {
        clipboardModifier = status;
    }

    public boolean getClipboardModifier() {
        return clipboardModifier;
    }

    @Override
    public void redraw() {
        for (SimpleController controller: controllerList) {
            controller.redraw();
        }
    }

    public void moveFromInventoryToFurnace(int index) {
        try {
            model.moveFromInventoryToFurnace(index);
        } catch (BlockIsNotSmeltableException | InputIsNotEmptyException e) {
            new Alert(Alert.AlertType.WARNING, e.getMessage()).show();
        }

        redraw();
    }

    public void smelt() {
        try {
            model.smelt();
        } catch (BlockIsNullException | OutputIsNotEmptyException e) {
            new Alert(Alert.AlertType.WARNING, e.getMessage()).show();
        }

        redraw();
    }

    public void moveInputFromFurnaceToInventory() {
        try {
            model.moveInputFromFurnaceToInventory();
        } catch (InventoryIsFullException | BlockIsNullException e) {
            new Alert(Alert.AlertType.WARNING, e.getMessage()).show();
        }

        redraw();
    }

    public void moveOutputFromFurnaceToInventory() {
        try {
            model.moveOutputFromFurnaceToInventory();
        } catch (InventoryIsFullException | BlockIsNullException e) {
            new Alert(Alert.AlertType.WARNING, e.getMessage()).show();
        }

        redraw();
    }

    public void moveBlockFromInventoryToClipboard(int index) {
        try {
            model.moveBlockFromInventoryToClipboard(index);
        } catch (IndexOutOfBoundsException | ClipBoardIsNotEmptyException e) {
            new Alert(Alert.AlertType.WARNING, e.getMessage()).show();
        }
        clipboardController.updateClipboardView(model.getClipboard());

        redraw();
    }

    public void placeBlockFromClipboard(Coordinate coord) {
        try {
            model.placeBlockFromClipboard(coord);
        } catch (CoordinateOutOfBoundException | ClipBoardIsEmptyException e) {
            new Alert(Alert.AlertType.WARNING, e.getMessage()).show();
        }
        clipboardController.updateClipboardView(model.getClipboard());

        redraw();
    }

    public void mineBlockAtCoord(Coordinate coord) {
        try {
            model.mineBlockAtCoord(coord);
        } catch (CoordinateOutOfBoundException | BlockIsNotPickableException | InventoryIsFullException e) {
            new Alert(Alert.AlertType.WARNING, e.getMessage()).show();
        }

        redraw();
    }
}
