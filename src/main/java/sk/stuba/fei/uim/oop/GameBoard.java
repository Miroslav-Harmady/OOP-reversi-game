package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class GameBoard extends JPanel implements MouseMotionListener {
    private int size;
    private TileDataa[][] dataArr;
    private int[][] directions;

    public GameBoard(int size) {
        super();
        this.setPreferredSize(new Dimension(480, 480));
        this.setSize(size);
        this.dataArr = new TileDataa[this.size][this.size];
        this.directions = new int[][]{{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
        this.setLayout(new GridLayout(this.size, this.size));

        for (int row = 0; row < this.size; row++) {
            for (int col = 0; col < this.size; col++) {
                this.dataArr[row][col] = new TileDataa("EMPTY", Color.green);
            }
            this.dataArr[this.size / 2 - 1][this.size / 2 - 1] = new TileDataa("PLAYER", Color.white);
            this.dataArr[this.size / 2 - 1][this.size / 2] = new TileDataa("PC", Color.black);
            this.dataArr[this.size / 2][this.size / 2 - 1] = new TileDataa("PC", Color.black);
            this.dataArr[this.size / 2][this.size / 2] = new TileDataa("PLAYER", Color.white);
        }

        for (int row = 0; row < this.size; row++) {
            for (int col = 0; col < this.size; col++) {
                this.setIfTilePlayable(new int[]{row, col}, "PC", "PLAYER");
            }
        }

        for (int row = 0; row < (this.size); row++) {
            for (int col = 0; col < this.size; col++) {
                Tile tile = new Tile(this.size, this.dataArr,
                        this.dataArr[row][col].getColor(), this.dataArr[row][col].isPlayableByPlayer());
                this.add(tile);
            }
        }

        //this.addMouseMotionListener(this);
    }

    public void putStone(){
        //
    }

    public void setIfTilePlayable(int[] coords, String opponent, String onMove) {
        for (int direction = 0; direction < this.directions.length; direction++) {
            boolean flag = this.playableInDirection(coords, this.directions[direction], opponent, onMove);
            if (!flag) {
                continue;
            }
            if (opponent.equals("PC")) {
                this.dataArr[coords[0]][coords[1]].setPlayableByPlayer(true);
            } else {
                this.dataArr[coords[0]][coords[1]].setPlayableByPC(true);
            }
        }
    }

    public boolean playableInDirection(int[] coords, int[] dir, String opponent, String onMove) {
        int counter = 0;
        int[] searchCoords = new int[2];
        searchCoords[0] = coords[0];
        searchCoords[1] = coords[1];

        while (true) {
            searchCoords[0] += dir[0];
            searchCoords[1] += dir[1];
            if (searchCoords[0] < 0 || searchCoords[1] < 0 || searchCoords[0] > (this.size - 1) || searchCoords[1] > (this.size - 1)
                    || this.dataArr[searchCoords[0]][searchCoords[1]].getOwner().equals("EMPTY") ||
                    (this.dataArr[searchCoords[0]][searchCoords[1]].getOwner().equals(onMove) && counter == 0)) {
                return false;
            }
            if (this.dataArr[searchCoords[0]][searchCoords[1]].getOwner().equals(opponent)) {
                counter++;
            }
            if (counter >= 1 && dataArr[searchCoords[0]][searchCoords[1]].getOwner().equals(onMove)) {
                return true;
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
        int x = this.getComponentAt(e.getX(), e.getY()).getX();
        int y = this.getComponentAt(e.getX(), e.getY()).getY();
        if (this.dataArr[x / (480 / this.size)][y / (480 / this.size)].isPlayableByPlayer()) {
            System.out.println(("HRATELNE HRACOM HURAAAA"));
            //takto viem pristupit k datam kazdeho tile ale treba upravit delenie. Zatial len pre 6x6
        }

    }
}
