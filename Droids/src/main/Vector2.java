package main;

public class Vector2 {

	private final double degToRad = Math.PI / 180;
	private final double radToDeg = 180 / Math.PI;

	/* FIELD */

	public double x, y;

	/* GET SET */

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
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

	public double getAngle(Vector2 target) {

		double deltaX = target.getX() - this.getX();
		double deltaY = this.getY() - target.getY();

		double theta = Math.atan2(deltaY, deltaX) * radToDeg;

		if (theta < 0)
			theta += 360;
		return theta;
	}

}
