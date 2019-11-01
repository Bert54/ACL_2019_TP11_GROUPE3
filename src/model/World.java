package model;

import engine.Cmd;
import engine.Game;

public class World implements Game {

    public World() {

    }

    @Override
    public void evolve(Cmd userCmd) {

        System.out.println("Execute "+userCmd);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
