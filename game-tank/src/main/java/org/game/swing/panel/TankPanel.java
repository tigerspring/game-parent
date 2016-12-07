package org.game.swing.panel;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import org.game.bullet.bulletimpl.Bullet;
import org.game.bullet.bulletimpl.HeroBullet;
import org.game.tank.tankimpl.AbstractTank;
import org.game.tank.tankimpl.HeroTank;

public class TankPanel extends JPanel implements KeyListener,Runnable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2560572891911813949L;
	private int width;
	private int height;
	
	
	
	private int keyCode;
	
	private AbstractTank tank ;
	private Bullet bullet;
	
	public TankPanel(int width,int height){
		this.width = width;
		this.height = height;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Image img = this.createImage(this.width, this.height);
		Graphics gr = img.getGraphics();
		
		tank = HeroTank.getTankInstance(gr);
		ImageIcon herotank = tank.draw(keyCode,tank);
		gr.drawImage(herotank.getImage(),tank.getX(),tank.getY(), null);
		
		
		
//		ImageIcon bulletImg = new ImageIcon("images/bullet03.png");
//		
//		if(bullet == null){
//			bullet = new HeroBullet(herotankImg, bulletImg);
//			gr.drawImage(bulletImg.getImage(),(herotankImg.getIconWidth()-bulletImg.getIconWidth())/2,herotankImg.getIconHeight(), null);
//			new Thread(bullet).start();
//		}
//		gr.drawImage(bulletImg.getImage(),bullet.getX(),bullet.getY(), this);
		g.drawImage(img, 0, 0, this);
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_S||e.getKeyCode()==KeyEvent.VK_A||e.getKeyCode()==KeyEvent.VK_W||e.getKeyCode()==KeyEvent.VK_D)
			tank.move(e.getKeyCode());
		if(e.getKeyCode()==KeyEvent.VK_J)
			tank.fire();
		this.keyCode = e.getKeyCode();
		repaint();
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void run() {
		while(true){
			try {
				repaint();
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
