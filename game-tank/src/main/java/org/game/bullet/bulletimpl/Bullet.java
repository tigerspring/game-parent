package org.game.bullet.bulletimpl;

import java.awt.Graphics;

import org.game.bullet.BulletInterface;
import org.game.directed.Directed;

public abstract class Bullet implements BulletInterface {

	protected int speed;
	
	protected int x,y;
	
	protected Directed directed;
	

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public abstract void draw(Graphics gr);
	public abstract void redraw(Graphics gr);
	public abstract boolean ifCollisionWall();
	
	
}
