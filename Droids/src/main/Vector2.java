package main;

public class Vector2 {

	/* FIELD */

	private double x, y;

	/* GET SET */

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public void setLocation(double x, double y) {
		this.x = x;
		this.y = y;
	}

	/* CONSTRUCTOR */

	public Vector2() {
		this(0f, 0f);
	}

	public Vector2(double x, double y) {
		this.x = x;
		this.y = y;
	}

}
