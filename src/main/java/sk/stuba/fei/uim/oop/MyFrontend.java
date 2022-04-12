package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class MyFrontend extends JPanel implements MouseListener {
    private GameRules rules;


    public MyFrontend(GameRules rules) {
        super();
        this.rules = rules;
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

    public void repaintBoard(){ //mozno aj private pouvazuj ;)
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
        //-----------------full tah hraca------------------
        int col = this.getComponentAt(e.getX(), e.getY()).getX() / (this.getPreferredSize().width / this.rules.getBoardSize());
        int row = this.getComponentAt(e.getX(), e.getY()).getY() / (this.getPreferredSize().width / this.rules.getBoardSize());

        if (!this.rules.getDataArr()[row][col].isPlayableByPlayer()) {
            System.out.println("TAM NIE");
        } else {
            this.rules.putStone(new int[]{row, col}, "PC", "PLAYER");
            System.out.println("TREFA");
            //--------------inicializacia hratelnych policok pre AI
            for (int i = 0; i < this.rules.getBoardSize(); i++) {
                for (int j = 0; j < this.rules.getBoardSize(); j++) {
                    this.rules.setIfTilePlayable(new int[]{i, j}, "PLAYER", "PC");
                }
            }
            //-------------- tu niekde zacina AI----------------
            //----------zisk a vypis moznosti-----------
            ArrayList<int[]> options =  this.rules.getAIOptions();
            for (int opt = 0; opt < options.size(); opt++) {
                System.out.println(options.get(opt)[0] + ", " + options.get(opt)[1]);
            }

            if(options.size() > 0){
                do{
                    int choice = (int) (Math.random() * options.size());
                    int y = options.get(choice)[0];
                    int x = options.get(choice)[1];
                    System.out.println("AI chose coords {" + y + ", " + x + "}");
                    //---------AI putne stone-----------
                    this.rules.putStone(new int[] {y, x}, "PLAYER", "PC");
                    //------- validujem policka pre seba------
                    for (int i = 0; i < this.rules.getBoardSize(); i++) {
                        for (int j = 0; j < this.rules.getBoardSize(); j++) {
                            this.rules.setIfTilePlayable(new int[]{i, j}, "PC", "PLAYER");
                        }
                    }
                    //--------------inicializacia hratelnych policok pre AI
                    for (int i = 0; i < this.rules.getBoardSize(); i++) {
                        for (int j = 0; j < this.rules.getBoardSize(); j++) {
                            this.rules.setIfTilePlayable(new int[]{i, j}, "PLAYER", "PC");
                        }
                    }
                    options =  this.rules.getAIOptions();
                }while (!this.rules.canPlayerMakeMove() && options.size() > 0);
            }
            //-------repaint-------
            this.repaintBoard();
            this.revalidate();
            if (!this.rules.canPlayerMakeMove() && options.size() == 0){
                System.out.println("HRA SKONCILA");
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

