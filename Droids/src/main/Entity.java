package main;

public abstract class Entity {

	public Debug debug;

	/* FIELDS */
	public int id;

	public Vector2 loc;
	public double rotation;

	public double size;
	public double maxSpeed;
	public double speed;

	public int health;

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

	public Entity(int id) {
		this(id, 0d, 0d);
	}

	public Entity(int id, double x, double y) {
		this.id = id;

		this.loc = new Vector2(x, y);
		this.rotation = 0;

		this.size = 0;
		this.maxSpeed = 0;
		this.speed = 0;

		this.health = 100;
	}

	public boolean isAlive() {
		if (health < 0)
			return false;
		return true;
	}
}
