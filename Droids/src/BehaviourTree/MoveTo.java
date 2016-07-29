package BehaviourTree;

import main.Droid;

public class MoveTo extends Routine {

	final protected float destX;
	final protected float destY;

	public MoveTo(float destX, float destY) {
		this.destX = destX;
		this.destY = destY;
	}

	@Override
	public void reset() {
		start();
	}

	@Override
	public void act(Droid droid, int delta) {
		if (isRunning()) {
			if (!droid.isAlive()) {
				fail();
				return;
			}
			if (!droidAtDestination(droid))
				moveDroid(droid, delta);
		}
	}

	private void moveDroid(Droid droid, int delta) {

		float dist = droid.speed * delta;

		// if droid x is not destX
		if (droid.x != destX)
			if (destX > droid.x)
				droid.x += dist;
			else
				droid.x -= dist;

		// if droid y is not destY
		if (droid.y != destY)
			if (destY > droid.y)
				droid.y += dist;
			else
				droid.y -= dist;

		if (droidAtDestination(droid))
			succeed();

	}

	private boolean droidAtDestination(Droid droid) {
		return droid.x == destX && droid.y == destY;
	}

}
