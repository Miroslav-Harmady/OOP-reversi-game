package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;

public class GameMenu extends JPanel {
    private ResetButton resetButton;
    private JSlider resizeSlider;
    private JLabel sizeInfo;

    public GameMenu(){
        super();
        this.setLayout(new GridLayout(1,3));
        this.resizeSlider = new JSlider();
        this.sizeInfo = new JLabel();
//        this.resetButton = new JButton();
//        this.resetButton.setText("RESET");
        this.resetButton = new ResetButton();

        this.setBackground(Color.lightGray);

        this.add(this.resizeSlider);
        this.add(this.sizeInfo);
        this.add(this.resetButton);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
