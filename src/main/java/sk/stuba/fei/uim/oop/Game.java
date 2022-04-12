package sk.stuba.fei.uim.oop;

import lombok.Data;

import javax.swing.*;
import java.awt.*;

@Data
public class Game {
    private JFrame window;
    private GameRules board;


    public Game(){
        this.prepare();
    }

    private void prepare(){
        this.window = new JFrame();
        this.window.setSize(600,600);
        this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.window.getContentPane().setBackground(Color.white);
        this.window.setLayout(new BorderLayout());

        this.board = new GameRules(6);

        //GameMenu menu = new GameMenu(this);
        //this.window.add(menu, BorderLayout.PAGE_START);

        //this.window.add(board.getFrontend());
        //this.window.add(board, BorderLayout.CENTER);
        this.window.pack();
        this.window.setResizable(false);

        this.window.setVisible(true);
    }

}
