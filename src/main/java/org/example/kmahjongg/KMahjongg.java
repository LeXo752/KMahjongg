package org.example.kmahjongg;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.awt.*;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javafx.scene.control.Button;
import javafx.scene.shape.Rectangle;

public class KMahjongg extends Application {
    private final Text text = new Text("");
    public static int xBlume = -1;
    public static int xSeason = 2;
    private TileView selected = null;
    private final Pane gameBoard = new Pane();
    private String[][][] tiles;

    @Override
    public void start(Stage stage) throws Exception {
        InputStream input = getClass().getResourceAsStream("/images/egyptian.png");
        assert input != null;
        Image image = new Image(input);
        ImageView backgroundView = new ImageView(image);
        backgroundView.setOnMouseClicked(e -> {
            if (selected != null) {
                selected.base.changeBase(0);
                selected = null;
            }
        });
//        backgroundView.fitWidthProperty().bind(stage.widthProperty());
//        backgroundView.fitHeightProperty().bind(stage.heightProperty());
        gameBoard.getChildren().add(backgroundView);

        Rectangle top = new Rectangle(0,0, 1920,40);
        top.setFill(Color.color((double) 101 /255, (double) 103 /255, (double) 105 /255));
        // 37, 150, 190
        gameBoard.getChildren().add(top);
        
        generateGame();
        countPossibleCombinations();

        Button newGame = new Button("New Game");
        newGame.setOnAction(actionEvent -> {
            generateGame();
        });
        StackPane btn = new StackPane(newGame);

        StackPane possibleC = new StackPane();

        possibleC.getChildren().addAll(this.text);
        possibleC.setTranslateX(300);

        gameBoard.getChildren().addAll(btn, possibleC);

        Scene scene = new Scene(gameBoard, 1920, 1080);

        stage.setTitle("KMahjongg Java");
        stage.setScene(scene);
        stage.show();
    }

    public void generateGame() {
        xBlume = -1;
        xSeason = 2;
        gameBoard.getChildren().removeIf(node -> node instanceof TileView);        selected = null;
        tiles = TileGenerator.generateMap();
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
            case "" -> new Point(0,4);
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
        tile.setOnMouseClicked(e -> {
            boolean valid = isValid(tile);
            if (valid) {
                if (selected == tile) {
                    selected.base.changeBase(0);
                    selected = null;
                    return;
                }
                if (selected != null && !tile.name.equals(selected.name)) {
                    selected.base.changeBase(0);
                    selected = null;
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
                    countPossibleCombinations();
                }
            } else if (selected != null) {
                selected.base.changeBase(0);
                selected = null;
            }
        });
    }

    private boolean isValid(TileView tile) {
        boolean valid = false;
        int x = tile.x;
        int y = tile.y;
        int z = tile.z;
        if ((x == 0 && y == 7 && z == 0) || (x == 28 && y == 7 && z == 0) || (x == 13 && y == 7 && z == 4)) { //Links rechts und Mitte Hardcoded
            valid = true;
        } else if ((y == 0 || y == 14) && (tiles[x-2][y][z] == null || tiles[x+2][y][z] == null)) { //Obere und untere Reihe Hardcoded
            valid = true;
        } else if ((tiles[tile.x-2][tile.y][tile.z] == null && tiles[tile.x-2][tile.y+1][tile.z] == null && tiles[tile.x-2][tile.y-1][tile.z] == null) | (tiles[tile.x+2][tile.y][tile.z] == null && tiles[tile.x+2][tile.y+1][tile.z] == null && tiles[tile.x+2][tile.y-1][tile.z] == null) & tiles[tile.x][tile.y][tile.z+1] == null) {
            valid = true;
        }
        if (tile.z == 3 && tiles[13][7][4] != null) {
            valid = false;
        }
        return valid;
    }

    public void countPossibleCombinations() {
        ArrayList<String> validStrings = new ArrayList<>();

        for (Node node : gameBoard.getChildren()) {
            if (node instanceof TileView) {
                if (isValid((TileView) node)) {
                    validStrings.add(((TileView) node).name);
                }
            }
        }

        Map<String, Integer> counts = new HashMap<>();

        for (String tile : validStrings) {
            counts.put(tile, counts.getOrDefault(tile, 0) + 1);
        }

        int totalCombinations = 0;

        for (int n : counts.values()) {
            if (n >= 2) {
                totalCombinations += (n * (n - 1)) / 2;
            }
        }
        if (totalCombinations == 0) {
            generateGame();
        }
        this.text.setText("Combinations left: " + totalCombinations);
    }
}