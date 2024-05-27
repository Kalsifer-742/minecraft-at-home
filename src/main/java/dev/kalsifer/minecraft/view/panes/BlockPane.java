package dev.kalsifer.minecraft.view.panes;

import dev.kalsifer.minecraft.view.Texture;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import dev.kalsifer.minecraft.model.blocks.interfaces.Block;
import javafx.scene.paint.Color;

public class BlockPane extends StackPane {

    public BlockPane(Block block) {
        super();

        setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, new BorderWidths(0.8))));

        ImageView imageView = new ImageView(Texture.getBlockTexture(block));
        imageView.setFitWidth(64);
        imageView.setFitHeight(64);
        imageView.setPreserveRatio(true);

        getChildren().add(imageView);

        Tooltip tooltip = new Tooltip(block.toString());
        Tooltip.install(this, tooltip);
    }
}
