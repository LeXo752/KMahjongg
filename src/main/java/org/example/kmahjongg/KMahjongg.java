package org.example.kmahjongg;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.awt.*;
import java.util.Objects;

public class KMahjongg extends Application {
    private TileView selected = null;
    private final Pane gameBoard = new Pane();
    private final String[][][] tiles = TileGenerator.generateMap();

    @Override
    public void start(Stage stage) throws Exception {
//        double width = stage.getWidth();
//        double height = stage.getHeight();
//        double mapWidth = width * 0.625;
//        mapWidth = mapWidth - mapWidth%30;
//        double mapHeight = height * 0.785;
//        mapHeight = mapHeight - mapHeight%16;
//        double xOffset = (width-mapWidth)/2;
//        double yOffset = (height-mapHeight)/2;
        addTile(28,7,0);
        addTile(26,7,0);
        for (int z = 0; z < 5; z++) {
            for (int y = 0; y<15;y+=2) {
                for (int x = 24;x!=0;x-=2) {
                    if (tiles[x][y][z] == null) continue;
                    addTile(x,y,z);
                }
            }
        }
        addTile(13,7,4);
        addTile(0,7,0);

        Scene scene = new Scene(gameBoard, 800, 600);
        stage.setTitle("KMahjongg Java");
        stage.setScene(scene);
        stage.show();
    }

    public Point toPoint(String x) {
        return switch (x) {
            case "1P" -> new Point(0,2);
            case "2P" -> new Point(1,2);
            case "3P" -> new Point(2,2);
            case "4P" -> new Point(3,2);
            case "5P" -> new Point(4,2);
            case "6P" -> new Point(5,2);
            case "7P" -> new Point(6,2);
            case "8P" -> new Point(7,2);
            case "9P" -> new Point(8,2);
            case "1B" -> new Point(0,1);
            case "2B" -> new Point(1,1);
            case "3B" -> new Point(2,1);
            case "4B" -> new Point(3,1);
            case "5B" -> new Point(4,1);
            case "6B" -> new Point(5,1);
            case "7B" -> new Point(6,1);
            case "8B" -> new Point(7,1);
            case "9B" -> new Point(8,1);
            case "1Z" -> new Point(0,0);
            case "2Z" -> new Point(1,0);
            case "3Z" -> new Point(2,0);
            case "4Z" -> new Point(3,0);
            case "5Z" -> new Point(4,0);
            case "6Z" -> new Point(5,0);
            case "7Z" -> new Point(6,0);
            case "8Z" -> new Point(7,0);
            case "9Z" -> new Point(8,0);
            case "W" -> new Point(7,3);
            case "N" -> new Point(4,3);
            case "O" -> new Point(6,3);
            case "S" -> new Point(5,3);
            case "WW" -> new Point(0,4);
            case "G" -> new Point(1,4);
            case "R" -> new Point(2,4);
            case "J1" -> new Point(0,3);
            case "J2" -> new Point(1,3);
            case "J3" -> new Point(2,3);
            case "J4" -> new Point(3,3);
            case "F1" -> new Point(3,4);
            case "F2" -> new Point(4,4);
            case "F3" -> new Point(5,4);
            case "F4" -> new Point(6,4);
            default -> null;
        };
    }
    public void addTile(int x, int y, int z) {
        int TILE_WIDTH = 116;
        int TILE_HEIGHT = 96;
        int xOffset = 4;
        int yOffset = 12;
        TileView tile = new TileView(x, y, z, tiles[x][y][z], toPoint(tiles[x][y][z]));
        double screenX = ((((double) x/3.4) * TILE_WIDTH) + (z * xOffset))+350;
        double screenY = ((((double) y/2.3) * TILE_HEIGHT) - (z * yOffset))+140;
        tile.setLayoutX(screenX);
        tile.setLayoutY(screenY);
        setClickEvent(tile);
        gameBoard.getChildren().add(tile);
    }
    public void setClickEvent(TileView tile) {
//        System.out.println(tile.x);
//        System.out.println(tile.y);
//        System.out.println(tile.z);
        tile.setOnMouseClicked(e -> {
            if (selected != null && (tile == selected || !tile.name.equals(selected.name))) {
                selected.base.changeBase(0);
                selected = null;
            } else {
                if ((tile.name.equals(tiles[0][7][0]) || tile.name.equals(tiles[13][7][4]) || tile.name.equals(tiles[28][7][0])) || ((tiles[tile.x-2][tile.y][tile.z] == null && tiles[tile.x-2][tile.y+1][tile.z] == null || tiles[tile.x+2][tile.y][tile.z] == null && tiles[tile.x+2][tile.y+1][tile.z] == null) && (tiles[tile.x][tile.y][tile.z+1] == null))) {
                    if (tile.z == 3 ) {
                        if (tiles[tile.x+1][tile.y+1][tile.z+1] == null && tiles[tile.x-1][tile.y+1][tile.z+1] == null && tiles[tile.x+1][tile.y-1][tile.z+1] == null && tiles[tile.x-1][tile.y-1][tile.z+1] == null) {
                            
                        }
                    }
                    if (selected == null) {
                        //Base Color Change
                        tile.base.changeBase(1);
                        selected = tile;
                    } else {
                        //Remove wenn alles passt
                        tiles[tile.x][tile.y][tile.z] = null;
                        tiles[selected.x][selected.y][selected.z] = null;
                        gameBoard.getChildren().remove(tile);
                        gameBoard.getChildren().remove(selected);
                        selected = null;
                    }
                } else {
                    //Wenn kein match wieder normale Farbe
                    assert selected != null;
                    selected.base.changeBase(0);
                    selected = null;
                }
            }
        });
    }
}