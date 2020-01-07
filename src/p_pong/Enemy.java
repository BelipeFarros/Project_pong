package p_pong;

import java.awt.Color;
import java.awt.Graphics;

public class Enemy {
	
	public double x,y;
	public int width, height, point;
	
	public Enemy(int x, int y) {
		this.x = x;
		this.y = y;
		this.width = 40;
		this.height = 5;
		this.point = 0;
	}
	
	public void tick() {
		x += (Game.ball.x - x - 6) * 0.1;
		
		if(x + width > Game.WIDTH) {
			x = Game.WIDTH - this.width;
		}
		
		if(x <= 0) {
			x = 0;
		}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect((int)x, (int)y, width, height);
	}
}
