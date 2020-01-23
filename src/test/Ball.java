package test;

import java.awt.Graphics2D;

public class Ball {
	private int VELOCITY_X;
	private int VELOCITY_Y;
	private int POSITION_X;
	private int POSITION_Y;
	private final int BALL_WIDTH = 30;
	private final int BALL_HEIGHT = 30;
	private boolean dead = false;
	private Main main;
	
	public Ball(Main main) {
		this.main = main;
	}
	
	public void moveBall() {
		POSITION_X = POSITION_X + VELOCITY_X;
		POSITION_Y = POSITION_Y + VELOCITY_Y;
	}
	
	public void paint(Graphics2D g2d) {
		g2d.fillOval(POSITION_X, POSITION_Y, BALL_WIDTH, BALL_HEIGHT);
	}
	
	public int getVELX() {
		return VELOCITY_X;
	}
	
	public int getVELY() {
		return VELOCITY_Y;
	}
	
	public int getPOSX() {
		return POSITION_X;
	}
	
	public int getPOSY() {
		return POSITION_Y;
	}
	
	public int getBallWidth() {
		return BALL_WIDTH;
	}
	
	public int getBallHeight() {
		return BALL_HEIGHT;
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
