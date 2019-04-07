package Fifteen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.util.Timer;
import java.util.TimerTask;

public class WinWindow extends JFrame {

    public WinWindow() {
        super("Победа");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setUndecorated(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setAlwaysOnTop(true);

        JLabel label = new JLabel("Победа");
        label.setFont(new Font("Default", Font.BOLD, 150));

        getContentPane().add(label);
        pack();
        setVisible(true);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                close();
            }
        }, 5*1000);
    }

    public void close(){
        dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }
}
