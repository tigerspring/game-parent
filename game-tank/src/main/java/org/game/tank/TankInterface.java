package org.game.tank;

import javax.swing.ImageIcon;

import org.game.bullet.bulletimpl.Bullet;
import org.game.tank.tankimpl.AbstractTank;

public interface TankInterface {

	public void move(int type);
	
	public Bullet fire();
	
	public ImageIcon draw(int type,AbstractTank tank);
	
	public void load();
	
	public void died();
	
	
}
