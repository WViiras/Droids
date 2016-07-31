package main;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import behaviourTree.Routine;

public class Droid {

	/* FIELD */
	private String name;
	public Vector2 loc;
	private float rotation;

	private float size;
	private float maxSpeed;
	private float speed;

	Routine routine;
	public Debug debug;

	/* GET SET */

	public float getX() {
		return loc.getX();
	}

	public void setX(float x) {
		loc.setX(x);
	}

	public float getY() {
		return loc.getY();
	}

	public void setY(float y) {
		loc.setY(y);
	}

	public Vector2 getLoc() {
		return loc;
	}

	public void setLoc(float x, float y) {
		loc.setLocation(x, y);
	}

	public float getRotation() {
		return rotation;
	}

	public void setRotation(float rotation) {
		this.rotation = rotation;
	}

	public float getSize() {
		return size;
	}

	public void setSize(float size) {
		this.size = size;
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

	public float getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(float maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	/* CONSTRUCTOR */
	public Droid() {
		this(-1);
	}

	public Droid(int id) {
		this(id, 0f, 0f);
	}

	public Droid(int id, float x, float y) {
		loc = new Vector2(x, y);

		size = 25;
		setMaxSpeed(0.1f);
		setSpeed(getMaxSpeed());
		debug = new Debug();
		this.name = String.valueOf(id);
	}

	public void render(GameContainer gc, Graphics g) {
		renderDroid(g);
		renderDebug(g);
	}

	private void renderDebug(Graphics g) {
		debug.add("name", name);
		debug.add("x", loc.getX());
		debug.add("y", loc.getY());
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
		g.fillOval((float) (loc.getX() - size / 2), (float) (loc.getY() - size / 2), (float) size, (float) size);
	}

	public boolean isAlive() {
		return true;
	}

}
