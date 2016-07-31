package main;

public class Vector2 {

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

		double aTan2 = Math.atan2(deltaX, deltaY) * 180 / Math.PI;

		if ((target.getX() > this.getX())) {
			return aTan2;
		} else if ((target.getX() < this.getX())) {
			return 360 - aTan2;
		}

		return Math.atan2(0, 0);
	}

}
