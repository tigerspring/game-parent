package org.game.bullet.bulletimpl;

import javax.swing.ImageIcon;

public class HeroBullet extends Bullet{

	private int speed = 10;
	
	private ImageIcon bulletImg;
	
	public HeroBullet(ImageIcon herotankImg,ImageIcon bulletImg){
		this.x = (herotankImg.getIconWidth()-bulletImg.getIconWidth())/2;
		this.y = herotankImg.getIconHeight();
		this.bulletImg = bulletImg;
	}
	
	public void run() {
		while(true){
			try {
				flying();
				Thread.sleep(80);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void flying() {
		this.y = this.y + speed ;
	}

}
