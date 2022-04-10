package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Tile extends JPanel implements MouseListener {
    private int size;
    private TileData[][] board;
    private Color fill;

    public Tile(int numOfTiles, TileData[][] boardData, Color color){
        super();
        this.board = boardData;
        this.fill = color;
        this.setSize(300/numOfTiles);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setBackground(Color.green);
        this.addMouseListener(this);

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
        int col = this.getComponentAt(e.getX(),e.getY()).getX();
        int row = this.getComponentAt(e.getX(),e.getY()).getY();
        //System.out.print(this.board[row/this.size][col/this.size]);

        System.out.println((row/this.size + " " + col/this.size));
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
