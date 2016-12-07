package org.game.bullet.bulletimpl;

import java.awt.Graphics;

import javax.swing.ImageIcon;

import org.game.tank.tankimpl.AbstractTank;

public class HeroBullet extends Bullet{

	private int speed = 10;
	
	private ImageIcon bulletImg;
	
	public HeroBullet(ImageIcon herotankImg,ImageIcon bulletImg,AbstractTank tank){
		this.x = (herotankImg.getIconWidth()-bulletImg.getIconWidth())/2 + tank.getX();
		this.y = herotankImg.getIconHeight() + tank.getY();
		this.bulletImg = bulletImg;
	}
	
	public void run() {
		while(true){
			try {
				flying();
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void flying() {
		System.out.println("this.y---"+this.y);
		this.y = this.y + speed ;
	}

	public void redraw(Graphics gr){
		draw(gr);
	}
	public void redraw(){
		draw(this.gr);
	}
	@Override
	public void draw(Graphics gr) {
		System.out.println(this.bulletImg.getImage()+"-----"+this.x+"----"+this.y);
		this.gr = gr;
		System.out.println("this.gr==>"+this.gr);
		this.gr.drawImage(this.bulletImg.getImage(), this.x, this.y, null);
	}

}
