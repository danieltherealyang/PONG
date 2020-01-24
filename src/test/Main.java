package test;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main extends JPanel {
	Ball ball = new Ball(this);
	Bar bar = new Bar(this);
	
	boolean dead = false;
	static final int FRAME_WIDTH = 600;
	static final int FRAME_HEIGHT = 600;
	int ball_posx;
	int ball_posy;
	int ball_velx;
	int ball_vely;
	int ball_width = ball.getBallWidth();
	int ball_height = ball.getBallHeight();
	
	int bar_width = bar.getBarWidth();
	int bar_left;
	int bar_right;
	int bar_height = FRAME_HEIGHT - 50 - ball_width;
	int score = -1;
	JLabel L;
	
	public Main() {
		L = new JLabel("Score: 0");
		add(L);
	}
	
	@Override
	public void paint (Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		ball.paint(g2d);
		bar.paint(g2d);
	}
	
	public void updateBall() {
		ball.moveBall();
		ball_posx = ball.getPOSX();
		ball_posy = ball.getPOSY();
		ball_velx = ball.getVELX();
		ball_vely = ball.getVELY();
		
		if (ball_posx >= FRAME_WIDTH - ball_width || ball_posx <= 0) {
			ball.setVELX(-ball_velx);
		}
		
		if (ball_posy == 0) {
			ball.setVELY(-ball_vely);
		}
		
		if (ball_posy == bar_height && ball_posx > bar_left + ball_width/4 && ball_posx < bar_right - ball_width/4 ) {
			ball.setVELY(-ball_vely);
		}
		
		if (ball_velx > 0 && ball_posy == bar_height && ball_posx <= bar_left + ball_width/4 && ball_posx >= bar_left - ball_width) {
			ball.setVELY(-ball_vely/2);
			ball.setVELX(-ball_velx*2);
		}
		
		if (ball_velx < 0 && ball_posy == bar_height && ball_posx <= bar_right + ball_width && ball_posx >= bar_right - ball_width/4) {
			ball.setVELY(-ball_vely/2);
			ball.setVELX(-ball_velx*2);
		}
		
		if (ball_posy == FRAME_HEIGHT) {
			deathScreen();
		}
		
		if (ball_posy == bar_height) {
			score = score + 1;
			L.setText("Score: " + score);
		}
		
		if (score != 0 && score % 5 == 0 && ball_velx < 0) {
			ball.setVELX(ball_velx - 1);
		}
		
		if (score != 0 && score % 5 == 0 && ball_velx > 0) {
			ball.setVELX(ball_velx + 1);
		}
		
		if (score != 0 && score % 5 == 0 && ball_vely > 0) {
			ball.setVELY(ball_vely + 1);
		}
		
		if (score != 0 && score % 5 == 0 && ball_vely < 0 ) {
			ball.setVELY(ball_vely - 1);
		}
	}
	
	public int getFrameWidth() {
		return FRAME_WIDTH;
	}
	
	public int getFrameHeight() {
		return FRAME_HEIGHT;
	}
	
	public void updateBar() {
		bar_left = bar.getPOSX();
		bar_right = bar.getPOSX() + bar.getBarWidth();
		Point p = MouseInfo.getPointerInfo().getLocation();
		bar.setPOSX(p.x);
	}
	
	public void newGame() {
		ball.setPOSX(FRAME_WIDTH/2 - ball.getBallWidth()/2);
		ball.setPOSY(0);
		ball.setVELX(1);
		ball.setVELY(2);
		
		bar.setPOSX(FRAME_WIDTH/2 - bar.getBarWidth()/2);
		bar.setPOSY(FRAME_HEIGHT - 50);
	}
	
	public void deathScreen() {
		JFrame DeathFrame = new JFrame();
		JLabel ded = new JLabel("You are dead");
		DeathFrame.add(ded);
		DeathFrame.setSize(400, 200);
		DeathFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		DeathFrame.setVisible(true);
		JButton restart = new JButton("Restart");
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
			main.updateBar();
			main.updateBall();
			main.repaint();
			Thread.sleep(10);
			
			
		}
	}
}
