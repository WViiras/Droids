package main;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import behaviourTree.Routine;

public class Droid extends Entity {

	public Routine routine;

	/* CONSTRUCTOR */

	public Droid(double x, double y) {
		this(-1, x, y);
	}

	public Droid(int id, double x, double y) {
		super(id, x, y);

		this.size = 25;
		this.maxSpeed = 0.1f;
		this.speed = maxSpeed;

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

		float xLoc = (float) (getX() - size / 2);
		float yLoc = (float) (getY() - size / 2);

		g.fillOval(xLoc, yLoc, (float) size, (float) size);
	}

	public void renderDebug(Graphics g) {
		debug.addText("id", id);
//		debug.addText("x", loc.getX());
//		debug.addText("y", loc.getY());
		debug.addText("speed", speed);
		debug.drawTextRelative(g, this);
		debug.drawLines(g);
	}

	public boolean collides(Entity e) {
		double r1 = this.size / 2;
		double r2 = this.size / 2;

		double dist = this.loc.distanceTo(e.loc);

		return Double.compare(dist, r1 + r2) < 0;
	}

	public void setRoutine(Routine routine) {
		this.routine = routine;
	}
}
