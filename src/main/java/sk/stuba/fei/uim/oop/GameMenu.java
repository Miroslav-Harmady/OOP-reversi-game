package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;

public class GameMenu extends JPanel {
    private JButton resetButton;
    private JSlider resizeSlider;
    private JLabel sizeInfo;

    public GameMenu(){
        super();
        //this.setVisible(true);
        this.setLayout(new GridLayout(1,3));
        this.resizeSlider = new JSlider();
        this.sizeInfo = new JLabel();
        this.resetButton = new JButton();

        this.add(this.resizeSlider);
        this.add(this.sizeInfo);
        this.add(this.resetButton);

    }
}
