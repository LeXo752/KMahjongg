package org.example.kmahjongg;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class TileView extends StackPane {

    // Wir speichern die logischen Koordinaten, damit wir später wissen, welcher Stein das ist
    public int x, y, z;

    public TileView(int x, int y, int z, String text) {
        this.x = x;
        this.y = y;
        this.z = z;

        // 1. Der Körper des Steins (Weiß mit schwarzem Rand)
        Rectangle body = new Rectangle(50, 70); // Breite 50, Höhe 70
        body.setFill(Color.BEIGE);
        body.setStroke(Color.BLACK);
        body.setStrokeWidth(2);

        // Simulierter 3D-Effekt (Schatten rechts und unten)
        // In einem echten Spiel würdest du hier Bilder laden, aber für den Anfang reicht Text/Rechteck

        // 2. Das Symbol (hier erst mal Text, später ein Bild)
        Text symbol = new Text(text);
        symbol.setStyle("-fx-font-size: 20px;");

        // Beides übereinander stapeln
        this.getChildren().addAll(body, symbol);
    }
}