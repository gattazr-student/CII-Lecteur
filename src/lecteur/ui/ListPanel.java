package lecteur.ui;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;

public class ListPanel extends JPanel {

    public ListPanel(){
        setLayout(new BorderLayout());
        String[] columnNames = {"Nom",
                        "Auteur",
                        "Duree"};
        Object[][] data = {{"Tuvaferkwa","Fatal Bazooka","3:45"},{"Tuvaferkwamaintenant","Fatal pistolet","4:32"}};

        DefaultTableModel tableModel = new DefaultTableModel(data,columnNames) {
          @Override
          public boolean isCellEditable(int row, int column) {
            return false;
          }
        };

        JTable table = new JTable();
        table.setModel(tableModel);
        add(table, BorderLayout.CENTER);
        JPanel southControl = new JPanel();
        add(new JPanel(), BorderLayout.SOUTH);
    }
}
