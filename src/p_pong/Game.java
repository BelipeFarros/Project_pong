package p_pong;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable {
	
	private static final long serialVersionUID = 1L;
	
	//Constants
	public static int WIDTH = 120, HEIGHT = 220, SCALE = 3;
	
	//Constructor method
	public Game() {
		this.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
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
		
	}
	
	public void run() {
		
	}

}
