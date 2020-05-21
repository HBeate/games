package at.bha.games.snake;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public interface Actor {
    public void render(GameContainer gameContainer, Graphics graphics);
    public void update(GameContainer gameContainer, int delta);
}
