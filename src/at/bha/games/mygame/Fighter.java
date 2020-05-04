package at.bha.games.mygame;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

import java.util.ArrayList;
import java.util.List;

public class Fighter implements Actor {
    private Image fighter;
    private float x, y;
    private float speed;
    private Shape collisionShape;
    private List<Bullet> bullets;
    private boolean isHit = false;
    private int counter;


    public Fighter(float x, float y, float speed) throws SlickException {
        Image tmp = new Image("testdata/fighter.png");
        this.fighter = tmp.getScaledCopy(60, 60);
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.collisionShape = new Rectangle(this.x, this.y, 54, 60);
        this.bullets = new ArrayList<Bullet>();
    }

    @Override
    public void render(Graphics graphics) {
        if (!this.isHit) {
            fighter.draw(this.x, this.y);
            graphics.draw(this.collisionShape);
            graphics.setColor(Color.blue);
        }
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {

        isHit();

        this.y += (float) delta / this.speed;
        if (this.y > 600) {
            this.y = 0;
        }

        this.collisionShape.setCenterX(this.x + 28);
        this.collisionShape.setCenterY(this.y + 28);

    }

    public Shape getCollisionShape() {
        return collisionShape;
    }

    public void addCollisionPartner(Bullet bullet) {
        this.bullets.add(bullet);
    }

    public void countHits() {
        this.counter++;
        System.out.println(this.counter);
    }

    public boolean isHit() {
        for (Bullet bullet : bullets) {
            if (!this.isHit && this.collisionShape.intersects(bullet.getCollisionShape())) {
                System.out.println("Collision with Bullet");
//counter
                countHits();
                this.isHit = true;
            }

        }return isHit;

    }

}


