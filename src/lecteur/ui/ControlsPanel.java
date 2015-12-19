package lecteur.ui;

import javax.swing.JPanel;
import java.awt.event.ItemListener;
import java.awt.BorderLayout;

public class ControlsPanel extends JPanel {

    ControlsCenter pCenter;
    ControlsButtons pButtons;

    /*
	 * Construction du panel contenant les contrôles
	 */
    public ControlsPanel(){
        setLayout(new BorderLayout());
        this.pCenter = new ControlsCenter();
        this.pButtons = new ControlsButtons();
        add(this.pCenter, BorderLayout.CENTER);
        add(this.pButtons, BorderLayout.WEST);
    }

    /**
	 * setListPanelVisible
     * Transmission de l'information sur la visibilité du panel list
	 * @param aVisible True si le panel List est visible. False sinon.
	 */
    public void setListPanelVisible(boolean aToggled){
        pCenter.setListPanelVisible(aToggled);
    }
}
