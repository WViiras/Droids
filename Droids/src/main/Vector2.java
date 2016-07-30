package main;

public class Vector2 {

	/* FIELD */

	private float x, y;

	/* GET SET */

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

	public void setLocation(float x, float y) {
		this.x = x;
		this.y = y;
	}

	/* CONSTRUCTOR */

	public Vector2() {
		this(0f, 0f);
	}

	public Vector2(float x, float y) {
		this.x = x;
		this.y = y;
	}

}
