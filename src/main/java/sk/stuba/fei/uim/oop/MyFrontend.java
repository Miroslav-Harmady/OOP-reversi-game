package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyFrontend extends JPanel implements MouseListener {
    private GameRules rules;


    public MyFrontend(GameRules rules) {
        super();
        this.rules = rules;
        this.setPreferredSize(new Dimension(480, 480));
        this.setLayout(new GridLayout(this.rules.getBoardSize(), this.rules.getBoardSize()));

        for (int row = 0; row < (this.rules.getBoardSize()); row++) {
            for (int col = 0; col < this.rules.getBoardSize(); col++) {
                Tile tile = new Tile(this.rules.getBoardSize(), this.rules.getDataArr(),
                        this.rules.getDataArr()[row][col].getColor(), this.rules.getDataArr()[row][col].isPlayableByPlayer());
                this.add(tile);
            }
        }
        this.addMouseListener(this);
    }

    public void repaintBoard(){ //mozno aj private pouvazuj ;)
        this.removeAll();
        for (int row = 0; row < this.rules.getBoardSize(); row++) {
            for (int col = 0; col < this.rules.getBoardSize(); col++) {
                Tile tile = new Tile(this.rules.getBoardSize(), this.rules.getDataArr(),
                        this.rules.getDataArr()[row][col].getColor(), this.rules.getDataArr()[row][col].isPlayableByPlayer());
                this.add(tile);
            }
        }
        this.revalidate();
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        int col = this.getComponentAt(e.getX(), e.getY()).getX() / (this.getPreferredSize().width / this.rules.getBoardSize());
        int row = this.getComponentAt(e.getX(), e.getY()).getY() / (this.getPreferredSize().width / this.rules.getBoardSize());
        System.out.println(row + ", " + col);
//        if (!this.dataArr[row][col].isPlayableByPlayer()) {
//            System.out.println("TAM NIE");
//        } else {
//            this.putStone(new int[]{row, col}, "PC", "PLAYER");
//            System.out.println("TREFA");
//            //--------------------------------------
//            for (int i = 0; i < this.size; i++) {
//                for (int j = 0; j < this.size; j++) {
//                    this.setIfTilePlayable(new int[]{i, j}, "PC", "PLAYER");
//                }
//            }
//            //--------------------------------------
//            //this.repaintBoard();
//            this.revalidate();

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


//    @Override
//    public void mouseMoved(MouseEvent e) {
////        int x = this.getComponentAt(e.getX(), e.getY()).getX();
////        int y = this.getComponentAt(e.getX(), e.getY()).getY();
////        if (this.dataArr[x / (480 / this.size)][y / (480 / this.size)].isPlayableByPlayer()) {
////            System.out.println(("HRATELNE HRACOM HURAAAA"));
////        }
//
//    }

}

