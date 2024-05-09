package dev.kalsifer.minecraft.gui;

import dev.kalsifer.minecraft.blocks.BlockFactory;
import dev.kalsifer.minecraft.blocks.NullBlock;
import dev.kalsifer.minecraft.inventory.BlockComparator;
import javafx.scene.layout.StackPane;
import dev.kalsifer.minecraft.blocks.interfaces.Block;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class BlockPane extends StackPane {
    Block block;

    public BlockPane(Block block) {
        super();
        this.block = block;

        Rectangle background = new Rectangle(100, 100, getBlockColor(this.block));
        Text text = new Text("" + this.block.display());

        super.getChildren().add(background);
        super.getChildren().add(text);
    }

    private Color getBlockColor(Block block) {
        int block_code = BlockComparator.blockValue(block);

        if (block_code == 0) {
            return Color.BLACK;
        }
        if (block_code == 1) {
            return Color.LIGHTGRAY;
        }
        if (block_code == 2) {
            return Color.BLUE;
        }
        if (block_code == 3) {
            return Color.YELLOW;
        }
        if (block_code == 4) {
            return Color.LIGHTBLUE;
        }
        if (block_code == 5) {
            return Color.SANDYBROWN;
        }
        if (block_code == 6) {
            return Color.SILVER;
        }
        return Color.PURPLE;
    }
}
