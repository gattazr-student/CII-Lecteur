package lecteur.ui;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JToggleButton;
import java.awt.event.ComponentListener;
import java.awt.event.ComponentEvent;

public class Interface extends JFrame  {

	private static double WIDTH_MIN = 700; /* Valeur minimum de largeur de la fenêtre */
	private static double HEIGHT_MIN = 100; /* Valeur minimum de hauter de la fenêtre */
	private static double HEIGHT_SEUIL = 200; /* Valeur seuil de hauter de la fenêtre */


	public static void main(String[] aArgs){
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Interface("Lecteur Multimédia").setVisible(true);
			}
		});
	}

	private ControlsPanel pControls; /* Panel contenant les contrôles */
	private ListPanel pList; /* Panel contenant la liste de lecture */

	private double pOldHeight; /* Sauvegarde de l'ancienne hauteur de la fenêtre */

	/*
	 * Constructeur de la fenêtre
	 */
	public Interface(String aTitle){
		super(aTitle);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		/* Création d'une border layout at ajout d'un listener (défini en classe interne)*/
		setLayout(new BorderLayout());
		this.addComponentListener(new MyComponentListener());

		/* Création du panel des controls */
		pControls = new ControlsPanel();
		add(pControls, BorderLayout.NORTH);

		/* Création du panel liste de lecture */
		pList = new ListPanel();

		pack();
		WIDTH_MIN = getSize().getWidth();
		HEIGHT_MIN = getSize().getHeight();
		this.pOldHeight = HEIGHT_SEUIL;
	}

	/**
	 * resizeFrame
	 * Redimenssionne la fenêtre aux paramètre donnée. Si la valeur souhaité en hauteur ou en
	 * largeur est est inférieur au statiques HEIGHT_MIN ou WIDTH_MIN, alors c'est cette seconde
	 * valeur qui sera utilisé. valeurs sont utilisés. De plus, si la hauteur est inférieur à
	 * HEIGHT_SEUIL, la hauteur sera égale à HEIGHT_MIN.
	 * @param double aWidth hauteur souhaité de la fenêtre
	 * @param double aHeight largeur souhaitée de la fenêtre
	 */
	private void resizeFrame(double aWidth, double aHeight){
		double wWidth = aWidth;
		double wHeight = aHeight;

		if(aWidth < WIDTH_MIN){
			wWidth = WIDTH_MIN;
		}

		if(aHeight < HEIGHT_SEUIL){
			wHeight = HEIGHT_MIN;
			remove(pList);
			/* ToggleButton off */
			/* Transmission de l'information "panel list invisible" */
			pControls.setListPanelVisible(false);
		}else{
			add(pList, BorderLayout.CENTER);
			this.pOldHeight = wHeight;
			/* ToggleButton on */
			/* Transmission de l'information "panel list visible" */
			pControls.setListPanelVisible(true);
		}
		setSize((int)wWidth, (int)wHeight);
	}

	/**
	 * showHide
	 * Gestion de l'évènement show/hide de la liste
	 * Rendre visible la fenêtre alors qu'elle déja visible, ou invisible alors qu'elle est déja
	 * invisible n'a aucun effet.
	 * @param aVisible True si il faut rendre la fenêtre visible. False sinon.
	 */
	public void showHide(boolean aVisible){
		if(aVisible == true){
			if(this.pOldHeight > HEIGHT_SEUIL){
				resizeFrame(getSize().getWidth(), this.pOldHeight);
			}else{
				resizeFrame(getSize().getWidth(), HEIGHT_SEUIL);
			}

		} else {
			this.pOldHeight = getSize().getHeight();
			resizeFrame(getSize().getWidth(), HEIGHT_MIN);
		}
	}

	/**
	 * MyComponentListener
	 * Ecoute des évènements de redimensionnement de la fenêtre
	 */
	public class MyComponentListener implements ComponentListener {

		public void componentResized(ComponentEvent e) {
			resizeFrame(getSize().getWidth(), getSize().getHeight());
		}

		public void componentHidden(ComponentEvent e) {
		}

		public void componentMoved(ComponentEvent e) {
		}

		public void componentShown(ComponentEvent e) {
		}
	}
}
