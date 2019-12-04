package start;

import engine.GameEngineGraphical;
import game.level.Camera;
import model.*;

import javax.swing.*;

public class Main {
	public static void main(String[] args) throws InterruptedException {

		JFrame f = new JFrame();
		WorldPainter worldPainter = new WorldPainter(new Camera());
		WorldController worldController = new WorldController();
		World world = new World(worldPainter, worldController, f);

		GameEngineGraphical gameEngineGraphical = new GameEngineGraphical(world, worldPainter, worldController, f);
		gameEngineGraphical.run();

	}

}
