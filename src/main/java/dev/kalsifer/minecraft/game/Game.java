package dev.kalsifer.minecraft.game;

import dev.kalsifer.minecraft.blocks.BlockFactory;
import dev.kalsifer.minecraft.blocks.exceptions.BlockIsNotPickableException;
import dev.kalsifer.minecraft.blocks.exceptions.BlockIsNotSmeltableException;
import dev.kalsifer.minecraft.blocks.interfaces.Block;
import dev.kalsifer.minecraft.furnace.Furnace;
import dev.kalsifer.minecraft.blocks.interfaces.SmeltableBlock;
import dev.kalsifer.minecraft.gui.Actions;
import dev.kalsifer.minecraft.inventory.Inventory;
import dev.kalsifer.minecraft.map.Coordinate;
import dev.kalsifer.minecraft.map.CoordinateOutOfBoundException;
import dev.kalsifer.minecraft.map.Map;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class Game extends Pane {
    Map map;
    Furnace furnace;
    Inventory inventory;

    public Game() {
        super();
        this.map = new Map(5);
        this.furnace = BlockFactory.furnaceBlock();
        this.inventory = new Inventory();

        this.draw();
    }

    public void draw() {
        VBox ui = new VBox();
        ui.getChildren().addAll(this.furnace, this.inventory);

        HBox map_ui = new HBox();
        map_ui.getChildren().addAll(this.map, ui);

        VBox root = new VBox();
        root.getChildren().addAll(map_ui, new Actions());

        super.getChildren().add(root);
    }

    public void insertBlockAtCoords(Coordinate coord, Block block) {
        try {
            this.map.insertBlockAtCoords(coord, block);
        } catch (CoordinateOutOfBoundException e) {
            System.err.println(e);
        }
    }

    public void smelt() {
        this.furnace.smelt();
    }

    public void moveFromInventoryToFurnace(int index) throws BlockIsNotSmeltableException {
        Block block;

        try {
            block = this.inventory.removeBlock(index);
        } catch (IndexOutOfBoundsException e) {
            System.err.println(e);
            return;
        }

        if (!(block instanceof SmeltableBlock)) {
            throw new BlockIsNotSmeltableException();
        }
        this.furnace.setInput((SmeltableBlock) block);
    }

    public void moveFromFurnaceToInventory() {
        Block block = this.furnace.getOutput();
        this.inventory.addBlock(block);
    }

    public void pickUpBlock(Coordinate coord) {
        Block block;

        try {
            block = this.map.removeBlockAtCoord(coord);
        } catch (CoordinateOutOfBoundException | BlockIsNotPickableException e) {
            System.err.println(e);
            return;
        }

        this.inventory.addBlock(block);
    }
}
