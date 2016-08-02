package behaviourTree;

import java.util.concurrent.TimeUnit;

import main.Board;
import main.Droid;

public class Stand extends Routine {

	private long startTime;
	private long waitTime;

	public Stand(int i) {
		super();
		this.waitTime = i;
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

		long waitNano = TimeUnit.NANOSECONDS.convert(waitTime, TimeUnit.SECONDS);

		long estTime = System.nanoTime() - startTime;

//		droid.debug.addText("estTime", TimeUnit.SECONDS.convert(estTime, TimeUnit.NANOSECONDS));

		if (Long.compare(estTime, waitNano) >= 0) {
			return true;
		}

		return false;
	}
}
