package test;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JPanel {
	
	Ball ball = new Ball(this);
	
	
	
	@Override
	public void paint (Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		ball.paint(g2d);
	}
	
	public void update() {
		ball.moveBall();
	}
	
	public void newGame() {
		ball.setPOSX(0);
		ball.setPOSY(0);
		ball.setVELX(1);
		ball.setVELY(1);
	}
	
	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("Pong");
		Main main = new Main();
		frame.add(main);
		frame.getContentPane().setPreferredSize(new Dimension(600,600));
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.newGame();
		
		while (true) {
			main.update();
			main.repaint();
			Thread.sleep(10);
		}
	}
}
