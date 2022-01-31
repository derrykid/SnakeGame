package derry.snakegame;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game implements KeyListener {

    private Snake snake;
    private Food food;
    private Graphic graphics;

    public static final String GAME_NAME = "Snake Game";
    public static final int WIDTH = 30;
    public static final int HEIGHT = 30;
    public static final int DIMENSION = 20;
    public static final int WIDTH_SIZE = WIDTH * DIMENSION;
    public static final int HEIGHT_SIZE =  HEIGHT * DIMENSION;

    private JFrame window;

    public Game() {
        window = new JFrame();

        // initialize objects
        snake = new Snake();
        food = new Food(snake);
        graphics = new Graphic(this);

        window.add(graphics);

        window.pack();

        window.setTitle(GAME_NAME);
        window.setVisible(true);
        window.setResizable(false);
        window.setSize(WIDTH_SIZE , HEIGHT_SIZE ); //
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void start() {
        graphics.status = "RUNNING";
    }

    public void update() {
        if (graphics.status.equals("RUNNING")) {
            if (foodCollision()) {
                snake.grow();
                food.randomSpwan(snake);
            } else if (wallCollision() || selfCollision()) {
                graphics.status = "END";
            } else {
                snake.move();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (graphics.status.equals("RUNNING")) {
            if (keyCode == KeyEvent.VK_UP) {
                snake.up();
            }
            if (keyCode == KeyEvent.VK_DOWN) {
                snake.down();
            }
            if (keyCode == KeyEvent.VK_LEFT) {
                snake.left();
            }
            if (keyCode == KeyEvent.VK_RIGHT) {
                snake.right();
            }
        } else {
            this.start();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public Snake getSnake() {
        return this.snake;
    }

    public Food getFood() {
        return this.food;
    }

    public boolean wallCollision() {
        if (snake.getX() < 0 || snake.getX() > WIDTH_SIZE || snake.getY() < 0 || snake.getY() > HEIGHT_SIZE) {
            return true;
        }
        return false;
    }

    public boolean foodCollision() {
        if (snake.getX() == food.getX() * Game.DIMENSION && snake.getY() == food.getY() * Game.DIMENSION) {
            return true;
        }
        return false;
    }

    public boolean selfCollision() {
        for (int i = 1; i < snake.getBody().size(); i++) {
            // check if the snake head (index 0) is collided with other body part
            // only head can collide other part
            if (snake.getX() == snake.getBody().get(i).x && snake.getY() == snake.getBody().get(i).y) {
                return true;
            }
        }
        return false;
    }









}
