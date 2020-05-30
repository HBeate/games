package at.bha.games.snake;

import org.newdawn.slick.*;
import org.newdawn.slick.AngelCodeFont;

import java.util.ArrayList;
import java.util.List;

public class SnakeGame extends BasicGame {
    public enum DIRECTION {LEFT, RIGHT, UP, DOWN}

    public static final int GRID_SIZE = 40;
    public static final int SPEED = 500;

    private int timeElapsed = 0;
    private List<Actor> actors;
    private Element head;
    private Element tail;
    private DIRECTION direction;
    private Food food;
    private int counter = 0;
    //   private List<Food> foods; Falls ich mal mehrere Foods anzeigen möchte

    public SnakeGame(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.actors = new ArrayList<>();

        generateApple();

        Element e1 = new Element(1, 5);
        Element e2 = new Element(2, 5);
        Element e3 = new Element(3, 5);
        Element e4 = new Element(4, 5);

        this.direction = DIRECTION.RIGHT;
        //Elemente verbinden
        e1.setNext(e2);
        e2.setNext(e3);
        e3.setNext(e4);
        this.tail = e1;
        this.head = e4;

        //Elemente zur Liste hinzufügen zum Rendern
        this.actors.add(e1);
        this.actors.add(e2);
        this.actors.add(e3);
        this.actors.add(e4);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        for (Actor actor : this.actors) {
            actor.update(delta);
        }
        this.timeElapsed += delta;
        if (this.timeElapsed > SPEED) {

// new Element
// this.head = new Element
// else

            if (direction == DIRECTION.RIGHT && (this.head.getX() + 1 == (food.getX()))
                    && (this.head.getY() == food.getY())) {
                strike();
            }
            if (direction == DIRECTION.LEFT && (this.head.getX() - 1 == (food.getX()))
                    && (this.head.getY() == food.getY())) {
                strike();
            }
            if (direction == DIRECTION.DOWN && (this.head.getX() == (food.getX()))
                    && (this.head.getY() + 1 == food.getY())) {
                strike();
            }
            if (direction == DIRECTION.UP && (this.head.getX() == (food.getX()))
                    && (this.head.getY() - 1 == food.getY())) {
                strike();
            }
            moveForward();
            this.timeElapsed = 0;
        }
    }

    private void strike() throws SlickException {
        System.out.println("Strike going " + direction);
        this.counter++;
        System.out.println(counter);
        this.food.setEaten(true);
        generateApple();

        int x = this.head.getX();
        int y = this.head.getY();
        switch (direction) {
            case RIGHT:
                x++;
                break;
            case LEFT:
                x--;
                break;
            case DOWN:
                y++;
                break;
            case UP:
                y--;
                break;
        }
        Element element = new Element(x, y);
        this.actors.add(element);
        Element tmp = this.head;
        this.head = element;
        tmp.setNext(this.head);
    }

    private void moveForward() {
        Element tmp = this.tail;
        this.tail = tmp.getNext();
        tmp.setNext(null);
        head.setNext(tmp);

        int newX = this.head.getX();
        int newY = this.head.getY();

        // logic for directions
        switch (direction) {
            case RIGHT:
                newX++;
                if (newX > 19) {
                    newX = 0;
                }
                break;
            case LEFT:
                newX--;
                if (newX < 0) {
                    newX = 19;
                }
                break;
            case UP:
                newY--;
                if (newY < 0) {
                    newY = 14;
                }
                break;
            case DOWN:
                newY++;
                if (newY > 14) {
                    newY = 0;
                }
                break;
        }
        tmp.setX(newX);
        tmp.setY(newY);

        this.head = tmp;
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        for (Actor actor : this.actors) {
            actor.render(graphics);
        }
    }

    @Override
    public void keyPressed(int key, char c) {
        if ((key == Input.KEY_RIGHT) && (direction != DIRECTION.LEFT)) {
            direction = DIRECTION.RIGHT;
        }
        if (key == Input.KEY_LEFT && (direction != DIRECTION.RIGHT)) {
            direction = DIRECTION.LEFT;
        }
        if (key == Input.KEY_UP && (direction != DIRECTION.DOWN)) {
            direction = DIRECTION.UP;
        }
        if (key == Input.KEY_DOWN && (direction != DIRECTION.UP)) {
            direction = DIRECTION.DOWN;
        }
    }

    private void generateApple() throws SlickException {

        for (int i = 0; i < 1; i++) {
            this.food = new Food();
            this.actors.add(food);
            this.food.setEaten(false);
            System.out.println("Food x:" + food.getX());
            System.out.println("Food y:" + food.getY());
        }
    }

    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new SnakeGame("Snake Game"));
            container.setDisplayMode(800, 600, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
