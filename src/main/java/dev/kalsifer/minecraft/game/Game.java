package dev.kalsifer.minecraft.game;

import dev.kalsifer.minecraft.blocks.BlockFactory;
import dev.kalsifer.minecraft.blocks.exceptions.BlockIsNotPickableException;
import dev.kalsifer.minecraft.blocks.exceptions.BlockIsNotSmeltableException;
import dev.kalsifer.minecraft.blocks.interfaces.Block;
import dev.kalsifer.minecraft.furnace.Furnace;
import dev.kalsifer.minecraft.blocks.interfaces.SmeltableBlock;
import dev.kalsifer.minecraft.gui.GUI;
import dev.kalsifer.minecraft.inventory.Inventory;
import dev.kalsifer.minecraft.map.Coordinate;
import dev.kalsifer.minecraft.map.CoordinateOutOfBoundException;
import dev.kalsifer.minecraft.map.Map;

public class Game {
    Map map;
    Furnace furnace;
    Inventory inventory;
    GUI gui;

    public Game() {
        this.map = new Map(5);
        this.furnace = BlockFactory.furnaceBlock();
        this.inventory = new Inventory();
        this.gui = new GUI(this.map, this.furnace, this.inventory);
    }

    public void display() {
        this.gui.display();
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

    public void test() {
        this.display();
        System.out.println("All test PASSED");
    }
}
