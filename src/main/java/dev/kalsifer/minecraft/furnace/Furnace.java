package dev.kalsifer.minecraft.furnace;

import dev.kalsifer.minecraft.blocks.BlockFactory;
import dev.kalsifer.minecraft.blocks.interfaces.Block;
import dev.kalsifer.minecraft.blocks.interfaces.SmeltableBlock;

public class Furnace {
    SmeltableBlock input;
    Block output;

    public Furnace() {
        this.input = BlockFactory.nullBlock();
        this.output = BlockFactory.nullBlock();
    }

    public SmeltableBlock getInput() {
        return this.input;
    }

    public void setInput(SmeltableBlock input) {
        this.input = input;
    }

    public Block getOutput() {
        return this.output;
    }

    public Block removeOutput() {
        Block tmp = this.output;
        this.output = BlockFactory.nullBlock();
        return tmp;
    }

    public void smelt() {
        this.output = input.smelt();
        this.input = BlockFactory.nullBlock();
    }
}
