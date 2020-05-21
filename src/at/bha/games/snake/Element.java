package at.bha.games.snake;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class Element implements Actor {

    private int x,y;
    private Element next;

    public Element(int x, int y) {
        this.x = x;
        this.y = y;
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
    public void render(GameContainer gameContainer, Graphics graphics) {
        graphics.fillRect(this.x * SnakeGame.GRID_SIZE, this.y * SnakeGame.GRID_SIZE, SnakeGame.GRID_SIZE/2
                , SnakeGame.GRID_SIZE/2);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {

    }





}
