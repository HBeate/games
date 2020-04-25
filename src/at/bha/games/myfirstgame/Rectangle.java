package at.bha.games.myfirstgame;

import org.newdawn.slick.Graphics;

public class Rectangle {

    private float x;
    private float y;
    private int width;
    private int height;
    private float speed;
    private Direction direction;

    public Rectangle(float x, float y, int width, int height, float speed, Direction direction) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
    }

    //Rechteck zeichnet sich selber. Alles was er braucht ist das Graphics Objekt
    // (wichtig: das Graphics von org.newdawn.slick verwenden)
    public void render(Graphics graphics) {
        graphics.drawRect(this.x, this.y, this.width, this.height);

    }

    public void update(int delta) {

        if (direction == Direction.RIGHT) {
            this.x += (float) delta / this.speed;
            if (this.x > 600) {
                direction = Direction.DOWN;
            }
        }else if (direction == Direction.DOWN){
            this.y += (float) delta / this.speed;
            if(this.y > 400){
                direction = Direction.LEFT;
            }
        }else if (direction == Direction.LEFT){
            this.x -= (float) delta / this.speed;
            if (this.x <100){
                direction = Direction.UP;
            }
        }else {
            this.y -= (float) delta / this.speed;
            if (this.y <100){
                direction = Direction.RIGHT;
            }
        }
    }
}
