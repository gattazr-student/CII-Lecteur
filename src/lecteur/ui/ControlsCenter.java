package lecteur.ui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JToggleButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JSlider;
import javax.swing.JLabel;

public class ControlsCenter extends JPanel {

    public ControlsCenter(ItemListener aItemListener){
        setLayout(new BorderLayout());

        /* Panel SOUTH */
        JPanel wPanelSouth = new JPanel();
        wPanelSouth.setLayout(new BorderLayout());
        wPanelSouth.add(new JSlider(0,100, 100), BorderLayout.CENTER);
        JPanel wButtons = new JPanel();
        wButtons.add(new JToggleButton("Equalizer"));
        JToggleButton wShowHideButton = new JToggleButton("Hide/Show");
        wButtons.add(wShowHideButton);
        wPanelSouth.add(wButtons, BorderLayout.EAST);
        this.add(wPanelSouth, BorderLayout.SOUTH);

        wShowHideButton.addItemListener(aItemListener);

        /* Panel Center */
        JPanel wPanelCenter = new JPanel();
        wPanelCenter.setLayout(new BorderLayout());
        JPanel wPanelTitles = new JPanel();
        wPanelTitles.setLayout(new BorderLayout());
        wPanelTitles.add(new JLabel("Fatal Bazooka - Tuvaferkwa"), BorderLayout.WEST);
        wPanelTitles.add(new JLabel("0:00"), BorderLayout.EAST);
        wPanelCenter.add(wPanelTitles, BorderLayout.NORTH);
        wPanelCenter.add(new JSlider(0,100, 0), BorderLayout.CENTER);
        this.add(wPanelCenter, BorderLayout.CENTER);
    }
}
