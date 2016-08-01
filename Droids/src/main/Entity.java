package main;

public abstract class Entity {

	public Debug debug;

	/* FIELDS */
	public int id;

	public Vector2 loc;
	public double rotation;

	public double size;

	public double getX() {
		return loc.getX();
	}

	public double getY() {
		return loc.getY();
	}

	public void setLoc(double x, double y) {
		loc.setLocation(x, y);
	}

	public Entity() {
		this(-1);
	}

	public Entity(int id) {
		this(id, 0d, 0d);
	}

	public Entity(int id, double x, double y) {
		this.id = id;
		loc = new Vector2(x, y);
		size = 0;
	}

	public Entity(int id, double x, double y, double size) {
		this(id, x, y);
		this.size = size;
	}
}
