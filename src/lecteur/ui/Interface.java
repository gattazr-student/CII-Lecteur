package lecteur.ui;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;

public class Interface extends JFrame {

	public Interface(String aTitle){
		super(aTitle);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setLayout(new BorderLayout());

		add(new ControlsPanel(), BorderLayout.NORTH);
		add(new ListPanel(), BorderLayout.CENTER);
		pack();
	}

	public static void main(String[] aArgs){
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Interface("Lecteur Multimédia").setVisible(true);
			}
		});
	}
}
