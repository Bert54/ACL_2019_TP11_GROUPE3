package start;

import engine.GameEngineGraphical;
import model.*;

/**
 * lancement du moteur avec le jeu
 */
public class Main {

	public static void main(String[] args) throws InterruptedException {

		// creation du jeu particulier et de son afficheur
		World world = new World();
		WorldPainter worldPainter = new WorldPainter();
		WorldController worldController = new WorldController();

		// classe qui lance le moteur de jeu generique
		GameEngineGraphical gameEngineGraphical = new GameEngineGraphical(world, worldPainter, worldController);
		gameEngineGraphical.run();

	}

}
