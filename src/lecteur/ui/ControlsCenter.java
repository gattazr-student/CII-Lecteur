package lecteur.ui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.JToggleButton;
import javax.swing.JToggleButton.ToggleButtonModel;
import javax.swing.SwingUtilities;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JSlider;
import javax.swing.JLabel;

public class ControlsCenter extends JPanel {

    JToggleButton pShowHideButton;

    /*
	 * Construction du panel contenant la gestion du volume, les informations sur le médias joués,
     * et le bouton HIDE/SHOW
	 */
    public ControlsCenter(){
        setLayout(new BorderLayout());

        /* Panel SOUTH */
        /* Slider volumes, Bouton égaliseur, HIDE/SHOW*/
        JPanel wPanelSouth = new JPanel();
        wPanelSouth.setLayout(new BorderLayout());
        wPanelSouth.add(new JSlider(0, 100, 100), BorderLayout.CENTER);
        JPanel wButtons = new JPanel();
        wButtons.add(new JToggleButton("Equalizer"));
        this.pShowHideButton = new JToggleButton("Hide/Show");
        wButtons.add(this.pShowHideButton);
        wPanelSouth.add(wButtons, BorderLayout.EAST);
        this.add(wPanelSouth, BorderLayout.SOUTH);

        /* ItemListener utilisé pour gérer l'évènement SHOW/HIDE du panel contenant la liste */
        this.pShowHideButton.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ev) {

                Interface wFrame = (Interface) SwingUtilities.getWindowAncestor( (Component)ev.getSource() );
                if(ev.getStateChange() == ItemEvent.SELECTED){
                    wFrame.showHide(true);
                } else if(ev.getStateChange()==ItemEvent.DESELECTED){
                    wFrame.showHide(false);
                }
            }
        });


        /* Panel Center */
        /* Titre chanson, slider, slider timer */
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

    /**
	 * setListPanelVisible
     * Transmission de l'information sur la visibilité du panel list
	 * @param aVisible True si le panel List est visible. False sinon.
	 */
    public void setListPanelVisible(boolean isToggled){
        this.pShowHideButton.setSelected(isToggled);
    }
}
