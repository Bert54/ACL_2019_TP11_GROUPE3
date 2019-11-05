package start;

import engine.GameEngineGraphical;
import model.*;

/**
 * lancement du moteur avec le jeu
 */
public class Main {

	public static void main(String[] args) throws InterruptedException {

		// creation du jeu particulier et de son afficheur
		WorldPainter worldPainter = new WorldPainter();
		WorldController worldController = new WorldController();
		World world = new World(worldPainter, worldController);
		// classe qui lance le moteur de jeu generique
		GameEngineGraphical gameEngineGraphical = new GameEngineGraphical(world, worldPainter, worldController);
		gameEngineGraphical.run();

	}

}
