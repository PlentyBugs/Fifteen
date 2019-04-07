package Fifteen;

import java.util.ArrayList;

public class Game {
    private static int score = 0;
    private static int size = 4;
    private static Cell[][] cells = new Cell[size][size];
    private static int XFree = size-1;
    private static int YFree = size-1;

    public static void main(String[] args){
        ArrayList<Integer> ran = new ArrayList<>();
        for(int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(i * size + j != size*size-1)
                    ran.add(i * size + j + 1);
            }
        }
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++) {
                if(i * size + j == size*size-1){
                    Cell cell = new Cell(0);
                    cells[i][j] = cell;
                } else {
                    int num = ran.get((int)(Math.random()*ran.size()));
                    ran.remove(ran.indexOf(num));
                    Cell cell = new Cell(num);
                    cells[i][j] = cell;
                }
            }
        }
        Game.updateFrees();
        new Controller().setGameWindow(new GameWindow());
    }

    static int getScore(){
        return score;
    }

    static int getSize() {
        return size;
    }

    static Cell[][] getCells() {
        return cells;
    }

    static void updateFrees(){
        boolean win = true;
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++) {
                if(i * size + j == 15){
                    continue;
                }
                if(cells[i][j].getNumber() != i * size + j + 1){
                    win = false;
                }
            }
        }
        if(win)
            new WinWindow();
    }

    private static void win(){
        new WinWindow();
    }

    static void addScore(int scoreAdd){
        score += scoreAdd;
    }

    public static int getXFree() {
        return XFree;
    }

    public static int getYFree() {
        return YFree;
    }

    public static void setXFree(int XFree) {
        Game.XFree = XFree;
    }

    public static void setYFree(int YFree) {
        Game.YFree = YFree;
    }
}
