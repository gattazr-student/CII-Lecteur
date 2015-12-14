package lecteur.ui;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;

public class ListPanel extends JPanel {

    public ListPanel(){
        setLayout(new BorderLayout());
        String[] columnNames = {"Nom",
                        "Auteur",
                        "Duree"};
        Object[][] data = {{"Tuvaferkwa","Fatal Bazooka","3:45"},{"Tuvaferkwamaintenant","Fatal pistolet","4:32"},{"J'ai trop le seum d'être moi même","Maitre Grims","0:05"}};

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
        southControl.setLayout(new BorderLayout());

        JPanel southButton = new JPanel();
        southButton.add(new JButton("+"));
        southButton.add(new JButton("alea"));
        southButton.add(new JButton("repeat"));

        southControl.add(southButton,BorderLayout.WEST);
        southControl.add(new JLabel(tableModel.getRowCount() + " Elements"),BorderLayout.CENTER);

        JTextField searchField = new JTextField();
        searchField.setColumns(15);
        southControl.add(searchField,BorderLayout.EAST);


        add(southControl, BorderLayout.SOUTH);


    }
}
