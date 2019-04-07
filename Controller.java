package Fifteen;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller implements KeyListener {

    private GameWindow gameWindow;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A){
            moveToRight();
        } else if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D){
            moveToLeft();
        } else if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W){
            moveToBot();
        } else if(e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S){
            moveToTop();
        }
        gameWindow.drawWindow();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void setGameWindow(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        gameWindow.addKeyListener(this);
    }

    private void moveToLeft(){
        int x = Game.getXFree();
        int y = Game.getYFree();

        if(x-1 >= 0){
            Game.addScore(1);
            Game.getCells()[y][x] = new Cell(Game.getCells()[y][x-1].getNumber());
            Game.getCells()[y][x - 1] = new Cell(0);
            Game.setXFree(x-1);
        }
    }

    private void moveToRight(){
        int x = Game.getXFree();
        int y = Game.getYFree();

        if(x+1 < Game.getSize()){
            Game.addScore(1);
            Game.getCells()[y][x] = new Cell(Game.getCells()[y][x+1].getNumber());
            Game.getCells()[y][x + 1] = new Cell(0);
            Game.setXFree(x+1);
        }
    }

    private void moveToTop(){
        int x = Game.getXFree();
        int y = Game.getYFree();

        if(y-1 >= 0){
            Game.addScore(1);
            Game.getCells()[y][x] = new Cell(Game.getCells()[y-1][x].getNumber());
            Game.getCells()[y - 1][x] = new Cell(0);
            Game.setYFree(y-1);
        }
    }

    private void moveToBot(){
        int x = Game.getXFree();
        int y = Game.getYFree();

        if(y+1 < Game.getSize()){
            Game.addScore(1);
            Game.getCells()[y][x] = new Cell(Game.getCells()[y+1][x].getNumber());
            Game.getCells()[y + 1][x] = new Cell(0);
            Game.setYFree(y+1);
        }
    }
}
