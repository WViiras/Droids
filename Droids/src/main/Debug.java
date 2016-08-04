package main;

import java.util.LinkedHashMap;
import java.util.Map;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class Debug {

	private LinkedHashMap<String, Object> text;
	private LinkedHashMap<String, Object[]> line;

	public Debug() {
		text = new LinkedHashMap<String, Object>();
		line = new LinkedHashMap<String, Object[]>();
	}

	public void addText(String s, Object o) {
		text.put(s, o);
	}

	public void addLine(String name, Vector2 a, Vector2 b) {
		Object[] line = new Object[] { a, b, Color.gray };
		this.line.put(name, line);
	}

	public void addLine(String name, Vector2 a, Vector2 b, Color color) {
		Object[] line = new Object[] { a, b, color };
		this.line.put(name, line);
	}

	public void drawText(Graphics g) {
		g.setColor(Color.white);

		float renderHeight = 64;
		float renderStep = 16;

		for (Map.Entry<String, Object> entry : text.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();

			g.drawString(key + ": " + value, renderStep, renderHeight);
			renderHeight += renderStep;
		}
	}

	public void drawTextRelative(Graphics g, Entity e) {
		float renderHeight = (float) (e.getY() + e.size);
		float renderStep = 16;

		for (Map.Entry<String, Object> entry : text.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();

			g.drawString(key + ": " + value, (float) e.getX(), renderHeight);
			renderHeight += renderStep;
		}
	}

	public void drawLines(Graphics g) {
		for (Map.Entry<String, Object[]> o : line.entrySet()) {

			String key = o.getKey();
			Object[] value = o.getValue();

			/*
			 * 0 name
			 * 1 color
			 * 2 A
			 * 3 B
			 */

			Vector2 a = (Vector2) value[0];
			Vector2 b = (Vector2) value[1];
			Color color = (Color) value[2];

			g.setColor(color);
			g.drawLine((float) a.getX(), (float) a.getY(), (float) b.getX(), (float) b.getY());

		}
	}
}
