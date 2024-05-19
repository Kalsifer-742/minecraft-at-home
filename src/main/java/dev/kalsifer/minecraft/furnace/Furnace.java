package dev.kalsifer.minecraft.furnace;

import dev.kalsifer.minecraft.blocks.BlockFactory;
import dev.kalsifer.minecraft.blocks.NullBlock;
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

    public void setInput(SmeltableBlock input) throws InputIsNotEmptyException {
        if (!(this.input instanceof NullBlock)){
            throw new InputIsNotEmptyException();
        }

        this.input = input;
    }

    public Block getOutput() {
        return this.output;
    }

    public SmeltableBlock removeInput() throws BlockIsNullException {
        if (this.input instanceof NullBlock){
            throw new BlockIsNullException("Input is empty");
        }

        SmeltableBlock tmp = this.input;
        this.input = BlockFactory.nullBlock();
        return tmp;
    }

    public Block removeOutput() throws BlockIsNullException {
        if (this.output instanceof NullBlock){
            throw new BlockIsNullException("Output is empty");
        }

        Block tmp = this.output;
        this.output = BlockFactory.nullBlock();
        return tmp;
    }

    public void smelt() throws BlockIsNullException, OutputIsNotEmptyException {
        if (this.input instanceof NullBlock){
            throw new BlockIsNullException("Nothing to smelt");
        } else if (!(this.output instanceof NullBlock)) {
            throw new OutputIsNotEmptyException();
        }

        this.output = input.smelt();
        this.input = BlockFactory.nullBlock();
    }
}
