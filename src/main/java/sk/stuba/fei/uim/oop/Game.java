package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;

public class Game {
    JFrame window;


    public Game(){
        this.prepare();
    }

    private void prepare(){
        this.window = new JFrame();
        this.window.setSize(600,600);
        this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.window.setVisible(true);
        this.window.getContentPane().setBackground(Color.white);
        this.window.setLayout(new BorderLayout());

        GameMenu menu = new GameMenu(this.window);
        this.window.add(menu, BorderLayout.PAGE_START);

        GameBoard board = new GameBoard(6);
        this.window.add(board, BorderLayout.CENTER);
    }

}
