package behaviourTree;

import java.util.Random;

import org.newdawn.slick.GameContainer;
import main.Droid;

public class Wander extends Routine {

	private static Random random = new Random();
	private final GameContainer gc;
	private MoveTo moveTo;

	public Wander(GameContainer gc) {
		super();
		this.gc = gc;
		this.moveTo = new MoveTo(random.nextInt(gc.getWidth()-100), random.nextInt(gc.getHeight()-100));
	}

	@Override
	public void start() {
		super.start();
		this.moveTo.start();
	}

	public void reset() {
		this.moveTo = new MoveTo(random.nextInt(gc.getWidth()), random.nextInt(gc.getHeight()));
	}

	@Override
	public void act(Droid droid, int delta, GameContainer gc) {
		if (!moveTo.isRunning()) {
			return;
		}
		this.moveTo.act(droid, delta, gc);
		if (this.moveTo.isSuccess()) {
			succeed();
		} else if (this.moveTo.isFailure()) {
			fail();
		}
	}
}
