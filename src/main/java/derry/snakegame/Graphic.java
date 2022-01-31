package derry.snakegame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Graphic extends JPanel implements ActionListener {

    private Timer timer = new Timer(100, this);
    public String status;

    private Snake snake;
    private Food food;
    private Game game;

    public Graphic(Game game) {
        timer.start();
        this.game = game;
        this.snake = game.getSnake();
        this.food = game.getFood();
        this.status = "START";

        this.addKeyListener(game);
        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.black);
        g2d.fillRect(0,0, Game.WIDTH_SIZE + 5, Game.HEIGHT_SIZE + 5);

        if (status.equals("START")) {
            g2d.setColor(Color.white);
            g2d.drawString("Press any key to start", Game.WIDTH_SIZE / 2 - 40, Game.HEIGHT_SIZE / 2 - 20);
        } else if (status.equals("RUNNING")) {
            g2d.setColor(Color.red); // Food
            g2d.fillRect(food.getX() * Game.DIMENSION, food.getY() * Game.DIMENSION, Game.DIMENSION, Game.DIMENSION);

            g2d.setColor(Color.green); // Snake
            for (Rectangle each: snake.getBody()) {
                g2d.fill(each);
            }

        } else {
            // Game over
            g2d.setColor(Color.white);
            g2d.drawString("Your score is " + (snake.getBody().size() - 3), Game.WIDTH_SIZE / 2 - 40, Game.HEIGHT_SIZE / 2 - 20);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint(); // after each time intermission, we will repaint(). repaint will call the paintComponent()
        game.update();
    }
}
