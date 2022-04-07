package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResetButton extends JButton implements ActionListener {
    private int size;
    private JFrame window;

    public ResetButton(JFrame window){
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
        this.window.remove(this.window.getContentPane().getComponent(1));
        ((GameMenu) this.window.getContentPane().getComponent(0)).getSizeInfo().setText(this.size + "x" + this.size);
        GameBoard board = new GameBoard(this.size);
        this.window.add(board, BorderLayout.CENTER);
    }
}
