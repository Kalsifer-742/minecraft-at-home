package dev.kalsifer.minecraft.gui.controllers;

import dev.kalsifer.minecraft.blocks.BlockFactory;
import dev.kalsifer.minecraft.blocks.SandBlock;
import dev.kalsifer.minecraft.blocks.exceptions.BlockIsNotSmeltableException;
import dev.kalsifer.minecraft.blocks.interfaces.Block;
import dev.kalsifer.minecraft.game.Game;
import dev.kalsifer.minecraft.gui.GUI;
import dev.kalsifer.minecraft.map.Coordinate;

import java.util.ArrayList;
import java.util.Collection;

public class MainController implements SimpleController {
    Game game;
    GUI gui;
    ArrayList<SimpleController> controllerList;
    MapController mapController;
    FurnaceController furnaceController;
    InventoryController inventoryController;

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
        game.insertBlockAtCoords(coord, BlockFactory.sandBlock());
        redraw();
    }

    public void moveFromInventoryToFurnace(int index) throws BlockIsNotSmeltableException {
        game.moveFromInventoryToFurnace(index);
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
        game.pickUpBlock(coord);
        redraw();
    }
}
