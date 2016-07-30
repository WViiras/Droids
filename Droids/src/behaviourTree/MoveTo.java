package behaviourTree;

import org.newdawn.slick.GameContainer;

import main.Droid;
import main.Main;

public class MoveTo extends Routine {

	final protected float destX;
	final protected float destY;
	final float EPSILON = 0.1f;

	public MoveTo(float destX, float destY) {
		super();
		this.destX = destX;
		this.destY = destY;
	}

	public void reset() {
		start();
	}

	@Override
	public void act(Droid droid, int delta, GameContainer gc) {
		if (isRunning()) {
			if (!droid.isAlive()) {
				fail();
				return;
			}
			if (!isDroidAtDestination(droid)) {
				moveDroid(droid, delta);
			}
		}
	}

	private void moveDroid(Droid droid, int delta) {

		float dist = droid.speed * delta;

		if (droid.getX() != destX) {
			if (destX > droid.getX()) {
				droid.setX(droid.getX() + dist);
			} else {
				droid.setX(droid.getX() - dist);
			}
		}
		if (droid.getY() != destY) {
			if (destY > droid.getY()) {
				droid.setY(droid.getY() + dist);
			} else {
				droid.setY(droid.getY() - dist);
			}
		}
		Main.d.add("x", droid.getX());
		Main.d.add("y", droid.getY());
		Main.d.add("destX", destX);
		Main.d.add("destY", destY);

		if (isDroidAtDestination(droid)) {
			succeed();
		}

	}

	private boolean isDroidAtDestination(Droid droid) {

		if(Math.abs(destX-droid.getX())<EPSILON&&Math.abs(destY-droid.getY())<EPSILON)
			return true;
		
//		if (Float.compare(destX, droid.getX()) == 0 && Float.compare(destY, droid.getY()) == 0)
//			return true;

		return false;
	}

}
