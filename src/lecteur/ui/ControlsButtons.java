package lecteur.ui;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;

public class ControlsButtons extends JPanel {

    public ControlsButtons(){
        setLayout(new GridLayout(2, 3));
        add(new JButton("Back"));
        add(new JButton("Play"));
        add(new JButton("Forward"));
        add(new JButton("Previous"));
        add(new JButton("Stop"));
        add(new JButton("Next"));
    }
}
