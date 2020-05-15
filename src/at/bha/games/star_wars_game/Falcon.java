package at.bha.games.star_wars_game;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Falcon implements IActor {

    private Image falcon;
    private float x, y;
    private Shape collisionShape;
    private List<Fighter> fighters;
    private boolean isHit;
    private int counterLives;
    private Font font2;
    Random random = new Random();

    public Falcon() throws SlickException {
        Image tmp = new Image("myfiles/falcon.png");
        this.falcon = tmp.getScaledCopy(100, 120);
        this.x = 300;
        this.y = 400;
        this.collisionShape = new Rectangle(this.x, this.y, 100, 120);
        this.fighters = new ArrayList<Fighter>();
        this.counterLives = 3;
        this.isHit = false;
    }

    @Override
    public void render(Graphics graphics) {
        if (!isHit) {
            falcon.draw(this.x, this.y);
        } else {
            falcon.draw();
        }
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {

        // If the fighter touches the Falcon, it will move to starting position
        for (Fighter fighter : fighters) {
            if (!fighter.isHit() && this.collisionShape.intersects(fighter.getCollisionShape()) && getCounterLives() > 0) {
                counterLives--;
                this.x = 300;
                this.y = 400;
            }
        }

        //If the Falcon moves back to starting position and a fighter happens to be there
        for (Fighter fighter : fighters) {
            if (!fighter.isHit() && this.collisionShape.intersects(fighter.getCollisionShape())) {
                fighter.setY(random.nextInt(600) - 600);
            }
        }

        //If the fighter reaches the bottom of the screen counterLives--
        for (Fighter fighter : fighters) {
            if (fighter.getY() > 550 && getCounterLives() > 0) {
                fighter.setY(random.nextInt(600) - 600);
                this.y = random.nextInt(600) - 600;
                counterLives--;
            }
        }

        if (gameContainer.getInput().isKeyDown(Input.KEY_LEFT)) {
            if (this.x > -30) {
                this.x--;
            }
        }
        if (gameContainer.getInput().isKeyDown(Input.KEY_RIGHT)) {
            if (this.x < 730) {
                this.x++;
            }
        }
        if (gameContainer.getInput().isKeyDown(Input.KEY_UP)) {
            if (this.y > -10) {
                this.y--;
            }

        }
        if (gameContainer.getInput().isKeyDown(Input.KEY_DOWN)) {
            if (this.y < 550) {
                this.y++;
            }
        }
        this.collisionShape.setCenterX(this.x + 50);
        this.collisionShape.setCenterY(this.y + 60);

    }

    public float getX() {
        return x + 44;
    }

    public float getY() {
        return y - 10;
    }

    public void addCollisionPartner(Fighter fighter) {
        this.fighters.add(fighter);
    }

    public int getCounterLives() {
        return counterLives;
    }

    public void setCounterLives(int counterLives) {
        this.counterLives = counterLives;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }
}
