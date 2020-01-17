package test;

import java.awt.Graphics2D;

public class Ball {
	private int VELOCITY_X;
	private int VELOCITY_Y;
	private int POSITION_X;
	private int POSITION_Y;
	private final int BALL_WIDTH = 30;
	private final int BALL_HEIGHT = 30;
	private Main main;
	
	public Ball(Main main) {
		this.main = main;
	}
	
	public void newGame() {
		VELOCITY_X = 1;
		VELOCITY_Y = 1;
		POSITION_X = 0;
		POSITION_Y = 0;
	}
	
	public void moveBall() {
		POSITION_X = POSITION_X + VELOCITY_X;
		POSITION_Y = POSITION_Y + VELOCITY_Y;
	}
	
	
	public void paint(Graphics2D g2d) {
		g2d.fillOval(POSITION_X, POSITION_Y, BALL_WIDTH, BALL_HEIGHT);
	}
	
	public void setVELX(int velX) {
		VELOCITY_X = velX;
	}
	
	public void setVELY(int velY) {
		VELOCITY_Y = velY;
	}
	
	public void setPOSX(int posX) {
		POSITION_X = posX;
	}
	
	public void setPOSY(int posY) {
		POSITION_Y = posY;
	}
}
