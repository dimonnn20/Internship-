//package com.games.game2048;
//
//import java.util.Arrays;
//import java.util.Collections;
//
//public class Game2048 {
//
//    private int score = 0;
//    private boolean isGameStopped = false;
//    private boolean isRestartPossible = false;
//    private int[][] gameField = new int[SIDE][SIDE];
//    private static final int SIDE = 4;
//
//    @Override
//    public void initialize() {
//        setScreenSize(SIDE, SIDE);
//        createGame();
//        drawScene();
//    }
//
//    private void createGame() {
//        gameField = new int[SIDE][SIDE];
//        score =0;
//        setScore(score);
//        createNewNumber();
//        createNewNumber();
//    }
//
//    private void drawScene() {
//        for (int i = 0; i < gameField.length; i++) {
//            for (int j = 0; j < gameField[0].length; j++) {
//                setCellColoredNumber(j, i, gameField[i][j]);
//            }
//        }
//    }
//
//    private void createNewNumber() {
//        if (getMaxTileValue() == 2048) {
//            win();
//        } else {
//            int x = getRandomNumber(SIDE);
//            int y = getRandomNumber(SIDE);
//            if (gameField[x][y] == 0) {
//                if (getRandomNumber(10) == 9) {
//                    gameField[x][y] = 4;
//                } else {
//                    gameField[x][y] = 2;
//                }
//            } else {
//                createNewNumber();
//            }
//        }
//    }
//
//    private void setCellColoredNumber(int x, int y, int value) {
//        Color color = getColorByValue(value);
//        if (value == 0) {
//            setCellValueEx(x, y, color, "");
//        } else {
//            setCellValueEx(x, y, color, String.valueOf(value));
//        }
//
//    }
//
//    private Color getColorByValue(int value) {
//        Color color = null;
//        switch (value) {
//            case 0:
//                color = Color.WHITE;
//                break;
//            case 2:
//                color = Color.BLUE;
//                break;
//            case 4:
//                color = Color.YELLOW;
//                break;
//            case 8:
//                color = Color.RED;
//                break;
//            case 16:
//                color = Color.GOLD;
//                break;
//            case 32:
//                color = Color.GREEN;
//                break;
//            case 64:
//                color = Color.GREY;
//                break;
//            case 128:
//                color = Color.PINK;
//                break;
//            case 256:
//                color = Color.ORANGE;
//                break;
//            case 512:
//                color = Color.BROWN;
//                break;
//            case 1024:
//                color = Color.AQUA;
//                break;
//            case 2048:
//                color = Color.BLACK;
//                break;
//        }
//        return color;
//    }
//
//    private boolean compressRow(int[] row) {
//        boolean res = false;
//        boolean cont = true;
//        while (cont) {
//            cont = false;
//            for (int i = 1; i < row.length; i++) {
//                if (row[i] != 0 && row[i - 1] == 0) {
//                    row[i - 1] = row[i];
//                    row[i] = 0;
//                    res = true;
//                    cont = true;
//                }
//            }
//        }
//        return res;
//    }
//
//    private boolean mergeRow(int[] row) {
//        boolean res = false;
//        for (int i = 1; i < row.length; i++) {
//            if (row[i] != 0 && row[i - 1] != 0 && row[i] == row[i - 1]) {
//                row[i - 1] = row[i] + row[i - 1];
//                row[i] = 0;
//                res = true;
//                score = score+ row[i-1];
//                setScore(score);
//            }
//        }
//        return res;
//    }
//
//    @Override
//    public void onKeyPress(Key key) {
//        if (!canUserMove()) {
//            isGameStopped = true;
//        }
//
//        if (!isGameStopped) {
//            if (key == Key.LEFT) {
//                moveLeft();
//            } else if (key == Key.RIGHT) {
//                moveRight();
//            } else if (key == Key.DOWN) {
//                moveDown();
//            } else if (key == Key.UP) {
//                moveUp();
//            }
//            drawScene();
//        } else {
//            if (key == Key.SPACE) {
//                createGame();
//                isGameStopped = false;
//                drawScene();
//            }
//        }
//    }
//
//    private void moveLeft() {
//        boolean isMerge = false;
//        boolean isCompress = false;
//        for (int i = 0; i < gameField.length; i++) {
//            if (compressRow(gameField[i])) isCompress = true;
//            if (mergeRow(gameField[i])) isMerge = true;
//            compressRow(gameField[i]);
//        }
//        if (isMerge || isCompress) {
//            createNewNumber();
//        }
//    }
//
//    private void moveRight() {
//        rotateClockwise();
//        rotateClockwise();
//        moveLeft();
//        rotateClockwise();
//        rotateClockwise();
//    }
//
//    private void moveUp() {
//        rotateClockwise();
//        rotateClockwise();
//        rotateClockwise();
//        moveLeft();
//        rotateClockwise();
//    }
//
//    private void moveDown() {
//        rotateClockwise();
//        moveLeft();
//        rotateClockwise();
//        rotateClockwise();
//        rotateClockwise();
//    }
//
//    private void rotateClockwise() {
//        int[][] copyGameField = new int[SIDE][SIDE];
//        for (int i = 0; i < gameField.length; i++) {
//            for (int j = 0; j < gameField[0].length; j++) {
//                copyGameField[j][SIDE - 1 - i] = gameField[i][j];
//            }
//        }
//        gameField = copyGameField;
//    }
//
//    private int getMaxTileValue() {
//        int max = Integer.MIN_VALUE;
//        for (int i = 0; i < gameField.length; i++) {
//            for (int j = 0; j < gameField[0].length; j++) {
//                if (max < gameField[i][j]) {
//                    max = gameField[i][j];
//                }
//            }
//        }
//        return max;
//    }
//
//    private void win() {
//        showMessageDialog(Color.WHITE, "You Win!", Color.RED, 60);
//        isGameStopped = true;
//    }
//
//    private boolean canUserMove() {
//        if (isGameStopped) {
//            isRestartPossible = true;
//        }
//        for (int i = 0; i < gameField.length; i++) {
//            for (int j = 0; j < gameField[0].length; j++) {
//                if (gameField[i][j] == 0) {
//                    return true;
//                }
//            }
//        }
//        // По горизонтале
//        for (int i = 0; i < gameField.length; i++) {
//            for (int j = 1; j < gameField[0].length; j++) {
//                if (gameField[i][j - 1] == gameField[i][j]) {
//                    return true;
//                }
//            }
//        }
//        // По вертикали
//        for (int i = 1; i < gameField.length; i++) {
//            for (int j = 0; j < gameField[0].length; j++) {
//                if (gameField[i - 1][j] == gameField[i][j]) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//
//    private void gameOver() {
//        isGameStopped = true;
//        showMessageDialog(Color.BLACK, "Game Over", Color.WHITE, 60);
//    }
//}
