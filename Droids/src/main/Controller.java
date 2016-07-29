package main;

import java.util.List;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

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
			createDroid();
		}
		if(input.isMousePressed(Input.MOUSE_RIGHT_BUTTON)){
			for(Droid droid: droids){
				droid.destX=mX;
				droid.destY=mY;
			}
		}
	}

	private void createDroid() {
		// mouse offset
		Droid d = new Droid();
		d.x = mX;
		d.y = mY;

		droids.add(d);
	}

	public void render(GameContainer gc, Graphics g) {
		Main.d.add("mX", mX);
		Main.d.add("mY", mY);
	}

}
