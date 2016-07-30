package main;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import behaviourTree.*;

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
//			agc.setTargetFrameRate(60);
//			agc.setMinimumLogicUpdateInterval(2000);
//			agc.setMaximumLogicUpdateInterval(5000);
//			agc.setUpdateOnlyWhenVisible(false);
			agc.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void init(GameContainer gc) throws SlickException {

		droids = new ArrayList<Droid>();

		cont = new Controller(droids);

		Droid d1 = new Droid(200, 200);

//		d1.setRoutine(new MoveTo(100, 100));
		d1.setRoutine(new Repeat(new Wander(gc)));

		droids.add(d1);

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
