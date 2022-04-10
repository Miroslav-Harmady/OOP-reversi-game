package sk.stuba.fei.uim.oop;

import java.awt.*;

public enum TileData {
    PLAYER("PLAYER", Color.white),
    PC("PC", Color.black),
    EMPTY("EMPTY", Color.green);

    private String owner;
    private boolean playableByPlayer;
    private boolean playableByPC;
    private Color color;

    TileData(String owner, Color fill){
        this.owner = owner;
        this.playableByPlayer = false;
        this.playableByPC = false;
        this.color = fill;
    }

    public String getOwner() {
        return owner;
    }

//    public void setOwner(String owner) {
//        this.owner = owner;
//    }

    public boolean isPlayableByPlayer() {
        return playableByPlayer;
    }

    public void setPlayableByPlayer(boolean playableByPlayer) {
        this.playableByPlayer = playableByPlayer;
    }

    public boolean isPlayableByPC() {
        return playableByPC;
    }

    public void setPlayableByPC(boolean playableByPC) {
        this.playableByPC = playableByPC;
    }

    public Color getColor() {
        return color;
    }
}
