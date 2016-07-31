package main;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

import behaviourTree.*;

public class Controller {

	Input input;
	public float mX, mY;
	Board board;

	public Controller(Board board) {
		this.board = board;
	}

	public void update(GameContainer gc, int delta, Board board) {
		input = gc.getInput();
		mX = input.getMouseX();
		mY = input.getMouseY();

		if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
			createDroid(board);
		}
		if (input.isMousePressed(Input.MOUSE_RIGHT_BUTTON)) {
			for (Droid droid : board.getDroids()) {
				droid.setRoutine(new MoveTo(mX - droid.getSize() / 2, mY - droid.getSize() / 2));
			}
		}
	}

	private void createDroid(Board board) {
		// mouse offset
		Droid d = new Droid(board.id);
		d.setX(mX);
		d.setY(mY);

		d.setRoutine(new Repeat(new Wander(board)));

//		d.setRoutine(new Stand());

		board.addDroid(d);
	}

	public void render(GameContainer gc, Graphics g) {
		Main.d.add("mX", mX);
		Main.d.add("mY", mY);
	}

}
