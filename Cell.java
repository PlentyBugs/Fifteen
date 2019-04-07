package Fifteen;

import javax.swing.*;
import java.awt.*;

public class Cell extends JButton {
    private int number;

    public Cell(int number){
        this.number = number;
        setEnabled(false);
        if(number != 0){
            setText(Integer.toString(number));
            setBackground(new Color(237,255, 104));
        }
        cellSize(100, 100);
    }

    public int getNumber() {
        return number;
    }

    public void cellSize(int width, int height){
        setPreferredSize(new Dimension(width, height));
        setMaximumSize(new Dimension(width, height));
        setMinimumSize(new Dimension(width, height));
    }
}
