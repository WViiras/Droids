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

	public double getAngle(Vector2 target) {

		double deltaX = target.getX() - this.getX();
		double deltaY = this.getY() - target.getY();

		if ((target.getX() > this.getX())) {
			return (Math.atan2(deltaX, deltaY) * 180 / Math.PI);
		} else if ((target.getX() < this.getX())) {
			return 360 - (Math.atan2(deltaX, deltaY) * 180 / Math.PI);
		}

//
//		double thetaRad = Math.atan2(deltaX, deltaY);
//
//		double angle = (double) Math.toDegrees(Math.atan2(deltaX, deltaY));
//
//		while (angle < 0) {
//			angle += 360;
//		}
//
		return Math.atan2(0, 0);
	}

}
