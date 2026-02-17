package org.example.kmahjongg;

import javafx.scene.layout.StackPane;

import java.awt.*;

public class TileView extends StackPane {

    public int x, y, z;
    public String name;
    public TileBase base = new TileBase();
    public TileView(int x, int y, int z, String text, Point p) {
        this.x = x;
        this.y = y;
        this.z = z;

        MahjongTile symbol = new MahjongTile(p.x, p.y);
        symbol.setTranslateX(12);
        symbol.setTranslateY(-12);
        name = text;

        this.getChildren().addAll(base, symbol);
    }
}