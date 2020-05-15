package at.bha.games.star_wars_game;

import org.newdawn.slick.*;
import org.newdawn.slick.Sound;
import org.newdawn.slick.AngelCodeFont;
import org.newdawn.slick.GameContainer;

import java.util.ArrayList;
import java.util.Random;

public class Game extends BasicGame {
    private Image background;
    private Image explosion;
    private ArrayList<IActor> actors;
    private ArrayList<Fighter> fighters;
    private Falcon falcon;
    private Sound shotgunSound;
    private Sound backgroundSound;
    private AngelCodeFont font;
    private AngelCodeFont font2;
    private Random random;
    private int highScore;

    public Game(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        background = new Image("myfiles/galaxy_bg.jpg");
        backgroundSound = new Sound("myfiles/starwars_sound.wav");
        shotgunSound = new Sound("myfiles/shotgun.wav");
        Falcon falcon = new Falcon();
        this.random = new Random();
        this.actors = new ArrayList<>();
        this.fighters = new ArrayList<>();
        this.falcon = falcon;
        this.actors.add(falcon);
        this.highScore =0;
        this.explosion = explosion;
        generateFighters();
        backgroundSound.loop();
        font = new AngelCodeFont("testdata/demo2.fnt", "testdata/demo2_00.tga");
        font2 = new AngelCodeFont("testdata/hiero.fnt", "testdata/hiero.png");
    }

    private void generateFighters() throws SlickException {

        for (int i = 0; i < 5; i++) {
            Fighter fighter = new Fighter(this.random.nextInt(720) + 20, this.random.nextInt(600) - 600, 20);
            this.actors.add(fighter);
            this.fighters.add(fighter);
            this.falcon.addCollisionPartner(fighter);
        }
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        for (IActor IActor : this.actors) {
            IActor.update(gameContainer, delta);

            if (IActor instanceof Fighter) {
                int speed = 20;
                if (this.getCounter() >= 10 && this.getCounter() < 30) {
                    speed = 15;
                } else if (this.getCounter() >= 30) {
                    speed = 10;
                }
                ((Fighter) IActor).setSpeed(speed);
            }
        }
    }

    private int getCounter(){
        int count = 0;
        for (Fighter fighter : this.fighters) {
            count += fighter.getHitCount();
        }
        return count;
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        background.draw(0, 0, 800, 600);
        if (falcon.getCounterLives() > 0) {
            for (IActor actor : this.actors)
                actor.render(graphics);
        } else {
            font2.drawString(250, 200, "GAME OVER ! ! ! ");
            font.drawString(350, 300, "Play again", Color.yellow);
            font.drawString(400, 350, "Exit", Color.yellow);

            if (this.getCounter() >= this.highScore) {
                this.highScore = this.getCounter();
                font.drawString(300, 560, "New high score: " + this.highScore, Color.yellow);
            } else {
                font.drawString(300, 560, "High score: " + this.highScore, Color.yellow);
            }
        }
        font.drawString(10, 520, "Points:  " + this.getCounter(), Color.yellow);
        font.drawString(10, 560, "Lives:  " + falcon.getCounterLives(), Color.yellow);
    }

    @Override
    public void mousePressed(int button, int x, int y) {
        if (button == Input.MOUSE_LEFT_BUTTON) {
            if (falcon.getCounterLives() == 0 && x > 400 && x < 446 && y > 354 && y < 380) {
                System.out.println("Exit");
                System.exit(0);
            } else if (falcon.getCounterLives() == 0 && x > 350 && x < 476 && y > 304 && y < 334) {
                try {
                    resetGame();
                } catch (SlickException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private void resetGame() throws SlickException {
        System.out.println("Play again");
        // Reset Falcon
        falcon.setX(300);
        falcon.setY(400);
        falcon.setCounterLives(3);

        // Reset Counter
       // this.counter = 0;
        for (Fighter fighter : this.fighters) {
            for (int i = 0; i < fighters.size(); i++) {
                fighters.get(i).setHitCount(0);
            }
        }

        // reset the 5 Fighters
        for (Fighter fighter : this.fighters) {
            for (int i = 0; i < fighters.size(); i++) {
                fighters.get(i).setY(random.nextInt(600) - 600);
                fighters.get(i).setX(random.nextInt(720) + 20);
            }
        }
    }

    @Override
    public void keyPressed(int key, char c) {
        if (key == Input.KEY_SPACE) {

            Bullet bullet = new Bullet(this.falcon.getX(), this.falcon.getY());
            for (Fighter fighter : this.fighters) {
                fighter.addCollisionPartner(bullet);
            }
            this.actors.add(bullet);
            shotgunSound.play(7.0f,1.0f);
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
