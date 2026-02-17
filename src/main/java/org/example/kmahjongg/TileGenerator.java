package org.example.kmahjongg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TileGenerator {
    public static String[][][] generateMap() {
        String[][][] map = new String[30][16][5];
        ArrayList<String> tiles = new ArrayList<>(List.of("1P",
                "2P",
                "3P",
                "4P",
                "5P",
                "6P",
                "7P",
                "8P",
                "9P",
                "1P",
                "2P",
                "3P",
                "4P",
                "5P",
                "6P",
                "7P",
                "8P",
                "9P",
                "1P",
                "2P",
                "3P",
                "4P",
                "5P",
                "6P",
                "7P",
                "8P",
                "9P",
                "1P",
                "2P",
                "3P",
                "4P",
                "5P",
                "6P",
                "7P",
                "8P",
                "9P",
                "1B",
                "2B",
                "3B",
                "4B",
                "5B",
                "6B",
                "7B",
                "8B",
                "9B",
                "1B",
                "2B",
                "3B",
                "4B",
                "5B",
                "6B",
                "7B",
                "8B",
                "9B",
                "1B",
                "2B",
                "3B",
                "4B",
                "5B",
                "6B",
                "7B",
                "8B",
                "9B",
                "1B",
                "2B",
                "3B",
                "4B",
                "5B",
                "6B",
                "7B",
                "8B",
                "9B",
                "1Z",
                "2Z",
                "3Z",
                "4Z",
                "5Z",
                "6Z",
                "7Z",
                "8Z",
                "9Z",
                "1Z",
                "2Z",
                "3Z",
                "4Z",
                "5Z",
                "6Z",
                "7Z",
                "8Z",
                "9Z",
                "1Z",
                "2Z",
                "3Z",
                "4Z",
                "5Z",
                "6Z",
                "7Z",
                "8Z",
                "9Z",
                "1Z",
                "2Z",
                "3Z",
                "4Z",
                "5Z",
                "6Z",
                "7Z",
                "8Z",
                "9Z",
                "W",
                "W",
                "W",
                "W",
                "N",
                "N",
                "N",
                "N",
                "O",
                "O",
                "O",
                "O",
                "S",
                "S",
                "S",
                "S",
                "R",
                "R",
                "R",
                "R",
                "G",
                "G",
                "G",
                "G",
                "WW",
                "WW",
                "WW",
                "WW",
                "J1",
                "J2",
                "J3",
                "J4",
                "F1",
                "F2",
                "F3",
                "F4"));
        Collections.shuffle(tiles);
        for (int i = 2; i != 26;i+=2) {
            map[i][0][0] = tiles.getLast();
            tiles.removeLast();
        }
        for (int i = 6; i != 22;i+=2) {
            map[i][2][0] = tiles.getLast();
            tiles.removeLast();
        }
        for (int i = 4; i != 24;i+=2) {
            map[i][4][0] = tiles.getLast();
            tiles.removeLast();
        }
        for (int i = 2; i != 26;i+=2) {
            map[i][6][0] = tiles.getLast();
            tiles.removeLast();
        }
        for (int i = 2; i != 26;i+=2) {
            map[i][8][0] = tiles.getLast();
            tiles.removeLast();
        }
        for (int i = 4; i != 24;i+=2) {
            map[i][10][0] = tiles.getLast();
            tiles.removeLast();
        }
        for (int i = 6; i != 22;i+=2) {
            map[i][12][0] = tiles.getLast();
            tiles.removeLast();
        }
        for (int i = 2; i != 26;i+=2) {
            map[i][14][0] = tiles.getLast();
            tiles.removeLast();
        }
        map[0][7][0] = tiles.getLast();
        tiles.removeLast();
        map[26][7][0] = tiles.getLast();
        tiles.removeLast();
        map[28][7][0] = tiles.getLast();
        tiles.removeLast();
        for (int i = 8; i != 20;i+=2) {
            map[i][2][1] = tiles.getLast();
            tiles.removeLast();
        }
        for (int i = 8; i != 20;i+=2) {
            map[i][4][1] = tiles.getLast();
            tiles.removeLast();
        }
        for (int i = 8; i != 20;i+=2) {
            map[i][6][1] = tiles.getLast();
            tiles.removeLast();
        }
        for (int i = 8; i != 20;i+=2) {
            map[i][8][1] = tiles.getLast();
            tiles.removeLast();
        }
        for (int i = 8; i != 20;i+=2) {
            map[i][10][1] = tiles.getLast();
            tiles.removeLast();
        }
        for (int i = 8; i != 20;i+=2) {
            map[i][12][1] = tiles.getLast();
            tiles.removeLast();
        }
        for (int i = 10; i != 18;i+=2) {
            map[i][4][2] = tiles.getLast();
            tiles.removeLast();
        }
        for (int i = 10; i != 18;i+=2) {
            map[i][6][2] = tiles.getLast();
            tiles.removeLast();
        }
        for (int i = 10; i != 18;i+=2) {
            map[i][8][2] = tiles.getLast();
            tiles.removeLast();
        }
        for (int i = 10; i != 18;i+=2) {
            map[i][10][2] = tiles.getLast();
            tiles.removeLast();
        }
        for (int i = 12; i != 16;i+=2) {
            map[i][6][3] = tiles.getLast();
            tiles.removeLast();
        }
        for (int i = 12; i != 16;i+=2) {
            map[i][8][3] = tiles.getLast();
            tiles.removeLast();
        }
        map[13][7][4] = tiles.getLast();
        tiles.removeLast();
        return map;
    }
    public TileGenerator() {

    }
}