package at.bha.games.mygame;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;

public class Bullet implements Actor {
    private float x, y;
    private float speed;
    private Shape collisionShape;

    public Bullet(float x, float y) {
        this.x = x;
        this.y = y;
        this.collisionShape = new Circle (this.x, this.y,5);
    }

    @Override
    public void render(Graphics graphics) {
        graphics.fillOval(this.x, this.y, 10, 10);
        graphics.setColor(Color.green);
//        graphics.draw(this.collisionShape);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        this.y--;

        this.collisionShape.setCenterX(this.x+5);
        this.collisionShape.setCenterY(this.y+5);

    }

    public Shape getCollisionShape() {
        return collisionShape;
    }
}
