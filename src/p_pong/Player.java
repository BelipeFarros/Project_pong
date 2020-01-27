package p_pong;

import java.awt.Color;
import java.awt.Graphics;

public class Player {
	
	public int x, y, width, height, point;
	public boolean rigth, left, makePoint = false;
	
	public Player(int x, int y) {
		this.x = x;
		this.y = y;
		this.width = 40;
		this.height = 5;
		this.point = 0;
	}
	
	public void tick() {
		if(rigth) {
			x++;
		}else if(left) {
			x--;
		}
		
		if(x + width > Game.WIDTH) {
			x = Game.WIDTH - this.width;
		}
		
		if(x <= 0) {
			x = 0;
		}
		
		
	}
	
	public void render(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(x, y, width, height);
	}
}
