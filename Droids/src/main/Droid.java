package main;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import behaviourTree.Routine;

//import BehaviourTree.Routine;

public class Droid {

	private float x, y;
	public float size;

	public float speed;

	Routine routine;

	Debug debug;

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public Droid() {
		this(0f, 0f);
	}

	public Droid(float x, float y) {
		this.x = x;
		this.y = y;
		size = 25;
		speed = 0.1f;
		debug = new Debug();
	}

	public void render(GameContainer gc, Graphics g) {
		renderDroid(g);
	}

	public void update(GameContainer gc, int delta) {
		if (routine.getState() == null) {
			routine.start();
		}

		routine.act(this, delta, gc);
	}

	public void setRoutine(Routine routine) {
		this.routine = routine;
	}

	private void renderDroid(Graphics g) {
		g.setColor(Color.lightGray);
		g.fillOval(x, y, size, size);
	}

	public boolean isAlive() {
		return true;
	}

}
