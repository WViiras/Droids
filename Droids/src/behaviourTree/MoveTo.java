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

		double angle = droid.getLoc().getAngle(dest);

		double newX = droid.getX();
		double newY = droid.getY();

		double velocity = droid.getSpeed() * delta;

		double sin = Math.sin(angle);
		double cos = Math.cos(angle);

		droid.debug.add("sin", sin);
		droid.debug.add("cos", cos);

		if (droid.getX() != dest.getX()) {

			if (dest.getX() > droid.getX()) {
				newX -= velocity * sin;
			} else {
				newX += velocity * sin;
			}
		}
		if (droid.getY() != dest.getY()) {
			if (dest.getY() > droid.getY()) {
				newY += velocity * cos;
			} else {
				newY -= -velocity * cos;
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
