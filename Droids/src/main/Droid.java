package main;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import BehaviourTree.MoveTo;
import BehaviourTree.Routine;

//import BehaviourTree.Routine;

public class Droid {

	public float x, y, destX, destY;
	public float size;

	public float range;
	public int health;
	public int damage;
	public float speed;

	public Droid() {
		this(0f, 0f);
	}

	public Droid(float x, float y) {
		this.x = x;
		this.y = y;
		size = 25;
		health = 100;
		damage = 5;
		speed = 0.1f;
		destX = this.x;
		destY = this.y;
	}

	public void render(GameContainer gc, Graphics g) {
		renderDroid(g);
	}

	public void update(GameContainer gc, int delta) {
		Routine moveTo = new MoveTo(destX, destY);
		if (moveTo.getState() == null) {
			moveTo.start();
		}
		moveTo.act(this, delta);
	}

	private void renderDroid(Graphics g) {
		g.setColor(Color.lightGray);
		g.fillOval(x, y, size, size);
	}

	public boolean isAlive() {
		return true;
	}

}
