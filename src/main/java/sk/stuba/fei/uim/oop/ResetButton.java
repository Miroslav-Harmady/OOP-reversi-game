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
        this.setFocusable(false);
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getResetSize() {
        return size;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.window.gameRestart();

    }
}
