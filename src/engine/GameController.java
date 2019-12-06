package engine;

import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.List;
/**
 * @author Horatiu Cirstea
 * 
 * controleur qui envoie des commandes au jeu 
 * 
 */
public interface GameController extends KeyListener, MouseListener {

	/**
	 * quand on demande les commandes, le controleur retourne les commandes en
	 * cours
	 * 
	 * @return commandes faites par le joueur
	 */
	public List<Cmd> getCommands();

	public void clearCommands();

}
