package dev.kalsifer.minecraft.gui.panes;

import dev.kalsifer.minecraft.blocks.interfaces.Block;
import dev.kalsifer.minecraft.blocks.interfaces.SmeltableBlock;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Text;

import java.awt.*;

public class FurnacePane extends VBox {
    public FurnacePane() {
        super();
    }

    public void draw(SmeltableBlock input, Block output) {
        setBackground(new Background(new BackgroundImage(new Image("file:assets/furnace.png"), null, null, null, null)));
        setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, null)));
        setSpacing(32);
        setAlignment(Pos.TOP_CENTER);

        Label title = new Label("Furnace");

        BlockPane inputBlock = new BlockPane(input);
        BlockPane outputBlock = new BlockPane(output);

        HBox items = new HBox();
        items.setSpacing(32);
        items.getChildren().addAll(inputBlock, outputBlock);

        getChildren().addAll(title, items);
    }
}
