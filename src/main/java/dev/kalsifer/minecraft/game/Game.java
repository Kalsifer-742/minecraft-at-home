package dev.kalsifer.minecraft.game;

import dev.kalsifer.minecraft.blocks.BlockFactory;
import dev.kalsifer.minecraft.blocks.exceptions.BlockIsNotPickableException;
import dev.kalsifer.minecraft.blocks.exceptions.BlockIsNotSmeltableException;
import dev.kalsifer.minecraft.blocks.interfaces.Block;
import dev.kalsifer.minecraft.furnace.Furnace;
import dev.kalsifer.minecraft.blocks.interfaces.SmeltableBlock;
import dev.kalsifer.minecraft.inventory.Inventory;
import dev.kalsifer.minecraft.inventory.InventoryIsFullException;
import dev.kalsifer.minecraft.map.Coordinate;
import dev.kalsifer.minecraft.map.CoordinateOutOfBoundException;
import dev.kalsifer.minecraft.map.Map;

import java.util.Collection;

public class Game {
    final Map map;
    final Furnace furnace;
    final Inventory inventory;

    public Game() {
        super();
        this.map = new Map(8);
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

    public void insertBlockAtCoords(Coordinate coord, Block block) throws CoordinateOutOfBoundException {
        this.map.insertBlockAtCoords(coord, block);
    }

    public void smelt() {
        this.furnace.smelt();
    }

    public void moveFromInventoryToFurnace(int index) throws IndexOutOfBoundsException, BlockIsNotSmeltableException {
        Block block = this.inventory.removeBlock(index);

        if (!(block instanceof SmeltableBlock)) {
            throw new BlockIsNotSmeltableException();
        }

        this.furnace.setInput((SmeltableBlock) block);
    }

    public void moveFromFurnaceToInventory() throws InventoryIsFullException {
        Block block = this.furnace.removeOutput();
        this.inventory.addBlock(block);
    }

    public void pickUpBlock(Coordinate coord) throws CoordinateOutOfBoundException, BlockIsNotPickableException, InventoryIsFullException {
        if (inventory.getSize() >= 8) {
            throw new InventoryIsFullException();
        }

        Block block = map.removeBlockAtCoord(coord);

        inventory.addBlock(block);
    }
}
