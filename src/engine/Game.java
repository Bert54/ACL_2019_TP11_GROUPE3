package engine;

/**
 * @author Horatiu Cirstea, Vincent Thomas
 *
 *         un jeu qui peut evoluer (avant de se terminer) sur un plateau width x
 *         height
 */
public interface Game {

	public boolean start = false;

	public boolean isStart();

	public void evolve();

	/**
	 * @return true si et seulement si le jeu est fini
	 */
	public boolean isFinished();

}
