package at.bha.games.myfirstgame;

import org.newdawn.slick.*;

public class Objects extends BasicGame {

    private enum DIRECTION {RIGHT, LEFT, UP, DOWN}

    private float xOval;
    private float yOval;
    private DIRECTION directionOval;
    private float xCircle;
    private float yCircle;
    private DIRECTION directionCircle;
    private float xRectangle;
    private float yRectangle;
    private float speed;
    private DIRECTION directionRectangle;


    public Objects(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.xOval = 50;
        this.yOval = 50;
        this.directionOval = DIRECTION.RIGHT;

        this.xCircle = 50;
        this.yCircle = 50;
        this.directionCircle = DIRECTION.DOWN;

        this.xRectangle = 100;
        this.yRectangle = 100;
        this.directionRectangle = DIRECTION.RIGHT;
        this.speed = 2.0f;
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        if (this.directionOval == DIRECTION.RIGHT) {
            this.xOval += (float) delta / this.speed;
            if (xOval > 700) {
                this.directionOval = DIRECTION.LEFT;
            }
        } else {
            this.xOval -= (float) delta / this.speed;
            if (xOval < 50) {
                this.directionOval = DIRECTION.RIGHT;
            }

        }
        if (this.directionCircle == DIRECTION.DOWN) {
            this.yCircle += (float) delta / speed;
            if (this.yCircle > 500) {
                this.directionCircle = DIRECTION.UP;
            }
        } else {
            this.yCircle -= (float) delta / speed;
            if (yCircle < 50) {
                this.directionCircle = DIRECTION.DOWN;
            }
        }
        if (this.directionRectangle == DIRECTION.RIGHT) {
            this.xRectangle += (float) delta / speed;
            if (this.xRectangle > 600) {
                this.directionRectangle = DIRECTION.DOWN;
            }
        } else if (this.directionRectangle == DIRECTION.DOWN) {
            this.yRectangle += (float) delta / speed;
            if (this.yRectangle > 400) {
                this.directionRectangle = DIRECTION.LEFT;
            }
        } else if (this.directionRectangle == DIRECTION.LEFT) {
            this.xRectangle -= (float) delta / speed;
            if (this.xRectangle < 100) {
                this.directionRectangle = DIRECTION.UP;
            }
        } else {
            this.yRectangle -= (float) delta / speed;
            if (yRectangle < 100) {
                this.directionRectangle = DIRECTION.RIGHT;
            }
        }
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        graphics.drawOval(xOval, yOval, 50, 20);
        graphics.drawRect(xRectangle, yRectangle, 100, 100);
        graphics.drawOval(xCircle, yCircle, 40, 40);
    }

    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new Objects("Objects"));
            container.setDisplayMode(800, 600, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
