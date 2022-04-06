package sk.stuba.fei.uim.oop;

import javax.swing.*;

public class GameWindow extends JFrame {
    private GameMenu menu;
    private GameBoard board;
    private GameWindow window;

    public GameWindow(){
        super();
        this.setSize(400,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
