package org.example.kmahjongg;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.Objects;

public class MahjongTile extends ImageView {
    private static final double TILE_WIDTH = 69.0;
    private static final double TILE_HEIGHT = 89.0;
    private static final Image TILE_SHEET = new Image(Objects.requireNonNull(MahjongTile.class.getResourceAsStream("/images/default.png")));

    public MahjongTile(int x, int y) {
        setImage(TILE_SHEET);
        Rectangle2D viewport = new Rectangle2D(
                x * TILE_WIDTH,
                y * TILE_HEIGHT + 116,
                TILE_WIDTH,
                TILE_HEIGHT
        );
        setViewport(viewport);
    }
}