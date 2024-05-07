package unitn.minecraft.game;

import unitn.minecraft.blocks.exceptions.BlockIsNotPickableException;
import unitn.minecraft.blocks.exceptions.BlockIsNotSmeltableException;
import unitn.minecraft.blocks.interfaces.Block;
import unitn.minecraft.blocks.BlockFactory;
import unitn.minecraft.furnace.Furnace;
import unitn.minecraft.blocks.interfaces.SmeltableBlock;
import unitn.minecraft.gui.GUI;
import unitn.minecraft.inventory.Inventory;
import unitn.minecraft.map.Coordinate;
import unitn.minecraft.map.CoordinateOutOfBoundException;
import unitn.minecraft.map.Map;

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
