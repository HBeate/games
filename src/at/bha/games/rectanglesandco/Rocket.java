package at.bha.games.rectanglesandco;

import org.newdawn.slick.*;

public class Rocket implements Actor {
    private Image rocket;
    private float x, y;


    public Rocket() throws SlickException {
        Image tmp = new Image("testdata/rocket.png");
        this.rocket = tmp.getScaledCopy(120, 120);
        this.x = 100;
        this.y = 100;
    }

    @Override
    public void render(Graphics graphics) {
        this.rocket.draw(this.x, this.y);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        if (gameContainer.getInput().isKeyDown(Input.KEY_RIGHT))
            this.x++;
        if (gameContainer.getInput().isKeyDown(Input.KEY_LEFT))
            this.x--;
        if (gameContainer.getInput().isKeyDown(Input.KEY_UP))
            this.y--;
        if (gameContainer.getInput().isKeyDown(Input.KEY_DOWN))
            this.y++;

    }

    public float getX() {
        return x+52.5f;
    }

    public float getY() {
        return y-5;
    }
}

