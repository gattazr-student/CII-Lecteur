package lecteur.ui;

import javax.swing.JPanel;
import javax.swing.JTable;
import java.awt.BorderLayout;

public class ListPanel extends JPanel {

    public ListPanel(){
        setLayout(new BorderLayout());
        add(new JTable(), BorderLayout.SOUTH);
        add(new JPanel(), BorderLayout.CENTER);
    }
}
