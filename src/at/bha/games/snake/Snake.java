package at.bha.games.snake;

import org.newdawn.slick.*;
import org.newdawn.slick.tests.AnimationTest;

public class Snake extends BasicGame {

    public Snake(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {

    }

    @Override
    public void update(GameContainer gameContainer, int i) throws SlickException {

    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {

    }
    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new Snake("Snake Game"));
            container.setDisplayMode(800,600,false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
