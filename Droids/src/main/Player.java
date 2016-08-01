package main;

import org.newdawn.slick.GameContainer;

public class Player extends Droid {

	public Player(double x, double y) {
		this(-1, x, y);
	}

	public Player(int id, double x, double y) {
		super(id, x, y);
	}

	public void update(GameContainer gc, int delta, Board board) {

	}

}
