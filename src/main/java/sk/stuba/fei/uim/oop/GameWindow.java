package sk.stuba.fei.uim.oop;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class GameWindow extends JFrame implements KeyListener {

    @Getter
    @Setter
    private GameMenu menu;
    @Getter
    @Setter
    private GameRules rules;
    @Getter
    @Setter
    private MyFrontend frontend;
    @Getter
    private JPanel infoPanel; //

    public GameWindow(){
        super();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.getContentPane().setBackground(Color.white);
        this.setLayout(new BorderLayout());

        this.infoPanel = new JPanel();
        this.setInfoPanel();
        this.add(this.infoPanel, BorderLayout.PAGE_END);

        this.rules = new GameRules(6);

        this.frontend = new MyFrontend(this.rules, this);
        this.add(this.frontend, BorderLayout.CENTER);

        this.menu = new GameMenu(this);
        this.add(this.menu, BorderLayout.PAGE_START);

        this.pack();
        this.setResizable(false);
        this.addKeyListener(this);
        this.setFocusable(true);
        this.setVisible(true);
        
    }

    public void gameRestart(){
        this.remove(this.getFrontend());
        this.setRules(new GameRules(this.getMenu().getResetButton().getResetSize()));//getResizeSlider().getValue())
        this.setFrontend(new MyFrontend(this.getRules(), this));
        this.add(this.getFrontend());
        //
        this.remove(this.getInfoPanel());
        this.infoPanel = new JPanel();
        this.setInfoPanel();
        this.add(this.infoPanel, BorderLayout.PAGE_END);
        this.revalidate();
    }

    private void setInfoPanel() {
        this.infoPanel.setLayout(new GridLayout(1,2));
        this.infoPanel.add(new JLabel(("on move: PLAYER")));
        this.infoPanel.add(new JLabel(("WINNER: ")));
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == 27){
            this.dispose();
            System.exit(0);
        }
        if (code == 82){
            this.gameRestart();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
