package org.example.kmahjongg;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class KMahjongg extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Pane gameBoard = new Pane();

        String[][][] tiles = TileGenerator.generateMap();

        double width = stage.getWidth();
        double height = stage.getHeight();
        double mapWidth = width * 0.625;
        mapWidth = mapWidth - mapWidth%30;
        double mapHeight = height * 0.785;
        mapHeight = mapHeight - mapHeight%16;
        double xOffset = (width-mapWidth)/2;
        double yOffset = (height-mapHeight)/2;
        //Für die map nehmen wir 62,5 % x 78,5 % von der Fenster größe (Akkurat zu KMahjongg auf KDE)


        int TILE_WIDTH = (int) (2*(mapWidth));
        int TILE_HEIGHT = (int) (2*(mapHeight));;
        int OFFSET = 10;

        for (int z = 0; z < 5; z++) {
            for (int y = 0; y<15;y+=2) {
                for (int x = 0;x<29;x+=2) {
                    if (tiles[x][y][z] == null) continue;
                    TileView tile = new TileView(x, y, z, tiles[x][y][z]);
                    double screenX = (x * TILE_WIDTH + (z * OFFSET) + x * 30)+350;
                    double screenY = (y * TILE_HEIGHT - (z * OFFSET) + y * 30)+140;
                    tile.setLayoutX(screenX);
                    tile.setLayoutY(screenY);

                    tile.setOnMouseClicked(e -> {
                        System.out.println("Stein angeklickt auf Ebene: " + tile.z);
                        System.out.println(tile.x);
                        System.out.println(tile.y);
                        System.out.println(tile.name);
                    });
                    gameBoard.getChildren().add(tile);
                }
            }
        }
        for (int i = 1; i!=5;i++) {
            int x = 0;
            int y = 7;
            int z = 0;
            if (i == 2) {
                x = 14;
                z = 4;
            } else if (i == 3) {
                x = 26;
            } else if (i == 4) {
                x = 28;
            }
            TileView tile = new TileView(x, y, z, tiles[x][y][z]);
            double screenX = (x * TILE_WIDTH + (z * OFFSET) + x * 30)+350;
            double screenY = (y * TILE_HEIGHT - (z * OFFSET) + y * 30)+140;
            tile.setLayoutX(screenX);
            tile.setLayoutY(screenY);

            tile.setOnMouseClicked(e -> {
                System.out.println("Stein angeklickt auf Ebene: " + tile.z);
                System.out.println(tile.x);
                System.out.println(tile.y);
                System.out.println(tile.name);
            });
            gameBoard.getChildren().add(tile);
        }

        Scene scene = new Scene(gameBoard, 800, 600);
        stage.setTitle("KMahjongg Java");
        stage.setScene(scene);
        stage.show();
    }
}