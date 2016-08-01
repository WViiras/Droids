package main;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.GameContainer;

public class Board {

	public final int width;
	public final int height;
	public int id;

	public List<Droid> droids;

	public Board(GameContainer gc) {
		width = gc.getWidth();
		height = gc.getHeight();
		droids = new ArrayList<Droid>();
		id = -1;
	}

	public List<Droid> getDroids() {
		return droids;
	}

	public void addDroid(Droid droid) {
		droids.add(droid);
	}

	public void addDroid(int id, Droid droid) {
		addDroid(droid);
	}

	public int nextId() {
		return ++id;
	}
}
