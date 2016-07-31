package main;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import behaviourTree.Routine;

public class Droid {

	/* FIELD */
	private String name;
	private Vector2 loc;
	private double rotation;

	private double size;

	private double maxSpeed;
	private double speed;

	private Routine routine;
	public Debug debug;

	/* GET SET */

	public double getX() {
		return loc.getX();
	}

	public void setX(double x) {
		loc.setX(x);
	}

	public double getY() {
		return loc.getY();
	}

	public void setY(double y) {
		loc.setY(y);
	}

	public Vector2 getLoc() {
		return loc;
	}

	public void setLoc(double x, double y) {
		loc.setLocation(x, y);
	}

	public double getRotation() {
		return rotation;
	}

	public void setRotation(double rotation) {
		this.rotation = rotation;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public double getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(double maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	/* CONSTRUCTOR */
	public Droid() {
		this(-1);
	}

	public Droid(int id) {
		this(id, 0f, 0f);
	}

	public Droid(int id, double x, double y) {
		loc = new Vector2(x, y);

		size = 25;
		setMaxSpeed(0.15f);
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
		// TODO Auto-generated method stub
		return true;
	}

}
