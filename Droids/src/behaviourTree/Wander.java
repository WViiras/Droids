package behaviourTree;

import java.util.Random;

import main.Board;
import main.Droid;

public class Wander extends Routine {

	private Board board;
	private static Random random = new Random();
	private MoveTo moveTo;
	private Stand stand;

	public Wander(Board board) {
		super();
		this.board = board;
		reset();
	}

	@Override
	public void start() {
		super.start();
		this.moveTo.start();
	}

	public void reset() {
		this.moveTo = new MoveTo(random.nextInt(board.width), random.nextInt(board.height));
	}

	@Override
	public void act(Droid droid, int delta, Board board) {

		if (!moveTo.isRunning()) {
			return;
		}

		this.moveTo.act(droid, delta, board);

		if (this.moveTo.isSuccess()) {
			succeed();
		} else if (this.moveTo.isFailure()) {
			fail();
		}
	}
}
