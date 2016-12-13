package org.game.swing.panel;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;

public class TankGameFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7378612313400226797L;
	
	public TankGameFrame(){
		super("坦克大战");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(700,500);
		this.setVisible(true);
		Container ct = this.getContentPane();
		TankPanel tp = new TankPanel(ct.getWidth(),ct.getHeight());
		this.add(tp);
		this.addKeyListener(tp);
		this.setBackground(Color.gray);
		new Thread(tp).start();
	}
	
}
