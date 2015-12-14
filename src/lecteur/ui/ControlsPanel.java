package lecteur.ui;

import javax.swing.JPanel;
import java.awt.BorderLayout;

public class ControlsPanel extends JPanel {

    public ControlsPanel(){
        setLayout(new BorderLayout());
        add(new ControlsCenter(), BorderLayout.CENTER);
        add(new ControlsButtons(), BorderLayout.WEST);
    }
}
