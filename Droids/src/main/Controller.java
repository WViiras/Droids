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
				droid.setRoutine(new MoveTo(new Vector2(mX - droid.size / 2, mY - droid.size / 2)));
			}
		}

		if (input.isKeyPressed(Input.KEY_A)) {
			for (Droid droid : board.getDroids()) {
				droid.speed += 0.01;
			}
		} else if (input.isKeyPressed(Input.KEY_D)) {
			for (Droid droid : board.getDroids()) {
				droid.speed -= 0.01;
			}
		}
	}

	private void createDroid(Board board) {
		// mouse offset
		Droid d = new Droid(mX, mY);

		d.setRoutine(new Repeat(new Wander(board)));

//		d.setRoutine(new Stand());

		board.addDroid(d);
	}

	public void render(GameContainer gc, Graphics g) {
		Main.d.addText("mX", mX);
		Main.d.addText("mY", mY);
	}

}
