package sk.stuba.fei.uim.oop;

public class Game {
    GameWindow window;


    public Game(){
        this.prepare();
    }
    private void prepare(){
        this.window = new GameWindow();
    }
}
