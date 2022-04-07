package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    private GameMenu menu;
    private GameBoard board;

    public GameWindow(){
        super();
        this.setSize(600,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.getContentPane().setBackground(Color.white);
        this.setLayout(new BorderLayout());

//        this.board = new GameBoard();
//        this.add(this.board, BorderLayout.CENTER);
    }

}
