package main;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import behaviourTree.Routine;

public class Droid extends Entity {

	public Routine routine;

	public String name;

	public double maxSpeed;
	public double speed;

	public double vision;
	public double range;

	private int health;

	/* CONSTRUCTOR */

	public Droid(double x, double y) {
		this(-1, x, y);
	}

	public Droid(int id, double x, double y) {
		super(id, x, y);

		this.name = "droid ";

		this.size = 25;
		this.maxSpeed = 0.1f;
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
		debug.addText(name, id);
//		debug.addText("x", loc.getX());
//		debug.addText("y", loc.getY());
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
