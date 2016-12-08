package org.game.bullet.bulletimpl;

import java.awt.Graphics;

import javax.swing.ImageIcon;

import org.game.swing.panel.TankPanel;
import org.game.tank.tankimpl.AbstractTank;

public class HeroBullet extends Bullet{

	private int speed = 30;
	
	private ImageIcon bulletImg;
	
	public HeroBullet(ImageIcon herotankImg,ImageIcon bulletImg,AbstractTank tank){
		this.directed = tank.getDirected();
		this.bulletImg = bulletImg;
		switch(tank.getDirected()){
		case SOUTH:
			this.x = (herotankImg.getIconWidth()-bulletImg.getIconWidth())/2 + tank.getX();
			this.y = herotankImg.getIconHeight() + tank.getY();
			break;
		case EAST:
			this.x = herotankImg.getIconWidth() + tank.getX();
			this.y = (herotankImg.getIconHeight()-bulletImg.getIconHeight())/2 + tank.getY();
			break;
		case WEST:
			this.x = tank.getX() - herotankImg.getIconWidth() ;
			this.y = (herotankImg.getIconHeight()-bulletImg.getIconHeight())/2 + tank.getY();
			break;
		case NORTH:
			this.x = (herotankImg.getIconWidth()-bulletImg.getIconWidth())/2 + tank.getX();
			this.y = tank.getY() - herotankImg.getIconHeight();
			break;
		}
	}
	
	public void flying() {
		switch(this.directed){
		case SOUTH:
			this.y = this.y + speed ;
			break;
		case EAST:
			this.x = this.x + speed ;
			break;
		case WEST:
			this.x = this.x - speed ;
			break;
		case NORTH:
			this.y = this.y - speed ;
			break;
		}
		
	}

	public void redraw(Graphics gr){
		draw(gr);
	}
	@Override
	public void draw(Graphics gr) {
		gr.drawImage(this.bulletImg.getImage(), this.x, this.y, null);
	}
	
	public boolean ifCollisionWall(){
		if(this.y<0 || this.y > TankPanel.height 
				|| this.x < 0 || this.x > TankPanel.width) {
			return true;
		}
		return false;
	}

}
