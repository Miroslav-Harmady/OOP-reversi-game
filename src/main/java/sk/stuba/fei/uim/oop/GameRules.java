package sk.stuba.fei.uim.oop;

import lombok.Data;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class GameRules {
    private int size;
    private TileDataa[][] dataArr;
    private int[][] directions;
    //--------------------------------

    //private JPanel frontend;

    public GameRules(int size) {
        super();
        //this.setPreferredSize(new Dimension(480, 480));
        this.setSize(size);
        this.dataArr = new TileDataa[this.size][this.size];
        this.directions = new int[][]{{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
        //--------------------------------------------------------------------
//        this.frontend = new JPanel();
//        this.frontend.setPreferredSize(new Dimension(480,480));
//        this.frontend.setLayout(new GridLayout(this.size, this.size));
        //this.add(this.frontend);
        //--------------------------------------------------------------------

        //uvodna inicializacia dat tak aby som mal hned aj prve kamene
        for (int row = 0; row < this.size; row++) {
            for (int col = 0; col < this.size; col++) {
                this.dataArr[row][col] = new TileDataa("EMPTY", Color.green);
            }
            this.dataArr[this.size / 2 - 1][this.size / 2 - 1] = new TileDataa("PLAYER", Color.white);
            this.dataArr[this.size / 2 - 1][this.size / 2] = new TileDataa("PC", Color.black);
            this.dataArr[this.size / 2][this.size / 2 - 1] = new TileDataa("PC", Color.black);
            this.dataArr[this.size / 2][this.size / 2] = new TileDataa("PLAYER", Color.white);
        }

        //hned na uvod kontrolujem ktore policka moze hrac obsadit
        for (int row = 0; row < this.size; row++) {
            for (int col = 0; col < this.size; col++) {
                this.setIfTilePlayable(new int[]{row, col}, "PC", "PLAYER");
            }
        }

        //podla dat vytvaram pole a pridavam policka do frontendu
//        for (int row = 0; row < (this.size); row++) {
//            for (int col = 0; col < this.size; col++) {
//                Tile tile = new Tile(this.size, this.dataArr,
//                        this.dataArr[row][col].getColor(), this.dataArr[row][col].isPlayableByPlayer());
//                this.frontend.add(tile);
//            }
//        }

        //this.addMouseMotionListener(this);
//        this.putStone(new int []{1,3}, "PC", "PLAYER");
//        for (int row = 0; row < this.size; row++) {
//            for (int col = 0; col < this.size; col++) {
//                this.setIfTilePlayable(new int[]{row, col}, "PC", "PLAYER");
//            }
//        }

        //this.addMouseListener(this);
    }


//    public void repaintBoard(){
//        this.frontend.removeAll();
//
//        for (int row = 0; row < this.size; row++) {
//            for (int col = 0; col < this.size; col++) {
//                Tile tile = new Tile(this.size, this.dataArr,
//                        this.dataArr[row][col].getColor(), this.dataArr[row][col].isPlayableByPlayer());
//                this.frontend.add(tile);
//            }
//        }
//        //revalidate
//    }

    public void putStone(int[] coords, String opponent, String onMove) {
        for (int direction = 0; direction < this.directions.length; direction++) {
            boolean flag = this.playableInDirection(coords, this.directions[direction], opponent, onMove);
            if (!flag) {
                continue;
            } else {
                encircleEnemy(coords, this.directions[direction], onMove);
            }
        }
    }

    public void encircleEnemy(int[] coords, int[] dir, String onMove) {
        // bud namiesto oponenta bude farba alebo si ju zatial nastavim priamo vo vnutri cez if
        Color stoneColor;
        if (onMove.equals("PLAYER")) {
            stoneColor = Color.white;
        } else {
            stoneColor = Color.black;
        }
        this.dataArr[coords[0]][coords[1]] = new TileDataa(onMove, stoneColor);
        System.out.println("obsadzujem kamen na suradnici " + coords[0] + ", " + coords[1]);

        int[] searchCoords = new int[2];
        searchCoords[0] = coords[0];
        searchCoords[1] = coords[1];
        searchCoords[0] += dir[0];
        searchCoords[1] += dir[1];

        while (!this.dataArr[searchCoords[0]][searchCoords[1]].getOwner().equals(onMove)){
            this.dataArr[searchCoords[0]][searchCoords[1]] = new TileDataa(onMove, stoneColor);
            System.out.println("obsadzujem kamen na suradnici " + searchCoords[0] + ", " + searchCoords[1]);
            searchCoords[0] += dir[0];
            searchCoords[1] += dir[1];
        }
    }

    public void setIfTilePlayable(int[] coords, String opponent, String onMove) {
        for (int direction = 0; direction < this.directions.length; direction++) {
            boolean flag = this.playableInDirection(coords, this.directions[direction], opponent, onMove);
            if ((direction == 7) && !flag){
                if(onMove.equals("PLAYER")){
                    this.dataArr[coords[0]][coords[1]].setPlayableByPlayer(false);
                }
                else{
                    this.dataArr[coords[0]][coords[1]].setPlayableByPC(false);
                }
                return;
            }
            if (!flag) {
                continue;
            }
            if (opponent.equals("PC")) {
                this.dataArr[coords[0]][coords[1]].setPlayableByPlayer(true);
                return;
            } else {
                this.dataArr[coords[0]][coords[1]].setPlayableByPC(true);
                return;
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

    public int getBoardSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public TileDataa[][] getDataArr() {
        return this.dataArr;
    }

    public int[][] getDirections() {
        return directions;
    }
}
