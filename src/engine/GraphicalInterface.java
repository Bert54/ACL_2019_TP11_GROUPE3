package engine;

import javax.swing.JFrame;
import java.awt.*;


/**
 * @author Horatiu Cirstea, Vincent Thomas
 *
 * interface graphique avec son controller et son afficheur
 *
 */
public class GraphicalInterface  {

	/**
	 * le Panel pour l'afficheur
	 */
	private DrawingPanel panel;
	
	/**
	 * la construction de l'interface graphique: JFrame avec panel pour le game
	 * 
	 * @param gamePainter l'afficheur a utiliser dans le moteur
	 * @param gameController l'afficheur a utiliser dans le moteur
	 * 
	 */
	public GraphicalInterface(GamePainter gamePainter, GameController gameController, JFrame f){
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setTitle("Maze");
		
		// attacher le panel contenant l'afficheur du game
		this.panel=new DrawingPanel(gamePainter);
		f.setContentPane(this.panel);

		// position de la fenetre
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		f.setLocation((screen.width-panel.getWidth())/2, (screen.height-panel.getHeight())/2);
		
		// attacher controller au panel du game
		this.panel.addKeyListener(gameController);	
		this.panel.addMouseListener(gameController);
		
		f.pack();
		f.setVisible(true);
		f.getContentPane().setFocusable(true);
		f.getContentPane().requestFocus();
	}
	
	/**
	 * mise a jour du dessin
	 */
	public void paint() {
		this.panel.drawGame();	
	}
	
}
