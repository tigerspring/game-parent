package org.game.tank.tankimpl;

import java.awt.Graphics;

import javax.swing.ImageIcon;

import org.game.bullet.bulletimpl.Bullet;
import org.game.directed.Directed;
import org.game.tank.TankInterface;

public abstract class AbstractTank implements TankInterface{
	
	protected int x=0;//坦克的位置

	protected int y=0;
	
	protected Bullet bullet;
	
	protected boolean isDied;
	
	protected boolean isFired = false;
	
	protected Integer speed = 0;
	
	protected ImageIcon herotank = null;
	
	protected Directed directed;
	
	protected Graphics gr;

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

	public boolean isFired() {
		return isFired;
	}

	public void setFired(boolean isFired) {
		this.isFired = isFired;
	}
	
	public abstract Bullet getBullet();

	public Directed getDirected() {
		return directed;
	}

	public void setDirected(Directed directed) {
		this.directed = directed;
	}
	
	
	
}
