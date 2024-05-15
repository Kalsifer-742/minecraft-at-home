package dev.kalsifer.minecraft.gui.panes;

import dev.kalsifer.minecraft.blocks.interfaces.Block;
import dev.kalsifer.minecraft.blocks.interfaces.SmeltableBlock;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class FurnacePane extends VBox {
    public FurnacePane() {
        super();
    }

    public void draw(SmeltableBlock input, Block output) {
        Text text = new Text("Furnace");
        HBox layout = new HBox();

        layout.getChildren().addAll(
                new BlockPane(input),
                new Text("==>"),
                new BlockPane(output)
        );

        this.getChildren().add(text);
        this.getChildren().add(layout);
    }
}
