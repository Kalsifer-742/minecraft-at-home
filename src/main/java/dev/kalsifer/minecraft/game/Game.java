package dev.kalsifer.minecraft.game;

import dev.kalsifer.minecraft.blocks.AbstractBlock;
import dev.kalsifer.minecraft.blocks.BlockFactory;
import dev.kalsifer.minecraft.blocks.NullBlock;
import dev.kalsifer.minecraft.blocks.exceptions.BlockIsNotPickableException;
import dev.kalsifer.minecraft.blocks.exceptions.BlockIsNotSmeltableException;
import dev.kalsifer.minecraft.blocks.interfaces.Block;
import dev.kalsifer.minecraft.furnace.BlockIsNullException;
import dev.kalsifer.minecraft.furnace.Furnace;
import dev.kalsifer.minecraft.blocks.interfaces.SmeltableBlock;
import dev.kalsifer.minecraft.furnace.InputIsNotEmptyException;
import dev.kalsifer.minecraft.furnace.OutputIsNotEmptyException;
import dev.kalsifer.minecraft.inventory.Inventory;
import dev.kalsifer.minecraft.inventory.InventoryIsFullException;
import dev.kalsifer.minecraft.map.Coordinate;
import dev.kalsifer.minecraft.map.CoordinateOutOfBoundException;
import dev.kalsifer.minecraft.map.Map;

public class Game {
    final Map map;
    final Furnace furnace;
    final Inventory inventory;
    Block clipboard;

    public Game() {
        map = new Map(8);
        furnace = BlockFactory.furnaceBlock();
        inventory = new Inventory();
        clipboard = BlockFactory.nullBlock();
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

    public Block getClipboard() {
        return clipboard;
    }

    public void moveBlockFromInventoryToClipboard(int index) throws IndexOutOfBoundsException{
        clipboard = this.inventory.removeBlock(index);
    }

    public void placeBlockFromClipboard(Coordinate coord) throws CoordinateOutOfBoundException {
        map.insertBlockAtCoords(coord, clipboard);
        clipboard = BlockFactory.nullBlock();
    }

    public void smelt() throws BlockIsNullException, OutputIsNotEmptyException {
        this.furnace.smelt();
    }

    public void moveFromInventoryToFurnace(int index) throws IndexOutOfBoundsException, BlockIsNotSmeltableException, InputIsNotEmptyException {
        if (!(furnace.getInput() instanceof NullBlock)){
            throw new InputIsNotEmptyException();
        }
        if (!(this.inventory.getBlock(index) instanceof SmeltableBlock)) {
            throw new BlockIsNotSmeltableException();
        }

        Block block = this.inventory.removeBlock(index);
        this.furnace.setInput((SmeltableBlock) block);
    }

    public void moveInputFromFurnaceToInventory() throws InventoryIsFullException, BlockIsNullException {
        SmeltableBlock block = this.furnace.removeInput();
        this.inventory.addBlock(block);
    }

    public void moveOutputFromFurnaceToInventory() throws InventoryIsFullException, BlockIsNullException {
        Block block = this.furnace.removeOutput();
        this.inventory.addBlock(block);
    }

    public void pickUpBlock(Coordinate coord) throws CoordinateOutOfBoundException, BlockIsNotPickableException, InventoryIsFullException {
        if (inventory.getSize() >= 8) {
            throw new InventoryIsFullException();
        }

        Block block = map.mineBlockAtCoord(coord);

        inventory.addBlock(block);
    }
}
