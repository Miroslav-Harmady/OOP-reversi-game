package sk.stuba.fei.uim.oop;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;


public class GameWindow extends JFrame {

    @Getter
    @Setter
    private GameMenu menu;
    @Getter
    @Setter
    private GameRules rules;
    @Getter
    @Setter
    private MyFrontend frontend;

    public GameWindow(){
        super();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.getContentPane().setBackground(Color.white);
        this.setLayout(new BorderLayout());

        this.rules = new GameRules(6);

        this.frontend = new MyFrontend(this.rules);
        this.add(this.frontend, BorderLayout.CENTER);

        this.menu = new GameMenu(this);
        this.add(this.menu, BorderLayout.PAGE_START);


        this.pack();
        this.setResizable(false);
        this.setVisible(true);
        
    }

}
