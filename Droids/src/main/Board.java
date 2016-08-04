package main;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.GameContainer;

public class Board {

	public final int width;
	public final int height;
	public int id;

	public List<Droid> droids;
	private Physics physics;

	public Board(GameContainer gc) {
		this.width = gc.getWidth();
		this.height = gc.getHeight();
		this.droids = new ArrayList<Droid>();
		this.id = -1;
		this.physics = new Physics(this);
	}

	public void update(GameContainer gc, int delta) {
		physics.update(gc, delta);
	}

	public List<Droid> getDroids() {
		return droids;
	}

	public void addDroid(Droid droid) {
		droids.add(droid);
		droid.id = ++id;
	}

	public void findCollision() {

	}
}
