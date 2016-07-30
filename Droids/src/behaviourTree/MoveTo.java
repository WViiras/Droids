package behaviourTree;

import main.Board;
import main.Droid;

public class MoveTo extends Routine {

	final protected float destX;
	final protected float destY;
	final float EPSILON = 1f;

	public MoveTo(float destX, float destY) {
		super();
		this.destX = destX;
		this.destY = destY;
	}

	public void reset() {
		start();
	}

	@Override
	public void act(Droid droid, int delta, Board board) {
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

		if (isDroidAtDestination(droid)) {
			succeed();
		}

	}

	private boolean isDroidAtDestination(Droid droid) {

		if(Math.abs(destX-droid.getX())<EPSILON&&Math.abs(destY-droid.getY())<EPSILON)
			return true;
		}

		return false;
	}

}
