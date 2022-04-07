package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;

public class GameBoard extends JPanel {
    private int size;

    public GameBoard(int size){
        super();
        this.setSize(size);
        this.setLayout(new GridLayout(this.size,this.size,6,6));
        for (int index = 0; index < (this.size * this.size); index++) {
            Tile tile = new Tile();
            tile.setBackground(Color.green);
            tile.setBorder(BorderFactory.createLineBorder(Color.black));
            this.add(tile);
        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }


    public int getBoardSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
