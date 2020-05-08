package at.bha.games.mygame;

import at.bha.games.rectanglesandco.RectanglesAndCo;
import org.newdawn.slick.*;
import org.newdawn.slick.Sound;
import org.newdawn.slick.AngelCodeFont;
import java.util.ArrayList;
import java.util.Random;

public class Game extends BasicGame {
    private Image background;
    private ArrayList<Actor> actors;
    private ArrayList<Fighter> fighters;
    private Falcon falcon;
    private Sound sound;
    private AngelCodeFont font;
    private AngelCodeFont font2;
    private int counter = 0;

    public Game(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        background = new Image("myfiles/galaxy_bg.jpg");
        sound = new Sound("myfiles/shotgun.wav");
        Random random = new Random();
        Falcon falcon = new Falcon();
        this.actors = new ArrayList<>();
        this.fighters = new ArrayList<>();
        this.falcon = falcon;
        this.actors.add(falcon);

        font = new AngelCodeFont("testdata/demo2.fnt", "testdata/demo2_00.tga");
        font2 = new AngelCodeFont("testdata/hiero.fnt", "testdata/hiero.png");
        for (int i = 0; i < 5; i++) {
            Fighter fighter = new Fighter(random.nextInt(720) + 20, random.nextInt(600) - 600, 20);
            this.actors.add(fighter);
            this.fighters.add(fighter);
            this.falcon.addCollisionPartner(fighter);
        }
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        for (Actor actor : this.actors) {
            actor.update(gameContainer, delta);

            if (actor instanceof Fighter) {
                int speed = 20;

                if (counter >= 10 && counter < 30) {
                    speed = 15;
                } else if (counter >= 30) {
                    speed = 10;
                }
                ((Fighter) actor).setSpeed(speed);
            }
        }
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        background.draw(0, 0, 800, 600);
        if (falcon.getCounterLives() > 0) {
        counter = 0;
            for (Actor actor : this.actors) {
                if (actor instanceof Fighter) {
                    Fighter fighter = (Fighter) actor;
                    counter += fighter.getHitCount();
                }
                actor.render(graphics);
            }
        }else{
            font2.drawString(250, 200, "GAME OVER ! ! ! ");
        }
        font.drawString(10, 520, "Points:  " + counter, Color.yellow);
        font.drawString(10, 560, "Lives:  " + falcon.getCounterLives(), Color.yellow);
    }

    @Override
    public void keyPressed(int key, char c) {
        if (key == Input.KEY_SPACE) {

            Bullet bullet = new Bullet(this.falcon.getX(), this.falcon.getY());
            for (Fighter fighter : this.fighters) {
                fighter.addCollisionPartner(bullet);
            }
            this.actors.add(bullet);
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
