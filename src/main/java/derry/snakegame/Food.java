package derry.snakegame;

import java.awt.*;

public class Food {
    private int x;
    private int y;

    public Food(Snake snake){
        randomSpwan(snake);
    }

    public void randomSpwan(Snake snake) {
        // this will spwan the red dot on the map in random location

        boolean ifOverlap = true;
        while (ifOverlap) {
            ifOverlap = false;
            // both subtract by 1, in case the food is respawned outside the frame
            x = (int) (Math.random() * Game.WIDTH - 1);
            y = (int) (Math.random() * Game.HEIGHT - 1);
            for (Rectangle per: snake.getBody()){
                if (per.x == x && per.y == y) {
                    ifOverlap = true;
                }
            }

        }
    }

    public int getX(){
        return x;
    }
    public int getY() {
        return y;
    }
}
