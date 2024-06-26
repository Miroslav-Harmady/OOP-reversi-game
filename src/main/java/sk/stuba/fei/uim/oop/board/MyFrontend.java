package sk.stuba.fei.uim.oop.board;

import sk.stuba.fei.uim.oop.logic.GameRules;
import sk.stuba.fei.uim.oop.GameWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class MyFrontend extends JPanel implements MouseListener {
    private GameRules rules;
    private GameWindow frame;

    public MyFrontend(GameRules rules, GameWindow frame) {
        super();
        this.rules = rules;
        this.frame = frame;
        this.setPreferredSize(new Dimension(480, 480));
        this.setLayout(new GridLayout(this.rules.getBoardSize(), this.rules.getBoardSize()));

        for (int row = 0; row < (this.rules.getBoardSize()); row++) {
            for (int col = 0; col < this.rules.getBoardSize(); col++) {
                Tile tile = new Tile(this.rules, this.rules.getDataArr()[row][col].getColor(),
                        this.rules.getDataArr()[row][col].isPlayableByPlayer());
                tile.setFocusable(false);
                this.add(tile);
            }
        }
        this.setFocusable(true);
        this.addMouseListener(this);
    }

    private void setWinner(String winner, int score){
         JLabel info = (JLabel) this.frame.getInfoPanel().getComponent(1);
         info.setText("WINNER: " + winner + " with " + score + " stones");
    }

    private void repaintBoard(){
        this.removeAll();
        for (int row = 0; row < this.rules.getBoardSize(); row++) {
            for (int col = 0; col < this.rules.getBoardSize(); col++) {
                Tile tile = new Tile(this.rules, this.rules.getDataArr()[row][col].getColor(),
                        this.rules.getDataArr()[row][col].isPlayableByPlayer());
                this.add(tile);
            }
        }
        this.revalidate();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int col = this.getComponentAt(e.getX(), e.getY()).getX() / (this.getPreferredSize().width / this.rules.getBoardSize());
        int row = this.getComponentAt(e.getX(), e.getY()).getY() / (this.getPreferredSize().width / this.rules.getBoardSize());

        if (this.rules.getDataArr()[row][col].isPlayableByPlayer()) {
            this.rules.putStone(new int[]{row, col}, "PC", "PLAYER");

            this.rules.validateTiles("PLAYER", "PC");
            ArrayList<int[]> options =  this.rules.getAIOptions();

            if(options.size() > 0){
                do{
                    int choice = (int) (Math.random() * options.size());
                    int y = options.get(choice)[0];
                    int x = options.get(choice)[1];

                    this.rules.putStone(new int[] {y, x}, "PLAYER", "PC");

                    this.rules.validateTiles("PC", "PLAYER");
                    this.rules.validateTiles("PLAYER", "PC");
                    options =  this.rules.getAIOptions();
                }while (!this.rules.canPlayerMakeMove() && options.size() > 0);
            }
            this.repaintBoard();
            this.revalidate();
            if (!this.rules.canPlayerMakeMove() && options.size() == 0){
                int score;
                String winner = this.rules.getWinner();
                if(winner.equals("DRAW")){
                    score = this.rules.countScore("PLAYER");
                }
                else{
                    score = this.rules.countScore(winner);
                }
                this.setWinner(winner, score);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


}

