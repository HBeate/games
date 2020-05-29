package at.bha.games.snake;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;

import java.util.ArrayList;
import java.util.Random;

public class Food implements Actor {
    private int x, y;
    private boolean isEaten;
    private int counter = 0;
    Random random = new Random();
    private Element element;
    private ArrayList<Element> elements;
    private Food food;

    public Food() {
        this.x = random.nextInt(20);
        this.y = random.nextInt(15);
        this.isEaten = false;
    }


    public void setEaten(boolean eaten) {
        isEaten = eaten;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    @Override
    public void render(Graphics graphics) {
      if (!isEaten) {
          graphics.setColor(Color.red);
          graphics.fillOval(this.x * SnakeGame.GRID_SIZE, this.y * SnakeGame.GRID_SIZE, 20, 20);
      }
    }


    @Override
    public void update(int delta) {


    }
}
