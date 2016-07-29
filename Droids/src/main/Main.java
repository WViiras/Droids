package main;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Main extends BasicGame {

	List<Droid> droids;
	Controller cont;
	public static final Debug d = new Debug();

	public Main(String title) {
		super(title);
	}

	public static void main(String[] args) {

		int width = 800;
		int height = 600;
		try {
			AppGameContainer agc = new AppGameContainer(new Main("Droids"));
			agc.setDisplayMode(width, height, false);
//			agc.setTargetFrameRate(30);
			agc.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void init(GameContainer container) throws SlickException {

		droids = new ArrayList<Droid>();

		cont = new Controller(droids);

		droids.add(new Droid(200, 200));
		droids.add(new Droid(370, 370));

	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {

		cont.render(gc, g);

		for (Droid droid : droids) {
			droid.render(gc, g);
		}

		d.draw(g);
	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException {

		cont.update(gc, delta);

		for (Droid droid : droids) {
			droid.update(gc, delta);
		}
	}

}
