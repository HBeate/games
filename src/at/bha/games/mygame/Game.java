package at.bha.games.mygame;

import org.newdawn.slick.*;
import org.newdawn.slick.Sound;
import org.newdawn.slick.AngelCodeFont;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

import java.util.ArrayList;
import java.util.Random;

public class Game extends BasicGame {
    private Image background;
    private ArrayList<IActor> IActors;
    private ArrayList<Fighter> fighters;
    private Falcon falcon;
    private Sound sound;
    private AngelCodeFont font;
    private AngelCodeFont font2;
    private int counter;
    private Shape shapeExit;
    private Shape shapePlayAgain;
    private Random random;

    public Game(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        background = new Image("myfiles/galaxy_bg.jpg");
        sound = new Sound("myfiles/shotgun.wav");
        Random random = new Random();
        Falcon falcon = new Falcon();
        this.IActors = new ArrayList<>();
        this.fighters = new ArrayList<>();
        this.falcon = falcon;
        this.IActors.add(falcon);
        this.shapePlayAgain = new Rectangle(350, 304, 126, 30);
        this.shapeExit = new Rectangle(400, 354, 46, 26);
        this.counter= 0;

        font = new AngelCodeFont("testdata/demo2.fnt", "testdata/demo2_00.tga");
        font2 = new AngelCodeFont("testdata/hiero.fnt", "testdata/hiero.png");
        for (int i = 0; i < 5; i++) {
            Fighter fighter = new Fighter(random.nextInt(720) + 20, random.nextInt(600) - 600, 20);
            this.IActors.add(fighter);
            this.fighters.add(fighter);
            this.falcon.addCollisionPartner(fighter);
        }
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        for (IActor IActor : this.IActors) {
            IActor.update(gameContainer, delta);

            if (IActor instanceof Fighter) {
                int speed = 20;

                if (counter >= 10 && counter < 30) {
                    speed = 15;
                } else if (counter >= 30) {
                    speed = 10;
                }
                ((Fighter) IActor).setSpeed(speed);
            }
        }
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        background.draw(0, 0, 800, 600);
        if (falcon.getCounterLives() > 0) {
            counter = 0;
            for (IActor IActor : this.IActors) {
                if (IActor instanceof Fighter) {
                    Fighter fighter = (Fighter) IActor;
                    counter += fighter.getHitCount();
                }
                IActor.render(graphics);
            }
        } else {
            font2.drawString(250, 200, "GAME OVER ! ! ! ");
            font.drawString(350, 300, "Play again", Color.yellow);
            font.drawString(400, 350, "Exit", Color.yellow);
            graphics.draw(this.shapeExit);
            graphics.draw(this.shapePlayAgain);

        }
        font.drawString(10, 520, "Points:  " + counter, Color.yellow);
        font.drawString(10, 560, "Lives:  " + falcon.getCounterLives(), Color.yellow);

    }

    @Override
    public void mousePressed(int button, int x, int y) {
        if (button == Input.MOUSE_LEFT_BUTTON) {
            if (falcon.getCounterLives() == 0 && x > 400 && x < 446 && y > 354 && y < 380) {
                System.out.println("Exit");
                System.exit(0);
            } else if (falcon.getCounterLives() == 0 && x > 350 && x < 476 && y > 304 && y < 334)
                System.out.println("Play again");
            falcon.setX(300);
            falcon.setY(400);
            falcon.setCounterLives(3);
            counter = 0;
            //TODO reset the game to PlayAgain
//            for (int i = 0; i <5 ; i++) {
//                fighters.get(i).setY(random.nextInt(600) - 600);
//                fighters.get(i).setX(random.nextInt(720) + 20);
//            }

        }
    }

    @Override
    public void keyPressed(int key, char c) {
        if (key == Input.KEY_SPACE) {

            Bullet bullet = new Bullet(this.falcon.getX(), this.falcon.getY());
            for (Fighter fighter : this.fighters) {
                fighter.addCollisionPartner(bullet);
            }
            this.IActors.add(bullet);
            sound.play();
        }
    }

    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new Game("Mein Spiel - wie immer es heissen wird..."));
            container.setDisplayMode(800, 600, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
