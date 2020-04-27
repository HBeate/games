package at.bha.games.rectanglesandco;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import java.util.Random;

public class Circle implements  Actor {
private float x;
private float y;
private float speed;
private float diameter;
private float increaseDiameter;

    public Circle() {
       Random random = new Random();
       this.x = random.nextInt(800);
       this.y = random.nextInt(600);
       this.speed = random.nextInt (40)+10;
       this.diameter = random.nextInt(20)+20;

    }

    public void render(Graphics graphics) {
        graphics.drawOval(this.x, this.y, this.diameter, this.diameter);


    }

    public void update(GameContainer gameContainer, int delta) {
        this.y += (float) delta / this.speed;
        this.diameter = this.diameter + 0.1f;
        if (this.y > 600) {
            this.y = 0;
            diameter = 0;

        }
    }
}
