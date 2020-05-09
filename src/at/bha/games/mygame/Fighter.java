package at.bha.games.mygame;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Fighter implements IActor {
    private Image fighter;
    private Image explosion;
    private float x, y;
    private float speed;
    private Shape collisionShape;
    private List<Bullet> bullets;
    private boolean isHit = false;
    private int counter;
    Random random = new Random();

    public Fighter(float x, float y, float speed) throws SlickException {
        Image tmp = new Image("myfiles/fighter_new.png");

        this.fighter = tmp.getScaledCopy(60, 60);
        Image tmp2 = new Image("myfiles/explosion.png");
        this.explosion = tmp.getScaledCopy(60,60);
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
//            graphics.draw(this.collisionShape);
//            graphics.setColor(Color.blue);
        }
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {

        this.y += (float) delta / this.speed;
        if (this.y > 600) {
            this.y = 0;
        }

        isHit();
        this.collisionShape.setCenterX(this.x + 29);
        this.collisionShape.setCenterY(this.y + 28);
        isHit = false;
    }

    public Shape getCollisionShape() {
        return collisionShape;
    }

    public void addCollisionPartner(Bullet bullet) {
        this.bullets.add(bullet);
    }

    public boolean isHit() {

        for (Bullet bullet : bullets) {
            if (!this.isHit && this.collisionShape.intersects(bullet.getCollisionShape()) && bullet.getY() > 5) {
//TODO try to show an image of an explosion, whenever a fighter is hit
//                explosion.draw(this.x,this.y);
//                explosion.drawFlash(this.x,this.y);

                counter++;
                this.isHit = true;
                this.y = random.nextInt(600) - 600;
                this.x = random.nextInt(720) + 20;
            }
        }
        return isHit;
    }

    public int getHitCount() {
        return counter;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getY() {
        return y;
    }

    public void setX(float x) {
        this.x = x;
    }
}


