package at.bha.games.snowworld;

import at.bha.games.myfirstgame.Oval;
import org.newdawn.slick.Graphics;

import java.util.Random;

public class Snowflake implements Actor {
    private float x;
    private float y;
    private int diameter;
    private float speed;

    public Snowflake(float x, float y, int diameter, float speed) {
        this.x = x;
        this.y = y;
        this.diameter = diameter;
        this.speed = speed;
    }

    @Override
    public void render(Graphics graphics) {
graphics.fillOval(this.x, this.y, this.diameter,this.diameter);

    }

    @Override
    public void update(int delta) {
        this.y += (float) delta / this.speed;
        if (this.y > 600) {
            this.y = 0;
        }
    }
}
