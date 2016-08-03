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
		droid.id = ++id;
	}

	public void findCollision() {

		for (Droid droid1 : droids) {
			for (Droid droid2 : droids) {
				if (droid1.collides(droid2)) {
					if (droid1.equals(droid2)) {
						break;
					}
					droid1.routine=new Wander(this);
					droid2.routine=new Wander(this);
				}
			}
		}
	}
}
