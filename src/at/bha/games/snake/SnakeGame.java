package at.bha.games.snake;

import at.bha.games.star_wars_game.Fighter;
import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SnakeGame extends BasicGame {
    public static final int GRID_SIZE = 40;
    public static final int SPEED = 500;
    private int timeElapsed = 0;
    private List<Actor> actors;
    private Element element;
    private Element head;
    private Element tail;
    private String direction;
    private Actor actor;
    Random random = new Random();
    private Food food;

    public SnakeGame(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.actors = new ArrayList<>();
        generateApple();
// TODO addCollisionpartner - need to fix this

//        this.food.addCollisionPartner(element);

        Element e1 = new Element(1, 5);
        Element e2 = new Element(2, 5);
        Element e3 = new Element(3, 5);
        Element e4 = new Element(4, 5);

        this.direction = "right";

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

            Element tmp = this.tail;
            this.tail = tmp.getNext();
            tmp.setNext(null);
            head.setNext(tmp);

            int newX = this.head.getX();
            int newY = this.head.getY();

            // logic for directions
            switch (direction) {
                case "right":
                    newX++;
                    if (newX > 19) {
                        newX = 1;
                    }
                    break;
                case "left":
                    newX--;
                    if (newX < 0) {
                        newX = 19;
                    }
                    break;
                case "up":
                    newY--;
                    if (newY < 0) {
                        newY = 14;
                    }
                    break;
                case "down":
                    newY++;
                    if (newY > 14) {
                        newY = 1;
                    }
                    break;
            }
            tmp.setX(newX);
            tmp.setY(newY);

            this.head = tmp;
            this.timeElapsed = 0;
        }
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        for (Actor actor : this.actors) {
            actor.render(graphics);
        }
    }

    @Override
    public void keyPressed(int key, char c) {
        if ((key == Input.KEY_RIGHT) && (!direction.equals("left"))) {
            direction = "right";
        }
        if (key == Input.KEY_LEFT && (!direction.equals("right"))) {
            direction = "left";
        }
        if (key == Input.KEY_UP&& (!direction.equals("down"))) {
            direction = "up";
        }
        if (key==Input.KEY_DOWN&& (!direction.equals("up"))) {
            direction = "down";
        }

    }
    private void generateApple() throws SlickException {

        for (int i = 0; i < 1; i++) {
            Food food= new Food();
            this.actors.add(food);
//            this.food.add(food);
//                      this.falcon.addCollisionPartner(fighter);
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
