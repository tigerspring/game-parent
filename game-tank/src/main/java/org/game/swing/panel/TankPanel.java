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
		
		tank = HeroTank.getTankInstance();
		tank.draw(keyCode,tank,gr);
		System.out.println(tank.isFired());
		if(tank.isFired() && bullet == null){
			bullet = tank.getBullet();
			bullet.draw(gr);
			new Thread(bullet).start();
		}
		if(bullet != null){
			bullet.redraw();
		}
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
		this.keyCode = e.getKeyCode();
		switch(this.keyCode){
		case KeyEvent.VK_S:
			tank.move(this.keyCode);break;
		case KeyEvent.VK_A:
			tank.move(this.keyCode);break;
		case KeyEvent.VK_W:
			tank.move(this.keyCode);break;
		case KeyEvent.VK_D:
			tank.move(this.keyCode);break;
		case KeyEvent.VK_J:
			tank.fire();break;
		}
		repaint();
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void run() {
		while(true){
			try {
				repaint();
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
