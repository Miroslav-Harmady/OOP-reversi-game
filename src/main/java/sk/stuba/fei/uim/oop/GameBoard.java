package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class GameBoard extends JPanel implements MouseMotionListener {
    private int size;
    private TileData[][] dataArr;

    public GameBoard(int size){
        super();
        this.setPreferredSize(new Dimension(300, 300));
        this.setSize(size);
        this.dataArr = new TileData[this.size][this.size];
        this.setLayout(new GridLayout(this.size,this.size));

        for (int row = 0; row < this.size; row++) {
            for (int col = 0; col < this.size; col++) {
                this.dataArr[row][col] = TileData.EMPTY;
            }
            this.dataArr[this.size/2 - 1][this.size/2 -1] = TileData.PLAYER;
            this.dataArr[this.size/2 - 1][this.size/2] = TileData.PC;
            this.dataArr[this.size/2][this.size/2 - 1] = TileData.PC;
            this.dataArr[this.size/2][this.size/2] = TileData.PLAYER;
        }

        for (int row = 0; row < (this.size); row++) {
            for (int col = 0; col < this.size; col++) {
                Tile tile = new Tile(this.size, this.dataArr, this.dataArr[row][col].getColor());
                this.add(tile);
            }
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

//    public TileData[][] getDataArr() {
//        return dataArr;
//    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
//        int x = this.getComponentAt(e.getX(),e.getY()).getX();
//        int y = this.getComponentAt(e.getX(),e.getY()).getY();
        //System.out.println((this.dataArr[x/50][y/50]));
        //takto viem pristupit k datam kazdeho tile ale treba upravit delenie.
    }
}
