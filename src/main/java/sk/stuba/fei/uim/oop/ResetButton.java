package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResetButton extends JButton implements ActionListener {
    private int size;
    private GameWindow window;

    public ResetButton(GameWindow window){
        super();
        this.size = 6;
        this.window = window;
        this.setText("RESET");
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MyFrontend board = this.window.getFrontend();
        this.window.remove(this.window.getFrontend());
        this.window.setRules(new GameRules(this.size));
        this.window.setFrontend(new MyFrontend(this.window.getRules()));
        this.window.add(this.window.getFrontend());
        this.window.revalidate();


//        GameRules board = this.game.getBoard();
//        this.game.getWindow().remove(board.getFrontend());
//        this.game.setBoard(new GameRules(this.size));
//        this.game.getWindow().add(this.game.getBoard().getFrontend());
//        this.game.getWindow().revalidate();

    }
}
