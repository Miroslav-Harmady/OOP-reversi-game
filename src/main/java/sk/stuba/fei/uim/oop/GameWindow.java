package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    private GameMenu menu;
    private GameBoard board;
    private GameWindow window;

    public GameWindow(){
        super();
        this.setSize(800,800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.getContentPane().setBackground(Color.white);
        this.setLayout(new BorderLayout());

        this.menu = new GameMenu();

        this.add(this.menu,BorderLayout.PAGE_START);
    }
}
