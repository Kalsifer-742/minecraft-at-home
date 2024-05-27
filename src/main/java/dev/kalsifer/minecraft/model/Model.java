package dev.kalsifer.minecraft.model;

import dev.kalsifer.minecraft.model.blocks.BlockFactory;
import dev.kalsifer.minecraft.model.blocks.NullBlock;
import dev.kalsifer.minecraft.model.clipboard.exceptions.ClipBoardIsEmptyException;
import dev.kalsifer.minecraft.model.clipboard.exceptions.ClipBoardIsNotEmptyException;
import dev.kalsifer.minecraft.model.map.exceptions.BlockIsNotPickableException;
import dev.kalsifer.minecraft.model.furnace.exceptions.BlockIsNotSmeltableException;
import dev.kalsifer.minecraft.model.blocks.interfaces.Block;
import dev.kalsifer.minecraft.model.furnace.exceptions.BlockIsNullException;
import dev.kalsifer.minecraft.model.furnace.Furnace;
import dev.kalsifer.minecraft.model.blocks.interfaces.SmeltableBlock;
import dev.kalsifer.minecraft.model.furnace.exceptions.InputIsNotEmptyException;
import dev.kalsifer.minecraft.model.furnace.exceptions.OutputIsNotEmptyException;
import dev.kalsifer.minecraft.model.inventory.Inventory;
import dev.kalsifer.minecraft.model.inventory.exceptions.InventoryIsFullException;
import dev.kalsifer.minecraft.model.map.Coordinate;
import dev.kalsifer.minecraft.model.map.exceptions.CoordinateOutOfBoundException;
import dev.kalsifer.minecraft.model.map.Map;

public class Model {
    final Map map;
    final Furnace furnace;
    final Inventory inventory;
    Block clipboard;

    public Model() {
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

    public void moveBlockFromInventoryToClipboard(int index) throws IndexOutOfBoundsException, ClipBoardIsNotEmptyException {
        if (!(clipboard instanceof NullBlock)) {
            throw new ClipBoardIsNotEmptyException();
        }

        clipboard = this.inventory.removeBlock(index);
    }

    public void placeBlockFromClipboard(Coordinate coord) throws CoordinateOutOfBoundException, ClipBoardIsEmptyException {
        if (clipboard instanceof NullBlock) {
            throw new ClipBoardIsEmptyException();
        }

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

    public void mineBlockAtCoord(Coordinate coord) throws CoordinateOutOfBoundException, BlockIsNotPickableException, InventoryIsFullException {
        if (inventory.getSize() >= 8) {
            throw new InventoryIsFullException();
        }

        Block block = map.mineBlockAtCoord(coord);

        inventory.addBlock(block);
    }
}
