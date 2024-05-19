package dev.kalsifer.minecraft.gui.panes;

import dev.kalsifer.minecraft.blocks.*;
import dev.kalsifer.minecraft.blocks.interfaces.IronBlockInterface;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import dev.kalsifer.minecraft.blocks.interfaces.Block;
import javafx.scene.paint.Color;

public class BlockPane extends StackPane {
    final Block block;

    public BlockPane(Block block) {
        super();
        this.block = block;

        draw();
    }

    public void draw() {
        setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, new BorderWidths(0.8))));

        ImageView imageView = new ImageView(getBlockTexture(block));
        imageView.setFitWidth(64);
        imageView.setFitHeight(64);
        imageView.setPreserveRatio(true);

        getChildren().add(imageView);

        Tooltip tooltip = new Tooltip(block.toString());
        Tooltip.install(this, tooltip);
    }

    public Image getBlockTexture(Block block) {
        Image image;

        if (block instanceof AirBlock) {
            image = new Image("file:assets/light_blue_concrete.png");
        } else if (block instanceof WaterBlock) {
            image = new Image("file:assets/underwater.png");
        } else if (block instanceof SandBlock) {
            image = new Image("file:assets/sand.png");
        } else if (block instanceof RawIronBlock) {
            image = new Image("file:assets/raw_iron_block.png");
        } else if (block instanceof GlassBlock) {
            image = new Image("file:assets/glass.png");
        } else if (block instanceof IronBlockInterface) {
            image = new Image("file:assets/iron_block.png");
        } else {
            image = new Image("file:assets/empty_slot_ingot.png");
        }

        return image;
    }
}
