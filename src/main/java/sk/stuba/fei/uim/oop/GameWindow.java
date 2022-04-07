package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    private GameMenu menu;
    private GameBoard board;

    public GameWindow(){
        super();
        this.setSize(500,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.getContentPane().setBackground(Color.white);
        this.setLayout(new BorderLayout());

        this.menu = new GameMenu();
        this.add(this.menu, BorderLayout.PAGE_START);

        this.board = new GameBoard();
        this.add(this.board, BorderLayout.CENTER);
    }
}
