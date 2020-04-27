package at.bha.games.snowworld;

import at.bha.games.rectanglesandco.Direction;
import at.bha.games.rectanglesandco.Rectangle;
import at.bha.games.rectanglesandco.RectanglesAndCo;
import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.Random;

public class SnowWorld extends BasicGame {
    private ArrayList<Actor> actors;

    public SnowWorld(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.actors = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 50; i++) {
            Snowflake largeSnowflake = new Snowflake(random.nextInt(800), random.nextInt(600)-600, 15, 5);
            this.actors.add(largeSnowflake);
            Snowflake mediumSnowflake = new Snowflake(random.nextInt(800), random.nextInt(600)-600, 10, 10);
            this.actors.add(mediumSnowflake);
            Snowflake smallSnowflake = new Snowflake(random.nextInt(800), random.nextInt(600)-600, 5, 15);
            this.actors.add(smallSnowflake);
        }
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        for (Actor actor : this.actors) {
            actor.update(delta);
        }
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        for (Actor actor : this.actors) {
            actor.render(graphics);
        }
    }

    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new SnowWorld("Snow World"));
            container.setDisplayMode(800, 600, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
