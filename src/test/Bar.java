package test;

import java.awt.Graphics2D;

public class Bar {
	private final int BAR_WIDTH = 60;
	private final int BAR_HEIGHT = 15;
	private int POSITION_X;
	private int POSITION_Y;
	private Main main;
	
	public Bar(Main main) {
		this.main = main;
	}
	
	public void paint(Graphics2D g2d) {
		g2d.fillRect(POSITION_X, POSITION_Y, BAR_WIDTH, BAR_HEIGHT);
	}
	
	public int getPOSX() {
		return POSITION_X;
	}
	
	public int getPOSY() {
		return POSITION_Y;
	}
	
	public void setPOSX(int posX) {
		POSITION_X = posX;
	}
	
	public void setPOSY(int posY) {
		POSITION_Y = posY;
	}
	
	public int getBarWidth() {
		return BAR_WIDTH;
	}
	
	public int getBarHeight() {
		return BAR_HEIGHT;
	}
}
