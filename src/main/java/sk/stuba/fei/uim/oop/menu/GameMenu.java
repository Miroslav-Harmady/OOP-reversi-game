package sk.stuba.fei.uim.oop.menu;

import lombok.Getter;
import sk.stuba.fei.uim.oop.GameWindow;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class GameMenu extends JPanel implements ChangeListener {
    @Getter
    private ResetButton resetButton;
    @Getter
    private JSlider resizeSlider;
    private JLabel sizeInfo;
    private GameWindow frame;

    public GameMenu(GameWindow frame){
        super();

        this.setPreferredSize(new Dimension(500, 75));

        this.setLayout(new GridLayout(1,3));
        this.resizeSlider = new JSlider(6, 12, 6);
        this.sizeInfo = new JLabel("6x6");
        this.resetButton = new ResetButton(frame);
        this.frame = frame;

        this.setBackground(Color.lightGray);
        this.add(this.resizeSlider);
        this.add(this.sizeInfo);
        this.add(this.resetButton);

        this.setSlider();

        this.resizeSlider.addChangeListener(this);
        this.resizeSlider.setFocusable(false);
        this.resetButton.addActionListener(this.resetButton);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }


    @Override
    public void stateChanged(ChangeEvent e) {

        this.resetButton.setSize(((JSlider) e.getSource()).getValue());
        //--------------------------
        this.frame.gameRestart();
    }

    private void  setSlider(){
        this.resizeSlider.setMajorTickSpacing(2);
        this.resizeSlider.setPaintTicks(true);
        this.resizeSlider.setPaintLabels(true);
        this.resizeSlider.setPaintTrack(true);
        this.resizeSlider.setSnapToTicks(true);
    }
}
