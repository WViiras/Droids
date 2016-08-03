package main;

import java.util.Random;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import behaviourTree.*;

public class Main extends BasicGame {

	Board board;
	Controller cont;
	public static final Debug d = new Debug();

	public Main(String title) {
		super(title);
	}

	public static void main(String[] args) {

		int width = 1000;
		int height = 700;
		try {
			AppGameContainer agc = new AppGameContainer(new Main("Droids"));
			agc.setDisplayMode(width, height, false);
			agc.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void init(GameContainer gc) throws SlickException {

		this.board = new Board(gc);

		this.cont = new Controller(board);

		Random rand = new Random();

		for (int i = 0; i < 4; i++) {
			double randWidth = rand.nextDouble() * board.width;
			double randHeight = rand.nextDouble() * board.height;

			board.addDroid(new Droid(randWidth, randHeight));
		}

		for (Droid droid : board.getDroids()) {
			droid.setRoutine(new Repeat(new Wander(board)));
		}

		Droid player = new Player(board.width / 2, board.height / 2);
		board.addDroid(player);
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {

		cont.render(gc, g);

		for (Droid droid : board.getDroids()) {
			droid.render(gc, g);
		}

		d.drawText(g);
		d.drawLines(g);
	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException {

		cont.update(gc, delta, board);

		for (Droid droid : board.getDroids()) {
			droid.update(gc, delta, board);
		}

		board.findCollision();
	}

}
