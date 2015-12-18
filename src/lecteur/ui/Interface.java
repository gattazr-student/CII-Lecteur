package lecteur.ui;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ComponentEvent;

public class Interface extends JFrame  {

	private static double X_MIN = 700;
	private static double Y_MIN = 100;
	private static double Y_SEUIL = 200;

	private ControlsPanel pControls;
	private ListPanel pList;

	public Interface(String aTitle){
		super(aTitle);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setLayout(new BorderLayout());
		this.addComponentListener(new MyComponentListener());

		/* Control panel */
		ItemListener wItemListener = new ItemListener() {
            public void itemStateChanged(ItemEvent ev) {
                if(ev.getStateChange()==ItemEvent.SELECTED){
					resizeFrame(X_MIN, Y_SEUIL+1);
                } else if(ev.getStateChange()==ItemEvent.DESELECTED){
                    resizeFrame(X_MIN, Y_MIN);
                }
            }
        };
		pControls = new ControlsPanel(wItemListener);
		add(pControls, BorderLayout.NORTH);

		/* List panel */
		pList = new ListPanel();

		pack();
		X_MIN = getSize().getWidth();
		Y_MIN = getSize().getHeight();
	}

	public void resizeFrame(double aWidth, double aHeight){
		double wWidth = aWidth;
		double wHeight = aHeight;

		if(aWidth <= X_MIN){
			wWidth = X_MIN;
		}

		if(aHeight <= Y_SEUIL){
			wHeight = Y_MIN;
			remove(pList);
		}else{
			add(pList, BorderLayout.CENTER);
		}

		setSize((int)wWidth, (int)wHeight);
	}

	public static void main(String[] aArgs){
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Interface("Lecteur Multimédia").setVisible(true);
			}
		});
	}

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
