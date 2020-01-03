package p_pong;

import java.awt.Color;
import java.awt.Graphics;

public class Player {
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(60 - 40/2, 220-20, 40, 10);
	}
}
