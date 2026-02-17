package org.example.kmahjongg;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

public class TileBase extends ImageView {
    public static final double tileWidth = 96.0;
    public static final double tileHeight = 116.0;
    public static final Image base = new Image(Objects.requireNonNull(MahjongTile.class.getResourceAsStream("/images/default.png")));

    public TileBase() {
        setImage(base);
        Rectangle2D viewport = new Rectangle2D(
                0,
                0,
                tileWidth,
                tileHeight
        );
        setViewport(viewport);
    }
    public void changeBase(int x) {
        Rectangle2D viewport = new Rectangle2D(
                x*97,
                0,
                tileWidth,
                tileHeight
        );
        setViewport(viewport);
    }
}
