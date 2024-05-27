package dev.kalsifer.minecraft.model.furnace;

import dev.kalsifer.minecraft.model.blocks.BlockFactory;
import dev.kalsifer.minecraft.model.blocks.NullBlock;
import dev.kalsifer.minecraft.model.blocks.interfaces.Block;
import dev.kalsifer.minecraft.model.blocks.interfaces.SmeltableBlock;
import dev.kalsifer.minecraft.model.furnace.exceptions.BlockIsNullException;
import dev.kalsifer.minecraft.model.furnace.exceptions.InputIsNotEmptyException;
import dev.kalsifer.minecraft.model.furnace.exceptions.OutputIsNotEmptyException;

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
