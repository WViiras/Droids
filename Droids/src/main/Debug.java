package main;

import java.util.LinkedHashMap;
import java.util.Map;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class Debug {

	public LinkedHashMap<String, Object> debug;

	public Debug() {
		debug = new LinkedHashMap<String, Object>();
	}

	public void add(String s, Object o) {
		debug.put(s, o);
	}

	public void draw(Graphics g) {
		g.setColor(Color.white);

		float renderHeight = 64;
		float renderStep = 16;

		for (Map.Entry<String, Object> entry : debug.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();

			g.drawString(key + ": " + value, renderStep, renderHeight);
			renderHeight += renderStep;
		}
	}

	public void droidDraw(Graphics g, Droid d) {

		float renderHeight = (float) (d.getY() + d.size);
		float renderStep = 16;

		Vector2 dest = new Vector2();

		for (Map.Entry<String, Object> entry : debug.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();

			g.drawString(key + ": " + value, (float) d.getX(), renderHeight);
			renderHeight += renderStep;

			if (key.equals("destX")) {
				dest.x = (double) value;
			}
			if (key.equals("destY")) {
				dest.y = (double) value;
			}

		}

		g.drawLine((float) d.getX(), (float) d.getY(), (float) dest.getX(), (float) dest.getY());
	}
}
