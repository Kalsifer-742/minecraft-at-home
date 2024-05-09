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

    public void setInput(SmeltableBlock input) {
        this.input = input;
    }

    public Block getOutput() {
        Block block = this.output;
        this.output = BlockFactory.nullBlock();
        return block;
    }

    public void displayOnOut() {
        System.out.println(
                "F || "
                + this.input.display()
                + " --> "
                + this.output.display()
                + " ||"
        );
    }

    public void smelt() {
        this.output = input.smelt();
        this.input = BlockFactory.nullBlock();
    }
}
