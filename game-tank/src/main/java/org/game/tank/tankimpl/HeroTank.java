package org.game.tank.tankimpl;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import org.game.bullet.bulletimpl.Bullet;
import org.game.bullet.bulletimpl.HeroBullet;
import org.game.directed.Directed;
import org.game.swing.panel.TankPanel;
import org.game.tank.TankInterface;

public class HeroTank extends AbstractTank implements Runnable{
	
	private static HeroTank heroTank;
	
	private Directed soptDirected;
	
	private Bullet bullet;
	
	private ImageIcon herotank;
	
	private HeroTank(){};
	
	public static synchronized AbstractTank getTankInstance(){
		if(heroTank == null){
			return heroTank = new HeroTank();
		}
		return heroTank;
	}
	
	public void move(int type) {
		if(!ifCollisionWall()){
			this.speed = 5;
			switch(type){
			case KeyEvent.VK_S:
				this.y = this.y + speed;
				break;
			case KeyEvent.VK_A: 
				this.x = this.x - speed;
				break;
			case KeyEvent.VK_D: 
				this.x = this.x + speed;
				break;
			case KeyEvent.VK_W: 
				this.y = this.y - speed;
				break;
			}
		}
	}

	public void fire() {
		this.isFired = true;
	}
	
	public Bullet getBullet(){
		ImageIcon bulletImg = null; 
		switch(directed){
		case SOUTH:
			bulletImg = new ImageIcon("images/bullet03.png");
			break;
		case WEST: 
			bulletImg = new ImageIcon("images/bullet00.png");
			break;
		case EAST: 
			bulletImg = new ImageIcon("images/bullet02.png");
			break;
		case NORTH: 
			bulletImg = new ImageIcon("images/bullet01.png");
			break;
		}
		bullet = new HeroBullet(herotank, bulletImg,heroTank);
		return bullet;
	}

	public void draw(int type,AbstractTank tank,Graphics gr) {
		this.gr = gr;
		switch(type){
		case KeyEvent.VK_S:
			directed = Directed.SOUTH;
			herotank = new ImageIcon("images/playertank14.png");
			break;
		case KeyEvent.VK_A: 
			directed = Directed.WEST;
			herotank = new ImageIcon("images/playertank11.png");
			break;
		case KeyEvent.VK_D: 
			directed = Directed.EAST;
			herotank = new ImageIcon("images/playertank13.png");
			break;
		case KeyEvent.VK_W: 
			directed = Directed.NORTH;
			herotank = new ImageIcon("images/playertank12.png");
			break;
		default :
			if(herotank == null){
				directed = Directed.SOUTH;
				herotank = new ImageIcon("images/playertank14.png");
			}
		}
		this.gr.drawImage(herotank.getImage(),tank.getX(),tank.getY(), null);
	}

	public void load() {
		
	}

	public void died() {
		heroTank = null;
		this.isDied = true;
	}

	public void run() {
		
	}

	public Directed stop() {
		this.speed = 0;
		return this.directed;
	}

	public boolean ifCollisionWall() {
		if(this.x < 0 ){
			this.x = this.x + speed;
			return true;
		}
		if(this.x >= TankPanel.width-herotank.getIconWidth()){
			this.x = this.x - speed ;
			return true;
		}
		if(this.y < 0){
			this.y = this.y + speed;
			return true;
		}
		if(this.y >= (TankPanel.height - herotank.getIconHeight())){
			this.y = this.y - speed;
			return true;
		}
		return false;
	}
	

}
