package dev.kalsifer.minecraft.furnace;

import dev.kalsifer.minecraft.blocks.BlockFactory;
import dev.kalsifer.minecraft.blocks.interfaces.Block;
import dev.kalsifer.minecraft.blocks.interfaces.SmeltableBlock;
import dev.kalsifer.minecraft.gui.BlockPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Furnace extends VBox {
    SmeltableBlock input;
    Block output;

    public Furnace() {
        super();

        this.input = BlockFactory.nullBlock();
        this.output = BlockFactory.nullBlock();

        this.draw();
    }

    public void setInput(SmeltableBlock input) {
        this.input = input;
    }

    public Block getOutput() {
        Block block = this.output;
        this.output = BlockFactory.nullBlock();
        return block;
    }

    public void draw() {
        Text text = new Text("Furnace");
        HBox layout = new HBox();

        layout.getChildren().addAll(
            new BlockPane(this.input),
            new Text("==>"),
            new BlockPane(this.output)
        );

        super.getChildren().add(text);
        super.getChildren().add(layout);
    }

    public void smelt() {
        this.output = input.smelt();
        this.input = BlockFactory.nullBlock();
    }
}
