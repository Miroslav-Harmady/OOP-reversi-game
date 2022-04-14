package sk.stuba.fei.uim.oop.logic;

import java.awt.*;
import java.util.ArrayList;

public class GameRules {
    private int size;
    private TileDataa[][] dataArr;
    private int[][] directions;

    public GameRules(int size) {
        super();
        this.setSize(size);
        this.dataArr = new TileDataa[this.size][this.size];
        this.directions = new int[][]{{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};

        for (int row = 0; row < this.size; row++) {
            for (int col = 0; col < this.size; col++) {
                this.dataArr[row][col] = new TileDataa("EMPTY", Color.green);
            }
        }
        this.dataArr[this.size / 2 - 1][this.size / 2 - 1] = new TileDataa("PLAYER", Color.white);
        this.dataArr[this.size / 2 - 1][this.size / 2] = new TileDataa("PC", Color.black);
        this.dataArr[this.size / 2][this.size / 2 - 1] = new TileDataa("PC", Color.black);
        this.dataArr[this.size / 2][this.size / 2] = new TileDataa("PLAYER", Color.white);

        //hned na uvod kontrolujem ktore policka moze hrac obsadit
       this.validateTiles("PC", "PLAYER");
    }

    public int countScore(String owner){
        int score = 0;
        for (int row = 0; row < this.size; row++) {
            for (int col = 0; col < this.size; col++) {
                if (this.dataArr[row][col].getOwner().equals(owner)){
                    score++;
                }
            }
        }
        return score;
    }

    public String getWinner(){
        int playerPoints = 0;
        for (int row = 0; row < this.size; row++) {
            for (int col = 0; col < this.size; col++) {
                if (this.dataArr[row][col].getOwner().equals("PLAYER")){
                    playerPoints++;
                }
                else
                    playerPoints--;
            }
        }
        if (playerPoints > 0){
            return "PLAYER";
        }
        else
            return "PC";
    }

    public ArrayList<int[]> getAIOptions(){
        ArrayList<int[]> options = new ArrayList<>();
        for (int row = 0; row < this.size; row++) {
            for (int col = 0; col < this.size; col++) {
                if (dataArr[row][col].isPlayableByPC()){
                    options.add(new int[]{row, col});
                }
            }
        }
        return options;
    }

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

    public boolean canPlayerMakeMove(){
        for (int row = 0; row < this.size; row++) {
            for (int col = 0; col < this.size; col++) {
                if (this.dataArr[row][col].isPlayableByPlayer()){
                    return true;
                }
            }
        }
        return false;
    }

    private void encircleEnemy(int[] coords, int[] dir, String onMove) {
        Color stoneColor;
        if (onMove.equals("PLAYER")) {
            stoneColor = Color.white;
        } else {
            stoneColor = Color.black;
        }
        this.dataArr[coords[0]][coords[1]] = new TileDataa(onMove, stoneColor);
        int[] searchCoords = new int[2];
        searchCoords[0] = coords[0];
        searchCoords[1] = coords[1];
        searchCoords[0] += dir[0];
        searchCoords[1] += dir[1];

        while (!this.dataArr[searchCoords[0]][searchCoords[1]].getOwner().equals(onMove)){
            this.dataArr[searchCoords[0]][searchCoords[1]] = new TileDataa(onMove, stoneColor);
            searchCoords[0] += dir[0];
            searchCoords[1] += dir[1];
        }
    }

    public void validateTiles(String opponent, String onMove){
        for (int row = 0; row < this.size; row++) {
            for (int col = 0; col < this.size; col++) {
                this.setIfTilePlayable(new int[]{row, col}, opponent, onMove);

            }
        }
    }

    private void setIfTilePlayable(int[] coords, String opponent, String onMove) {
        if(!this.dataArr[coords[0]][coords[1]].getOwner().equals("EMPTY")){
            return;
        }
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

    private boolean playableInDirection(int[] coords, int[] dir, String opponent, String onMove) {
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
}
