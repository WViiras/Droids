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
		droid.debug.addLine(String.valueOf(droid.id), droid.loc, dest);
//		droid.debug.addText("destX", dest.getX());
//		droid.debug.addText("destY", dest.getY());
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

		double angle = droid.loc.getAngle(dest);

		double newX = droid.getX();
		double newY = droid.getY();

		double velocity = droid.speed * delta;

		double sin = Math.sin(angle);
		double cos = Math.cos(angle);

//		droid.debug.addText("sin", sin);
//		droid.debug.addText("cos", cos);

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

		droid.setLoc(newX, newY);

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
