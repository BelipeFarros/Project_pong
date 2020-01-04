package p_pong;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable, KeyListener {
	
	private static final long serialVersionUID = 1L;
	
	//Constants
	public static int WIDTH = 120, HEIGHT = 180, SCALE = 3;
	
	//
	public BufferedImage layer = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
	
	//Classes
	public static Player player;
	public static Enemy enemy;
	public static Ball ball;
	
	//Constructor method
	public Game() {
		this.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		this.addKeyListener(this);
		player = new Player(Game.WIDTH/2 - 20, Game.HEIGHT - 10);
		enemy = new Enemy(Game.WIDTH/2 - 20, 5);
		ball = new Ball(Game.WIDTH/2, Game.HEIGHT/2);
	}
	
	public static void main(String[] Args) {
		
		Game game = new Game();
		
		JFrame frame = new JFrame("Pong game!");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(game);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		new Thread(game).start();
		
	}
	
	public void tick() {
		player.tick();
		enemy.tick();
		ball.tick();
	}
	
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = layer.getGraphics();
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		player.render(g);
		enemy.render(g);
		ball.render(g);
		
		g = bs.getDrawGraphics();
		g.drawImage(layer, 0, 0, WIDTH*SCALE, HEIGHT*SCALE, null);
		
		bs.show();
	}
	
	public void run() {
		requestFocus();
		while(true) {
			tick();
			render();
			try {
				Thread.sleep(1000/60);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.rigth = true;
		} else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			player.left = true;
		} else if(e.getKeyCode() == KeyEvent.VK_R) {
			new Game();
		}
	}

	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.rigth = false;
		} else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			player.left = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}

}
