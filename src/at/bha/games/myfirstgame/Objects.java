package at.bha.games.myfirstgame;

import org.newdawn.slick.*;

public class Objects extends BasicGame {

    //    private Oval oval1;
//    private Oval circle1;
    private OvalCircle oval1;
    private OvalCircle oval2;
    private OvalCircle circle1;
    private OvalCircle circle2;
    private Rectangle rectangle1;
    private Rectangle rectangle2;


    public Objects(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {

        this.oval1 = new OvalCircle(50, 50, 50, 20, 7, Direction.RIGHT);
        this.oval2= new OvalCircle(700, 50, 50, 20, 7, Direction.LEFT);
        this.circle1 = new OvalCircle(50, 50, 40, 40, 5, Direction.DOWN);
        this.circle2 = new OvalCircle(50,150,15,15,3,Direction.UP);
        this.rectangle1 = new Rectangle(100, 100, 100, 100, 3, Direction.RIGHT);
        this.rectangle2 = new Rectangle(100, 300, 10, 10, 2, Direction.LEFT);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        this.oval1.update(delta);
        this.oval2.update(delta);
        this.circle1.update(delta);
        this.circle2.update(delta);
        this.rectangle1.update(delta);
        this.rectangle2.update(delta);
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        this.oval1.render(graphics);
        this.oval2.render(graphics);
        this.circle1.render(graphics);
        this.circle2.render(graphics);
        this.rectangle1.render(graphics);
        this.rectangle2.render(graphics);
    }

    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new Objects("Objects"));
            container.setDisplayMode(800, 600, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
