package lecteur.ui;

import javax.swing.JPanel;
import java.awt.event.ItemListener;
import java.awt.BorderLayout;

public class ControlsPanel extends JPanel {

    public ControlsPanel(ItemListener aItemListener){
        setLayout(new BorderLayout());
        add(new ControlsCenter(aItemListener), BorderLayout.CENTER);
        add(new ControlsButtons(), BorderLayout.WEST);
    }
}
