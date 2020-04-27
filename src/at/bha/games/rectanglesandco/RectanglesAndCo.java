package at.bha.games.rectanglesandco;

import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
Aufgabe - Rectangles & Co
Programmiere das Beispiel aus den Videos nach!
Mache folgende Adaptierungen

Es gibt 10 Rectangles
Es gibt 10 Circles
Es gibt 10 Eclipsen (müssen wieder hereinfliegen)
Baue folgende Objekte dazu:

Baue die Rectangles so um, damit man im Konstruktor angeben kann ob sie von links nach rechts oder umgekehrt fliegen.
Die Circles sollen im laufe des Fluges wachsen - immer größer werden (der Durchmesser wächst)
 */
public class RectanglesAndCo extends BasicGame {
    private List<Actor> actors;
    private Rocket rocket;

    public RectanglesAndCo(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.actors = new ArrayList<>();

        Rocket rocket = new Rocket();
        this.rocket = rocket;
        this.actors.add(rocket);

        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            Rectangle rectangle = new Rectangle(random.nextInt(600), random.nextInt(600), random.nextInt(50), Direction.RIGHT);
            this.actors.add(rectangle);
        }
        for (int i = 0; i < 10; i++) {
            Circle circle = new Circle();
            this.actors.add(circle);
        }
        for (int i = 0; i < 10; i++) {
            Ellipse ellipse = new Ellipse(random.nextInt(600), random.nextInt(600));
            this.actors.add(ellipse);
        }

    }


    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        for (Actor actor : this.actors) {
            actor.update(gameContainer, delta);
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
        if (key == Input.KEY_SPACE) {
            Cannonball cannonball = new Cannonball(this.rocket.getX(), this.rocket.getY());
            this.actors.add(cannonball);

        }
    }

    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new RectanglesAndCo("Rectangles & Co"));
            container.setDisplayMode(800, 600, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
