package derry.snakegame;

import java.awt.*;
import java.util.ArrayList;

public class Snake {
    private ArrayList<Rectangle> body;
    private String move = "";

    public Snake() {
        this.body = new ArrayList<>();

        // create 3 rectangles and each one's location is next to the first one
        for (int i = 0; i < 3; i++) {
            Rectangle rect = new Rectangle(Game.DIMENSION, Game.DIMENSION);
            rect.setLocation((Game.WIDTH / 2 - i) * Game.DIMENSION, Game.HEIGHT / 2 * Game.DIMENSION);
            body.add(rect);
        }
    }

    public ArrayList<Rectangle> getBody() {
        return this.body;
    }

    public int getX(){
        return body.get(0).x;
    }
    public int getY(){
        return body.get(0).y;
    }

    public void setBody(ArrayList<Rectangle> rect) {
        this.body = rect;
    }

    public void move() {
        if (!move.equals("")) {
            Rectangle head = this.body.get(0);
            Rectangle toAdd = new Rectangle(Game.DIMENSION, Game.DIMENSION);

            if (move.equals("UP")) {
                toAdd.setLocation(head.x, head.y - Game.DIMENSION);
            }
            if (move.equals("DOWN")) {
                toAdd.setLocation(head.x, head.y + Game.DIMENSION);
            }
            if (move.equals("LEFT")) {
                toAdd.setLocation(head.x - Game.DIMENSION, head.y);
            }
            if (move.equals("RIGHT")) {
                toAdd.setLocation(head.x + Game.DIMENSION, head.y);
            }
            body.add(0, toAdd);
            body.remove(body.size() - 1);
        }
    }

    // grow the lenght of snake
    public void grow() {
        Rectangle head = this.body.get(0);
        Rectangle toAdd = new Rectangle(Game.DIMENSION, Game.DIMENSION);

        if (move.equals("UP")) {
            toAdd.setLocation(head.x, head.y - Game.DIMENSION);
        }
        if (move.equals("DOWN")) {
            toAdd.setLocation(head.x, head.y + Game.DIMENSION);
        }
        if (move.equals("LEFT")) {
            toAdd.setLocation(head.x - Game.DIMENSION, head.y);
        }
        if (move.equals("RIGHT")) {
            toAdd.setLocation(head.x + Game.DIMENSION, head.y);
        }
        body.add(0, toAdd);

    }

    public void up() {
        this.move = "UP";
    }

    public void down() {
        this.move = "DOWN";
    }

    public void left() {
        this.move = "LEFT";
    }

    public void right() {
        this.move = "RIGHT";
    }
}
