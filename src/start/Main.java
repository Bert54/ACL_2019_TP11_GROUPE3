package start;

import engine.GameEngineGraphical;
import model.*;

import java.awt.im.InputContext;

public class Main {
	public static void main(String[] args) throws InterruptedException {

		WorldPainter worldPainter = new WorldPainter();
		WorldController worldController = new WorldController();
		World world = new World(worldPainter, worldController);

		GameEngineGraphical gameEngineGraphical = new GameEngineGraphical(world, worldPainter, worldController);
		gameEngineGraphical.run();

	}

}
