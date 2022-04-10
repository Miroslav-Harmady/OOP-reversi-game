package sk.stuba.fei.uim.oop;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameMenu extends JPanel implements ChangeListener {
    private ResetButton resetButton;
    private JSlider resizeSlider;
    private JLabel sizeInfo;

    public GameMenu(JFrame window){
        super();

        this.setPreferredSize(new Dimension(500, 75));

        this.setLayout(new GridLayout(1,3));
        this.resizeSlider = new JSlider(6, 12, 6);
        this.sizeInfo = new JLabel("6x6");
        this.resetButton = new ResetButton(window);

        this.setBackground(Color.lightGray);
        this.add(this.resizeSlider);
        this.add(this.sizeInfo);
        this.add(this.resetButton);

        this.setSlider();

        this.resizeSlider.addChangeListener(this);
        this.resetButton.addActionListener(this.resetButton);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }


    @Override
    public void stateChanged(ChangeEvent e) {
        this.resetButton.setSize(((JSlider) e.getSource()).getValue());
    }

    private void  setSlider(){
        this.resizeSlider.setMajorTickSpacing(2);
        this.resizeSlider.setPaintTicks(true);
        this.resizeSlider.setPaintLabels(true);
        this.resizeSlider.setPaintTrack(true);
        this.resizeSlider.setSnapToTicks(true);
    }

    public JLabel getSizeInfo() {
        return sizeInfo;
    }
}
