package at.bha.games.snake;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public interface Actor {
    public void render( Graphics graphics);
    public void update(int delta);
}
