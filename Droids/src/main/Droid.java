package main;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import behaviourTree.Routine;

public class Droid {

	private String name;
	private float x, y;
	public float size;

	private float speed;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public Droid() {
		this(-1);
	}

	public Droid(int id) {
		this(id, 0f, 0f);
	}

	public Droid(int id, float x, float y) {
		this.x = x;
		this.y = y;
		size = 25;
		setSpeed(0.1f);
		debug = new Debug();
		this.name = String.valueOf(id);
	}

	public void render(GameContainer gc, Graphics g) {
		renderDroid(g);
		renderDebug(g);
	}

	private void renderDebug(Graphics g) {
		debug.add("name", name);
		debug.add("x", x);
		debug.add("y", y);
		debug.droidDraw(g, this);
	}

	public void update(GameContainer gc, int delta, Board board) {
		if (routine.getState() == null) {
			routine.start();
		}

		routine.act(this, delta, board);
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
