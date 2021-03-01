package p_pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Ball {
	
	public double x,y;
	public int width, height;
	
	public double dx,dy, speed = 2.5;
	
	public Ball(int x, int y) {
		this.x = x;
		this.y = y;
		this.width = 4;
		this.height = this.width;
		
		int angle = new Random().nextInt(135 - 45) + 45;
		
		dx = Math.cos(Math.toRadians(angle));
		dy = Math.sin(Math.toRadians(angle));
	}
	
	public void tick() {
		
		//Inverter quando bate na parede
		if(x + dx*speed + width >= Game.WIDTH | x + dx*speed <= 0) dx*= -1;
		
		if(y >= Game.HEIGHT) {
			Game.enemy.point++;
			Game.player.makePoint = true;
			makePoint();
		}else if(y <= 0) {
			Game.player.point++;
			Game.enemy.makePoint = true;
			makePoint();
		}
		
		Rectangle bounds = new Rectangle((int)(x+(dx*speed)), (int)(y+(dy*speed)),width,height);
		Rectangle boundsPlayer = new Rectangle(Game.player.x,Game.player.y,Game.player.width,Game.player.height);
		Rectangle boundsEnemy = new Rectangle((int)Game.enemy.x,(int)Game.enemy.y,Game.enemy.width,Game.enemy.height);
		
		if(bounds.intersects(boundsPlayer)) {
			int angle = 0;
			if(Game.player.rigth) {
				angle = new Random().nextInt(15) + 45;
			} else if(Game.player.left){
				angle = 135 - new Random().nextInt(15);
			} else {
				angle = new Random().nextInt(135 - 45) + 45;
			}
			
			
			dx = Math.cos(Math.toRadians(angle));
			dy = Math.sin(Math.toRadians(angle));
			
			if(dy > 0) dy *= -1;
		}else if(bounds.intersects(boundsEnemy)) {
			int angle = new Random().nextInt(135 - 45) + 45;
			
			dx = Math.cos(Math.toRadians(angle));
			dy = Math.sin(Math.toRadians(angle));
			
			if(dy < 0) dy *= -1;
		}
		
		x+= dx*speed;
		y+= dy*speed;
	}
	
	public void render(Graphics g) {
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect((int)x, (int)y, width, height);
	}
	
	private void makePoint() {
		int angle = new Random().nextInt(135 - 45) + 45;
		dx = Math.cos(Math.toRadians(angle));
		if(Game.player.makePoint) dy = Math.sin(Math.toRadians(angle)) * -1;
		else if(Game.enemy.makePoint) dy = Math.sin(Math.toRadians(angle));
		
		Game.player.makePoint = false;
		Game.enemy.makePoint = false;
		
		this.x = Game.WIDTH/2;
		this.y = Game.HEIGHT/2;
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Game.player.x = Game.WIDTH/2 - 20;
		Game.enemy.x = Game.player.x;
	}
}
