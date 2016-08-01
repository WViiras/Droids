package main;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import behaviourTree.Routine;

public class Droid {

	public Debug debug;

	/* FIELDS */
	public int id;
	public String name;

	public Vector2 loc;
	public double rotation;

	public Routine routine;

	public double size;
	public double maxSpeed;
	public double speed;

	public double vision;
	public double range;

	private int health;

	/* GET SET */

	public double getX() {
		return loc.getX();
	}

	public double getY() {
		return loc.getY();
	}

	public void setLoc(double x, double y) {
		loc.setLocation(x, y);
	}

	/* CONSTRUCTOR */
	public Droid() {
		this(-1);
	}

	public Droid(int id) {
		this(id, 0f, 0f);
	}

	public Droid(int id, double x, double y) {
		this.id = id;
		this.name = "droid " + String.valueOf(id);

		this.loc = new Vector2(x, y);

		this.size = 25;
		this.maxSpeed = 0.15f;
		this.speed = maxSpeed;

		this.health = 100;

		this.debug = new Debug();
	}

	public void render(GameContainer gc, Graphics g) {
		renderDroid(g);
		renderDebug(g);
	}

	public void update(GameContainer gc, int delta, Board board) {
		if (routine.getState() == null) {
			routine.start();
		}

		routine.act(this, delta, board);
	}

	private void renderDroid(Graphics g) {
		g.setColor(Color.lightGray);

		float xLoc = (float) (loc.getX() - size / 2);
		float yLoc = (float) (loc.getY() - size / 2);

		g.fillOval(xLoc, yLoc, (float) size, (float) size);
	}

	public void renderDebug(Graphics g) {
		debug.addText("name", name);
		debug.addText("x", loc.getX());
		debug.addText("y", loc.getY());
		debug.addText("speed", speed);
		debug.drawTextRelative(g, this);
		debug.drawLines(g);
	}

	public void setRoutine(Routine routine) {
		this.routine = routine;
	}

	public boolean isAlive() {
		if (health < 0)
			return false;
		return true;
	}

}
