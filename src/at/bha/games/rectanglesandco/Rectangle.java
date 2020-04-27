package at.bha.games.rectanglesandco;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.svg.Gradient;

public class Rectangle implements Actor {
    private enum DIRECTION {RIGHT, LEFT, UP, DOWN}

    private float x;
    private float y;
    private float speed;
    private Direction direction;

    public Rectangle(float x, float y, float speed, Direction direction) {
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    public void render(Graphics graphics) {
        graphics.drawRect(this.x, this.y, 10, 10);


    }

    public void update(GameContainer gameContainer, int delta) {
        if (direction == Direction.RIGHT) {
            this.x += (float) delta / this.speed;
            if (this.x > 800) {
                this.x = 0;
            }
        } else {
            this.x -= (float) delta / speed;

            if (this.x < 10) {
                this.x = 800;
            }
        }

    }
}


