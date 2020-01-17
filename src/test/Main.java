package test;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JPanel {
	static int FRAME_WIDTH = 600;
	static int FRAME_HEIGHT = 600;
	Ball ball = new Ball(this);
	
	@Override
	public void paint (Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		ball.paint(g2d);
	}
	
	public void update() {
		ball.moveBall();
		int ball_posx = ball.getPOSX();
		int ball_posy = ball.getPOSY();
		int ball_velx = ball.getVELX();
		int ball_vely = ball.getVELY();
		int ball_width = ball.getBallWidth();
		int ball_height = ball.getBallHeight();
		
		if (ball_posx == FRAME_WIDTH - ball_width || ball_posx == 0) {
			ball.setVELX(-ball_velx);
		}
		System.out.println("position: " + ball_posx);
		
		
	}
	
	public void newGame() {
		ball.setPOSX(0);
		ball.setPOSY(0);
		ball.setVELX(5);
		ball.setVELY(1);
	}
	
	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("Pong");
		Main main = new Main();
		frame.add(main);
		frame.getContentPane().setPreferredSize(new Dimension(FRAME_WIDTH,FRAME_HEIGHT));
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
