package at.bha.games.mygame;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import java.util.ArrayList;
import java.util.List;

public class Falcon implements Actor {

    private Image falcon;
    private float x, y;
    private Shape collisionShape;
    private List<Fighter> fighters;
    private int counter;


    public Falcon() throws SlickException {
        Image tmp = new Image("myfiles/falcon.png");
        this.falcon = tmp.getScaledCopy(100, 120);
        this.x = 300;
        this.y = 400;
        this.collisionShape = new Rectangle(this.x, this.y, 100, 120);
        this.fighters = new ArrayList<Fighter>();
        this.counter = 0;
    }

    @Override
    public void render(Graphics graphics) {

        falcon.draw(this.x, this.y);
//        graphics.setColor(new Color(50, 250, 50));
//        graphics.draw(this.collisionShape);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        for (Fighter fighter : fighters) {
            if (!fighter.isHit() && this.collisionShape.intersects(fighter.getCollisionShape())) {
                System.out.println("Collision Falcon with Fighter");
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
}
