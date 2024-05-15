package dev.kalsifer.minecraft.game;

import dev.kalsifer.minecraft.blocks.BlockFactory;
import dev.kalsifer.minecraft.blocks.exceptions.BlockIsNotPickableException;
import dev.kalsifer.minecraft.blocks.exceptions.BlockIsNotSmeltableException;
import dev.kalsifer.minecraft.blocks.interfaces.Block;
import dev.kalsifer.minecraft.furnace.Furnace;
import dev.kalsifer.minecraft.blocks.interfaces.SmeltableBlock;
import dev.kalsifer.minecraft.inventory.Inventory;
import dev.kalsifer.minecraft.map.Coordinate;
import dev.kalsifer.minecraft.map.CoordinateOutOfBoundException;
import dev.kalsifer.minecraft.map.Map;
import javafx.scene.layout.Pane;

public class Game {
    Map map;
    Furnace furnace;
    Inventory inventory;

    public Game() {
        super();
        this.map = new Map(5);
        this.furnace = BlockFactory.furnaceBlock();
        this.inventory = new Inventory();
    }

    public Map getMap() {
        return map;
    }

    public Furnace getFurnace() {
        return furnace;
    }

    public Inventory getInventory() {
        return inventory;
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
