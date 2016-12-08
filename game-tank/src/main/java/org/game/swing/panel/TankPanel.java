package org.game.swing.panel;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import org.game.bullet.bulletimpl.Bullet;
import org.game.bullet.bulletimpl.HeroBullet;
import org.game.directed.Directed;
import org.game.tank.tankimpl.AbstractTank;
import org.game.tank.tankimpl.HeroTank;

public class TankPanel extends JPanel implements KeyListener,Runnable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2560572891911813949L;
	public static int width;
	public static int height;
	
	
	
	private int keyCode;
	
	private AbstractTank heroTank ;
	private Bullet bullet;
	
	public TankPanel(int width,int height){
		TankPanel.width = width;
		TankPanel.height = height;
		this.setSize(width, height);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Image img = this.createImage(this.width, this.height);
		Graphics gr = img.getGraphics();
		
		heroTank = HeroTank.getTankInstance();
		heroTank.draw(keyCode,heroTank,gr);
		if(heroTank.isFired() && bullet == null){
			bullet = heroTank.getBullet();
			bullet.draw(gr);
		}else if(bullet != null){
			bullet.redraw(gr);
			bullet.flying();
			if(bullet.ifCollisionWall()){
				bullet = null;
				heroTank.setFired(false);
			}
		}
//		if(heroTank.ifCollisionWall()){
//			 Directed directed = heroTank.stop();
//		}
		
		g.drawImage(img, 0, 0, this);
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()){
		case KeyEvent.VK_S:
			this.keyCode = e.getKeyCode();
			heroTank.move(this.keyCode);
			break;
		case KeyEvent.VK_A:
			this.keyCode = e.getKeyCode();
			heroTank.move(this.keyCode);
			break;
		case KeyEvent.VK_W:
			this.keyCode = e.getKeyCode();
			heroTank.move(this.keyCode);
			break;
		case KeyEvent.VK_D:
			this.keyCode = e.getKeyCode();
			heroTank.move(this.keyCode);
			break;
		case KeyEvent.VK_J://开火
			this.keyCode = e.getKeyCode();
			heroTank.fire();
			break;
		}
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void run() {
		while(true){
			try {
				repaint();
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
