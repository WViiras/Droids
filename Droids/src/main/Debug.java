package main;

import java.util.LinkedHashMap;
import java.util.Map;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class Debug {

	private LinkedHashMap<String, Object> text;
	private LinkedHashMap<String, Vector2[]> line;

	public Debug() {
		text = new LinkedHashMap<String, Object>();
		line = new LinkedHashMap<String, Vector2[]>();
	}

	public void addText(String s, Object o) {
		text.put(s, o);
	}

	public void addLine(String s, Vector2 a, Vector2 b) {
		Vector2[] line = new Vector2[2];
		line[0] = a;
		line[1] = b;

		this.line.put(s, line);
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
		for (Map.Entry<String, Vector2[]> entry : line.entrySet()) {
			String key = entry.getKey();
			Vector2[] value = entry.getValue();

			g.setColor(getColor(key));
			g.drawLine((float) value[0].x, (float) value[0].y, (float) value[1].x, (float) value[1].y);

		}
	}
	
	private Color getColor(String s) {

		if (s.equals("red")) {
			return Color.red;
		}

		return Color.gray;
	}
}
