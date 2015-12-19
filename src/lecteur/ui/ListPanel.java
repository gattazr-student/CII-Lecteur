package lecteur.ui;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;

public class ListPanel extends JPanel {
    /**
     * Construction du pane Liste de lecture
    */
    public ListPanel(){
        setLayout(new BorderLayout());

        String[] columnNames = {"Nom",
                        "Auteur",
                        "Duree"};
        Object[][] data = {{"Tuvaferkwa","Fatal Bazooka","3:45"},{"Baby","Justin Bieber","3:44"},{"Bella","Maitre Grims","4:42"}};
        /* Model de la JTable rendant les céllules non éditables */
        DefaultTableModel tableModel = new DefaultTableModel(data,columnNames) {
          @Override
          public boolean isCellEditable(int row, int column) {
            return false;
          }
        };

        /* Pane CENTER */
        /* liste de lecture (JTable) */
        JTable table = new JTable();
        table.setModel(tableModel);
        add(table, BorderLayout.CENTER);

        /* Panel SOUTH */
        /* Pane contennant des JBoutons , un Label et un JTextField */
        JPanel southControl = new JPanel();
        southControl.setLayout(new BorderLayout());
        add(southControl, BorderLayout.SOUTH);

        /* SubPanel WEST */
        /* Bouton ajout, aleatoire et répétition */
        JPanel southButton = new JPanel();
        southButton.add(new JButton("+"));
        southButton.add(new JButton("alea"));
        southButton.add(new JButton("repeat"));
        southControl.add(southButton,BorderLayout.WEST);

        /* SubPanel CENTER */
        southControl.add(new JLabel(tableModel.getRowCount() + " Elements"),BorderLayout.CENTER);

        /* SubPanel EAST */
        JTextField searchField = new JTextField();
        searchField.setColumns(15);
        southControl.add(searchField,BorderLayout.EAST);
    }
}
