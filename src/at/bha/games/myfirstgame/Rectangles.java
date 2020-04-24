package at.bha.games.myfirstgame;

import org.newdawn.slick.*;
import org.newdawn.slick.tests.AnimationTest;

public class Rectangles extends BasicGame {
    private float x;
    private float y;
    private float speedX;
    private float speedY;

    public Rectangles(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.x = speedX;
        this.y = speedY;
        this.speedX = 10.0f;
        this.speedY = 30.0f;
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {

        this.x += (float) delta / speedX;
        this.y += (float) delta / speedY;
        if (this.x > 800) {
            x = 0;
            y = 0;
        }
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        graphics.drawString("Ready, Player Number One?", 50, 50);
        graphics.drawRect(this.x, this.y, 100, 20);
    }

    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new Rectangles("Rectangles"));
            container.setDisplayMode(800, 600, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
