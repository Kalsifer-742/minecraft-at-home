package dev.kalsifer.minecraft.gui.controllers;

import dev.kalsifer.minecraft.blocks.BlockFactory;
import dev.kalsifer.minecraft.blocks.exceptions.BlockIsNotPickableException;
import dev.kalsifer.minecraft.blocks.exceptions.BlockIsNotSmeltableException;
import dev.kalsifer.minecraft.blocks.interfaces.Block;
import dev.kalsifer.minecraft.game.Game;
import dev.kalsifer.minecraft.gui.GUI;
import dev.kalsifer.minecraft.map.Coordinate;
import dev.kalsifer.minecraft.map.CoordinateOutOfBoundException;
import javafx.scene.control.Alert;

import java.util.ArrayList;

public class MainController implements SimpleController {
    final Game game;
    final GUI gui;
    final ArrayList<SimpleController> controllerList;
    final MapController mapController;
    final FurnaceController furnaceController;
    final InventoryController inventoryController;

    public MainController(Game game){
        this.game = game;
        gui = new GUI(this);
        controllerList = new ArrayList<>();
        mapController = new MapController(game.getMap(), gui.getMapPane());
        furnaceController = new FurnaceController(game.getFurnace(), gui.getFurnacePane());
        inventoryController = new InventoryController(game.getInventory(), gui.getInventoryPane());
        controllerList.add(mapController);
        controllerList.add(furnaceController);
        controllerList.add(inventoryController);
    }

    public GUI getGui() {
        return gui;
    }

    @Override
    public void redraw() {
        for (SimpleController controller: controllerList) {
            controller.redraw();
        }
    }

    public void insertBlockAtCoords(Coordinate coord, Block block) {
        try {
            game.insertBlockAtCoords(coord, BlockFactory.sandBlock());
        } catch (CoordinateOutOfBoundException e) {
            new Alert(Alert.AlertType.WARNING, e.getMessage()).show();
        }
        redraw();
    }

    public void moveFromInventoryToFurnace(int index) {
        try {
            game.moveFromInventoryToFurnace(index);
        } catch (BlockIsNotSmeltableException e) {
            new Alert(Alert.AlertType.WARNING, e.getMessage()).show();
        }
        redraw();
    }

    public void smelt() {
        game.smelt();
        redraw();
    }

    public void moveFromFurnaceToInventory() {
        game.moveFromFurnaceToInventory();
        redraw();
    }

    public void pickUpBlock(Coordinate coord) {
        try {
            game.pickUpBlock(coord);
        } catch (CoordinateOutOfBoundException | BlockIsNotPickableException e) {
            new Alert(Alert.AlertType.WARNING, e.getMessage()).show();
        }

        redraw();
    }
}
