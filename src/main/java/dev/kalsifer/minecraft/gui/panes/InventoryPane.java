package dev.kalsifer.minecraft.gui.panes;

import dev.kalsifer.minecraft.blocks.interfaces.Block;
import dev.kalsifer.minecraft.gui.event_handlers.InventaryBlockClickedEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.awt.*;
import java.util.Iterator;

public class InventoryPane extends VBox {
    InventaryBlockClickedEventHandler inventaryBlockClickedEventHandler;

    public InventoryPane(InventaryBlockClickedEventHandler inventaryBlockClickedEventHandler) {
        super();

        this.inventaryBlockClickedEventHandler = inventaryBlockClickedEventHandler;
    }

    public void draw(Iterator<Block> blocksIterator) {
        setBackground(new Background(new BackgroundImage(new Image("file:assets/bamboo_block.png"), null, null, null, null)));
        setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, null)));
        setSpacing(32);
        setAlignment(Pos.TOP_CENTER);

        Label title = new Label("Inventory");

        TilePane blocks = new TilePane();
        blocks.setHgap(16);
        blocks.setVgap(16);
        setMargin(blocks, new Insets(8));
        blocks.setOnMouseClicked(inventaryBlockClickedEventHandler);

        while (blocksIterator.hasNext()) {
            blocks.getChildren().add(new BlockPane(blocksIterator.next()));
        }

        super.getChildren().addAll(title, blocks);
    }
}
