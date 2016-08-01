package behaviourTree;

import main.Board;
import main.Droid;

public class Stand extends Routine {

	private long startTime;
	private long waitTime;

	public Stand(int i) {
		super();
		this.waitTime = i * 1000000000;
	}

	public void start() {
		super.start();
		startTime = System.nanoTime();
	}

	@Override
	public void reset() {
		start();
	}

	@Override
	public void act(Droid droid, int delta, Board board) {
		if (timeIsPassed()) {
			succeed();
		}
	}

	public boolean timeIsPassed() {
		long estTime = System.nanoTime() - startTime;

		if (Long.compare(estTime, waitTime) >= 0) {
			return true;
		}

		return false;
	}
}
