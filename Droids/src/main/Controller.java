package main;

import java.util.List;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

import behaviourTree.MoveTo;
import behaviourTree.Repeat;
import behaviourTree.Wander;

public class Controller {

	Input input;
	public float mX, mY;
	List<Droid> droids;

	public Controller(List<Droid> droids) {
		this.droids = droids;
	}

	public void update(GameContainer gc, int d) {
		input = gc.getInput();
		mX = input.getMouseX();
		mY = input.getMouseY();

		if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
			createDroid(gc);
		}
		if (input.isMousePressed(Input.MOUSE_RIGHT_BUTTON)) {
			for (Droid droid : droids) {
				droid.setRoutine(new MoveTo(mX, mY));
			}
		}
	}

	private void createDroid(GameContainer gc) {
		// mouse offset
		Droid d = new Droid();
		d.setX(mX);
		d.setY(mY);

		d.setRoutine(new Repeat(new Wander(gc)));
		
//		d.setRoutine(new Wander(gc));

		droids.add(d);
	}

	public void render(GameContainer gc, Graphics g) {
		Main.d.add("mX", mX);
		Main.d.add("mY", mY);
	}

}
