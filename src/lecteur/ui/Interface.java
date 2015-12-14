package lecteur.ui;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;

import java.awt.event.ComponentListener;
import java.awt.event.ComponentEvent;
//import java.awt.Dimension;

public class Interface extends JFrame implements ComponentListener {

	private static int X_MIN = 700;
	private static int Y_MIN = 100;
	private static int Y_SEUIL = 200;

	public Interface(String aTitle){
		super(aTitle);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setLayout(new BorderLayout());

		this.addComponentListener(this);

		add(new ControlsPanel(), BorderLayout.NORTH);
		add(new ListPanel(), BorderLayout.CENTER);
		pack();

		this.setSize(X_MIN,Y_MIN);
	}

	public void componentResized(ComponentEvent e) {
//		System.out.println(e.getComponent().getClass().getName() + " --- Resized : " + this.getSize().getWidth()+ " / " + this.getSize().getHeight());
		if(this.getSize().getWidth() < X_MIN || this.getSize().getHeight() < Y_MIN) {
			setSize(X_MIN,Y_MIN);
		}

		if (this.getSize().getHeight() < Y_SEUIL) {
			setSize(X_MIN,Y_MIN);
		}
  }

	public void componentHidden(ComponentEvent e) {
//		System.out.println(e.getComponent().getClass().getName() + " --- Hidden");
	}

  public void componentMoved(ComponentEvent e) {
//    System.out.println(e.getComponent().getClass().getName() + " --- Moved");
  }

  public void componentShown(ComponentEvent e) {
//    System.out.println(e.getComponent().getClass().getName() + " --- Shown");
  }

	public static void main(String[] aArgs){
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Interface("Lecteur Multimédia").setVisible(true);
			}
		});
	}
}
