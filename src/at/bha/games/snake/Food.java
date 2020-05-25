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
    private Shape collisionShape;
    private Element element;
    private ArrayList<Element> elements;
    private Food food;

    public Food() {
        this.x = random.nextInt(14);
        this.y = random.nextInt(15);
        this.isEaten = false;
        this.collisionShape  = new Circle(this.x,this.y,10);

    }

    public boolean isEaten() {
        return isEaten;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.setColor(Color.red);
        graphics.fillOval(this.x * SnakeGame.GRID_SIZE, this.y * SnakeGame.GRID_SIZE, 20, 20);
        graphics.setColor(Color.white);
        graphics.draw(this.collisionShape);

    }

    @Override
    public void update(int delta) {

        this.collisionShape.setCenterX(this.x* SnakeGame.GRID_SIZE+10);
        this.collisionShape.setCenterY(this.y* SnakeGame.GRID_SIZE+10);
    }
    public void addCollisionPartner(Element element){
        this.elements.add(element);
    }
}
