package start;

import engine.GameEngineGraphical;
import model.*;

import javax.swing.*;
import java.awt.im.InputContext;

public class Main {
	public static void main(String[] args) throws InterruptedException {

		JFrame f = new JFrame();
		WorldPainter worldPainter = new WorldPainter();
		WorldController worldController = new WorldController();
		World world = new World(worldPainter, worldController, f);

		GameEngineGraphical gameEngineGraphical = new GameEngineGraphical(world, worldPainter, worldController, f);
		gameEngineGraphical.run();

	}

}
