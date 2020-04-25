package at.bha.games.myfirstgame;

import org.newdawn.slick.Graphics;

public class OvalCircle {
    private float x;
    private float y;
    private int width;
    private int height;
    private float speed;
    private Direction direction;

    public OvalCircle(float x, float y, int width, int height, float speed, Direction direction) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.speed = speed;
        this.direction = direction;

    }

    public void render(Graphics graphics) {
        graphics.drawOval(this.x, this.y, this.width, this.height);
    }

    public void update(int delta) {

        switch (direction){
            case RIGHT:
                this.x += (float) delta / speed;
                if (x > 700) {
                    this.direction = Direction.LEFT;}
                    break;
            case LEFT:
                this.x -= (float) delta / speed;
                if (this.x < 50) {
                    this.direction = Direction.RIGHT;
                }
                break;
            case DOWN:
                this.y += (float) delta / speed;
                if (y > 500) {
                    this.direction = Direction.UP;
                }
                break;
            case UP:
                this.y -= (float) delta / speed;
                if (this.y < 50) {
                    this.direction = Direction.DOWN;
                }
        }
//        if (this.direction == Direction.RIGHT) {
//            this.x += (float) delta / speed;
//            if (x > 700) {
//                this.direction = Direction.LEFT;
//            }
//        } else  {
//            this.x -= (float) delta / speed;
//            if (this.x < 50) {
//                this.direction = Direction.RIGHT;
//            }
//        }
//        else if (this.direction == Direction.DOWN) {
//            this.y += (float) delta / speed;
//            if (y > 500) {
//                this.direction = Direction.UP;
//            }
//        } else if (this.direction == Direction.UP) {
//            this.y -= (float) delta / speed;
//            if (this.y < 50) {
//                this.direction = Direction.DOWN;
//            }
//        }
    }

}


