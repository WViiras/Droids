package main;

import org.newdawn.slick.GameContainer;

import behaviourTree.*;

public class Physics {

	private Board board;

	public Physics(Board board) {
		this.board = board;
	}

	public void update(GameContainer gc, int delta) {
		findCollision();
	}

	private void findCollision() {

		for (int i = 0; i < board.droids.size(); i++) {
			for (int j = i + 1; j < board.droids.size(); j++) {

				Droid droid1 = board.droids.get(i);
				Droid droid2 = board.droids.get(j);

				if (droid1.collides(droid2)) {
					double x1 = droid1.getX() + 20 * Math.cos(droid1.angle + 180);
					double y1 = droid1.getY() + 20 * Math.sin(droid1.angle + 180);
					double x2 = droid2.getX() + 20 * Math.cos(droid1.angle + 180);
					double y2 = droid2.getY() + 20 * Math.sin(droid1.angle + 180);
					Vector2 d1NLoc = new Vector2(x1, y1);
					Vector2 d2NLoc = new Vector2(x2, y2);

					droid1.routineQ.add(new MoveTo(d1NLoc));
					droid1.routineQ.add(new Repeat(new Wander(board)));

					droid2.routineQ.add(new MoveTo(d2NLoc));
					droid2.routineQ.add(new Repeat(new Wander(board)));

//					droid1.routine = new Repeat(new MoveTo(d1NLoc));
//					droid2.routine = new Repeat(new MoveTo(d2NLoc));
				}
			}
		}
	}
}
