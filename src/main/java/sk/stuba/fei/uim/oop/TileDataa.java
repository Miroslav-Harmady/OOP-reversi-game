package sk.stuba.fei.uim.oop;

import java.awt.*;

public class TileDataa {

    private final String owner;
    private boolean playableByPlayer;
    private boolean playableByPC;
    private final Color color;

    TileDataa (String owner, Color fill){
        this.owner = owner;
        this.playableByPlayer = false;
        this.playableByPC = false;
        this.color = fill;
    }

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

    public String getOwner() {
        return owner;
    }
}
