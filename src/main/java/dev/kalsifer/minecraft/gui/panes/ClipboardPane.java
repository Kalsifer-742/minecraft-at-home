package dev.kalsifer.minecraft.gui.panes;

import dev.kalsifer.minecraft.blocks.interfaces.Block;
import dev.kalsifer.minecraft.gui.controllers.MainController;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class ClipboardPane extends VBox {
    public ClipboardPane() {
        super();
    }

    public void draw(Block block) {
        setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, null)));
        setSpacing(16);
        setAlignment(Pos.TOP_CENTER);

        Label title = new Label("Clipboard");

        BlockPane clipboard = new BlockPane(block);

        getChildren().addAll(title, clipboard);
    }
}
