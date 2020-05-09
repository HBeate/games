package at.bha.games.mygame;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public interface IActor {
    public void render(Graphics graphics);
    public void update(GameContainer gameContainer, int delta);
}
