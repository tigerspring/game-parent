package org.game.bullet.bulletimpl;

import org.game.bullet.BulletInterface;

public abstract class Bullet implements BulletInterface,Runnable {

	protected int speed;
	
	protected int x,y;

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
	
	
}
