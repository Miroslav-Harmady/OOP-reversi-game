package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Tile extends JPanel implements MouseListener {
    private int size;
    private TileDataa[][] board;
    private Color fill;


    public Tile(int numOfTiles, TileDataa[][] boardData, Color color, boolean highlighted){
        super();
        this.board = boardData;
        this.fill = color;
        this.setSize(480/numOfTiles);
        if (highlighted){
            this.setBorder(BorderFactory.createLineBorder(Color.red,3));
            //this.addMouseListener(this);
        } else{
            this.setBorder(BorderFactory.createLineBorder(Color.black));
        }

        this.setBackground(Color.green);


    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(this.fill);
        g.fillOval(this.size/10,this.size/10,this.size*8/10,this.size*8/10);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.setBorder(BorderFactory.createLineBorder(Color.blue,3));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.setBorder(BorderFactory.createLineBorder(Color.red,3));
    }
}
