package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;

public class GameBoard extends JPanel {

    public GameBoard(){
        super();
        int size = 6;
        this.setLayout(new GridLayout(size,size,6,6));
        for (int index = 0; index < (size * size); index++) {
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
}
