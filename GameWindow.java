package Fifteen;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {

    public GameWindow(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        drawWindow();
    }

    public void drawWindow(){
        getContentPane().removeAll();
        JPanel scorePanel = new JPanel();
        JLabel score = new JLabel("Количество ходов: ");
        JLabel scoreInt = new JLabel(Integer.toString(Game.getScore()));

        scorePanel.add(score);
        scorePanel.add(scoreInt);

        JPanel gamePanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.gridy = 0;
        constraints.gridx = 0;
        constraints.anchor = GridBagConstraints.NORTH;
        constraints.insets = new Insets(1, 1, 1, 1);

        Game.updateFrees();
        for(int i = 0; i < Game.getSize(); i++){
            for(int j = 0; j < Game.getSize(); j++){
                constraints.gridx = j;
                constraints.gridy = i;
                gamePanel.add(Game.getCells()[i][j], constraints);
            }
        }

        getContentPane().add(scorePanel, BorderLayout.NORTH);
        getContentPane().add(gamePanel, BorderLayout.SOUTH);
        pack();
        setVisible(true);
    }
}
