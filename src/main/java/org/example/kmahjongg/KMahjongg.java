package org.example.kmahjongg;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class KMahjongg extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Pane gameBoard = new Pane();

        double width = stage.getWidth();
        double height = stage.getHeight();
        double mapWidth = width * 0.625;
        double mapHeight = height * 0.785;
        mapWidth += (width-mapWidth)/2;
        mapHeight += (height-mapHeight)/2;
        //Für die map nehme ich 62,5 % x 78,5 % von der Fenster größe (Akkurat zu KMahjongg auf KDE)


        // Konstanten für die Größe
        int TILE_WIDTH = 50;
        int TILE_HEIGHT = 70;
        int OFFSET = 10; // Versatz für 3D-Effekt

        // Wir bauen einen kleinen Turm: 3 Steine übereinander
        for (int z = 0; z < 3; z++) {
            // Wir machen sie leicht versetzt, damit man es besser sieht
            int x = 2;
            int y = 2;

            TileView tile = new TileView(x, y, z, "Z:" + z);

            // Die Magie: Berechnung der Bildschirmposition
            // Je höher z, desto weiter nach rechts oben verschieben wir den Stein
            double screenX = x * TILE_WIDTH + (z * OFFSET);
            double screenY = y * TILE_HEIGHT - (z * OFFSET);

            tile.setLayoutX(screenX);
            tile.setLayoutY(screenY);

            // Klick-Event hinzufügen
            tile.setOnMouseClicked(e -> {
                System.out.println("Stein angeklickt auf Ebene: " + tile.z);
                // Hier später: Prüfen, ob Stein frei ist, dann entfernen
                // gameBoard.getChildren().remove(tile);
            });

            // WICHTIG: Zum Board hinzufügen
            gameBoard.getChildren().add(tile);
        }

        Scene scene = new Scene(gameBoard, 800, 600);
        stage.setTitle("KMahjongg Java");
        stage.setScene(scene);
        stage.show();
    }
}