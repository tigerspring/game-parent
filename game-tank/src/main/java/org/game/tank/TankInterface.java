package org.game.tank;

import java.awt.Graphics;

import org.game.tank.tankimpl.AbstractTank;

public interface TankInterface {

	public void move(int type);
	
	public void fire();
	
	public void draw(int type,AbstractTank tank,Graphics gr);
	
	public void load();
	
	public void died();
	
	
}
