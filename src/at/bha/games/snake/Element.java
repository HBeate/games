package at.bha.games.snake;

import org.ietf.jgss.GSSName;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

import java.util.ArrayList;

public class Element implements Actor {

    private int x,y;
    private Element next;
    private Shape collisionShape;
    private ArrayList<Food> foods;

    public Element(int x, int y) {
        /*
        test
         */
        this.x = x;
        this.y = y;
        this.collisionShape = new Rectangle(this.x, this.y, 20,20);
        this.foods = new ArrayList<Food>();
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Element getNext() {
        return next;
    }

    public void setNext(Element next) {
        this.next = next;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.setColor(Color.green);
        graphics.fillRect(this.x * SnakeGame.GRID_SIZE, this.y * SnakeGame.GRID_SIZE, SnakeGame.GRID_SIZE/2
                , SnakeGame.GRID_SIZE/2);
        graphics.setColor(Color.blue);
        graphics.draw(this.collisionShape);

    }

    @Override
    public void update(int delta) {
this.collisionShape.setCenterX(this.x * SnakeGame.GRID_SIZE+10);
this.collisionShape.setCenterY(this.y * SnakeGame.GRID_SIZE+10);
    }




public void addCollisionPartner(Food food){
        this.foods.add(food);
}
}
