package at.bha.games.mygame;

import at.bha.games.rectanglesandco.RectanglesAndCo;
import org.newdawn.slick.*;
import org.newdawn.slick.Sound;
import java.util.ArrayList;
import java.util.Random;

public class Game extends BasicGame {
    private Image background;
    private ArrayList<Actor> actors;
    private ArrayList<Fighter> fighters;
    private Falcon falcon;
    private Sound sound;

    public Game(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        background = new Image("myfiles/galaxy_bg.jpg");
        this.actors = new ArrayList<>();
        this.fighters = new ArrayList<>();
        Random random = new Random();
        Falcon falcon = new Falcon();
        this.falcon = falcon;
        this.actors.add(falcon);
        sound = new Sound("myfiles/shotgun.wav");
        for (int i = 0; i <5; i++) {
            Fighter fighter = new Fighter(random.nextInt(720)+20, random.nextInt(600) - 600, 20);
            this.actors.add(fighter);
            this.fighters.add(fighter);
            this.falcon.addCollisionPartner(fighter);
        }
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        for (Actor actor : this.actors) {
            actor.update(gameContainer, delta);
        }
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        background.draw(0,0,800,600);
        for (Actor actor : this.actors) {
            actor.render(graphics);
        }
    }

    @Override
    public void keyPressed(int key, char c) {
        if (key == Input.KEY_SPACE) {
            sound.play();
            Bullet bullet = new Bullet(this.falcon.getX(), this.falcon.getY());
            for (Fighter fighter: this.fighters) {
                fighter.addCollisionPartner(bullet);
            }
            this.actors.add(bullet);
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
