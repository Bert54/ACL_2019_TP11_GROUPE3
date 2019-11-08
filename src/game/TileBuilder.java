package game;

import java.util.ArrayList;

public class TileBuilder {

    /**
     * la taille des cases
     */
    protected static final int WIDTH = 500;
    protected static final int HEIGHT = 500;

    public TileBuilder() {
    }

    public Edge buildEdgeLeft(){

        Edge edge = new Edge(new Vec2(0,0), new Vec2(WIDTH/100,HEIGHT));
        return edge;
    }

    public Edge buildEdgeRight(){

        Edge edge = new Edge(new Vec2(WIDTH-WIDTH/100,0), new Vec2(WIDTH/100,HEIGHT));
        return edge;
    }

    public Edge buildEdgeTop(){

        Edge edge = new Edge(new Vec2(0,0), new Vec2(WIDTH,HEIGHT/100));
        return edge;
    }

    public Edge buildEdgeBottom(){

        Edge edge = new Edge(new Vec2(0,HEIGHT-HEIGHT/100), new Vec2(WIDTH,HEIGHT/100));
        return edge;
    }
    public Goal buildGoal() {
        Goal goal = new Goal(new Vec2((int)(Math.random()*400),(int)(Math.random()*400) ), new Vec2(30, 30));
        return goal;
    }

    public ArrayList<Obstacle> buildObstacles(){

        ArrayList<Obstacle> obstacles = new ArrayList<>();

        for(int i = 0; i < 5; i++){

            int x, y;
            x = (int) (WIDTH/100 + (Math.random() * ((WIDTH - 50) - WIDTH/100))) ;
            y = (int) (HEIGHT/100 + (Math.random() * ((HEIGHT - 50) - HEIGHT/100)));
            obstacles.add(new Obstacle(new Vec2(x,y), new Vec2(50,50)));
        }

        return obstacles;
    }
}
