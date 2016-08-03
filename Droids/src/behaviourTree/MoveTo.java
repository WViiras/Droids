package behaviourTree;

import main.Board;
import main.Droid;
import main.Vector2;

public class MoveTo extends Routine {

	final protected Vector2 dest;
	double destAngle;

	public MoveTo(Vector2 target) {
		super();
		this.dest = target;
		destAngle = Double.MAX_VALUE;
	}

	public void reset() {
		start();
	}

	@Override
	public void act(Droid droid, int delta, Board board) {
		if (Double.compare(destAngle, Double.MAX_VALUE) == 0) {
			destAngle = droid.loc.getAngle(dest);
		}

		droid.debug.addText("destAngle", destAngle);
		droid.debug.addLine(String.valueOf(droid.id), droid.loc, dest);

		if (this.isRunning()) {
//			if (Double.compare(droid.angle, destAngle) == 0) {
				if (droidIsAtDestination(droid)) {
					succeed();
					return;
				} else {
					moveDroid(droid, delta);
				}
//			} else {
				rotateDroid(droid, delta);
//			}
		}
	}

	private void moveDroid(Droid droid, int delta) {

		// new locations to move to. starts from current position
		double newX = droid.getX();
		double newY = droid.getY();

		// angle between droid location and destination
		droid.angle = droid.loc.getAngle(dest);

		double velocity = droid.speed * delta;

		newX += Math.sin(droid.angle) * velocity;
		newY += Math.cos(droid.angle) * velocity;

		droid.setLoc(newX, newY);

		if (droidIsAtDestination(droid)) {
			succeed();
		}

	}

	private void rotateDroid(Droid droid, int delta) {

		droid.debug.addText("droidAngle", droid.angle);

		// TODO rotate left

		// TODO rotate right

		droid.debug.addText("droidAngle", droid.angle);
	}

	private boolean droidIsAtDestination(Droid droid) {

		double EPSILON = 3d;
		double xDist = Math.abs(dest.getX() - droid.getX());
		double yDist = Math.abs(dest.getY() - droid.getY());

		return xDist < EPSILON && yDist < EPSILON;
	}

}
