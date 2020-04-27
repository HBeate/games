package at.bha.games.myfirstgame;

import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ObjectsList extends BasicGame {
   //Kreise und Elipsen werden mit OvalCirlce erstellt
    private List<Oval> ovals;
    private List<Rectangle> rectangles;


    public ObjectsList(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
      this.ovals = new ArrayList<>();
        this.rectangles = new ArrayList<>();

        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            Rectangle rectangle = new Rectangle(random.nextInt(700), random.nextInt(400),
                    50, 50, random.nextInt(50), Direction.RIGHT);
            rectangles.add(rectangle);
        }
        for (int i = 0; i < 30; i++) {
            /*Ich hatte zuerst alle Werte random, auch die Grössen
               Damit Breite und Höhe beim Kreis identisch sind
              int randomCircle = random.nextInt(100); */
            Oval circle = new Oval(random.nextInt(700), random.nextInt(500),
                    30, 30, random.nextInt(50), Direction.DOWN);
            ovals.add(circle);
        }
        for (int i = 0; i < 10; i++) {
            Oval circle2 = new Oval(random.nextInt(700), random.nextInt(500),
                    50, 20, random.nextInt(50), Direction.RIGHT);
            ovals.add(circle2);
        }

    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {


        for (Rectangle rectangle : this.rectangles) {
            rectangle.update(delta);
        }
        for (Oval oval : this.ovals) {
            oval.update(delta);
        }
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {


        for (Rectangle rectangle : this.rectangles) {
            rectangle.render(graphics);
        }
        for (Oval oval : this.ovals) {
            oval.render(graphics);
        }
    }

    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new ObjectsList("Objects"));
            container.setDisplayMode(800, 600, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
