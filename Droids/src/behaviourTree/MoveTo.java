package behaviourTree;

import main.Board;
import main.Droid;
import main.Vector2;

public class MoveTo extends Routine {

	final protected Vector2 dest;

	final double EPSILON = 3f;

	public MoveTo(double destX, double destY) {
		super();
		this.dest = new Vector2(destX, destY);
	}

	public void reset() {
		start();
	}

	@Override
	public void act(Droid droid, int delta, Board board) {
		droid.debug.add("destX", dest.getX());
		droid.debug.add("destY", dest.getY());
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

		double newX = droid.getX();
		double newY = droid.getY();

		double speed = droid.getSpeed() * delta;

		if (droid.getX() != dest.getX()) {
			if (dest.getX() > droid.getX()) {
				newX=droid.getX() + speed;
			} else {
				newX=droid.getX() - speed;
			}
		}
		if (droid.getY() != dest.getY()) {
			if (dest.getY() > droid.getY()) {
				newY=droid.getY() + speed;
			} else {
				newY=droid.getY() - speed;
			}
		}

		droid.setX(newX);
		droid.setY(newY);

		if (isDroidAtDestination(droid)) {
			succeed();
		}

	}

	private boolean isDroidAtDestination(Droid droid) {

		if (Math.abs(dest.getX() - droid.getX()) < EPSILON && Math.abs(dest.getY() - droid.getY()) < EPSILON) {
			return true;
		}

		return false;
	}

}
