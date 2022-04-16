package sk.stuba.fei.uim.oop.board;

import sk.stuba.fei.uim.oop.logic.GameRules;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Tile extends JPanel implements MouseListener {
    private int size;
    private GameRules rules;
    private Color fill;


    public Tile(GameRules rules, Color color, boolean highlighted){
        super();
        this.rules = rules; // okej toto asi esete zmazat a upravit aj inde v kode
        this.fill = color;
        this.setSize(480/this.rules.getBoardSize());
        if (highlighted){
            this.setBorder(BorderFactory.createLineBorder(Color.red,3));
            //this.addMouseListener(this); ked pouzijem tento listener nebude mi fungovat listener v ploche
        } else{
            this.setBorder(BorderFactory.createLineBorder(Color.black));
        }
        this.setBackground(Color.green);
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(this.fill);
        g.fillOval(this.size/10,this.size/10,this.size*8/10,this.size*8/10);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.setBorder(BorderFactory.createLineBorder(Color.blue,3));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.setBorder(BorderFactory.createLineBorder(Color.red,3));
    }
}
